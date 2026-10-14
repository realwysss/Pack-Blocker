/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2720
 *  net.minecraft.class_2856
 *  net.minecraft.class_2856$class_2857
 *  net.minecraft.class_8673
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package truefuly.packblocker.mixin;

import net.minecraft.class_2596;
import net.minecraft.class_2720;
import net.minecraft.class_2856;
import net.minecraft.class_8673;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_8673.class})
public abstract class ClientCommonPacketListenerImplMixin {
    @Shadow
    public abstract void method_52787(class_2596<?> var1);

    @Inject(method={"method_52784"}, at={@At(value="HEAD")}, cancellable=true)
    private void packblocker$blockServerResourcePack(class_2720 packet, CallbackInfo callbackInfo) {
        callbackInfo.cancel();
        this.method_52787((class_2596<?>)new class_2856(packet.comp_2158(), class_2856.class_2857.field_13016));
        this.method_52787((class_2596<?>)new class_2856(packet.comp_2158(), class_2856.class_2857.field_47704));
        this.method_52787((class_2596<?>)new class_2856(packet.comp_2158(), class_2856.class_2857.field_13017));
    }
}

