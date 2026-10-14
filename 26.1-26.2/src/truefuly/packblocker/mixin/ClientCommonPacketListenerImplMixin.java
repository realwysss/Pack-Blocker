/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket
 *  net.minecraft.network.protocol.common.ServerboundResourcePackPacket
 *  net.minecraft.network.protocol.common.ServerboundResourcePackPacket$Action
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package truefuly.packblocker.mixin;

import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.network.protocol.common.ServerboundResourcePackPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ClientCommonPacketListenerImpl.class})
public abstract class ClientCommonPacketListenerImplMixin {
    @Shadow
    public abstract void send(Packet<?> var1);

    @Inject(method={"handleResourcePackPush"}, at={@At(value="HEAD")}, cancellable=true)
    private void packblocker$blockServerResourcePack(ClientboundResourcePackPushPacket packet, CallbackInfo callbackInfo) {
        callbackInfo.cancel();
        this.send((Packet<?>)new ServerboundResourcePackPacket(packet.id(), ServerboundResourcePackPacket.Action.ACCEPTED));
        this.send((Packet<?>)new ServerboundResourcePackPacket(packet.id(), ServerboundResourcePackPacket.Action.DOWNLOADED));
        this.send((Packet<?>)new ServerboundResourcePackPacket(packet.id(), ServerboundResourcePackPacket.Action.SUCCESSFULLY_LOADED));
    }
}

