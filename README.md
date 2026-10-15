<p align="center"><img src="icon.png" width="128"></p>

# Pack Blocker

blocks resource packs that a server forces on you, without loading them.

client side fabric mod. minecraft 1.21.11, 26.1 and 26.2.

the server is told the pack was accepted, downloaded and loaded, so it does not kick you for declining it. your own resource packs stay as they are.

## credits

the idea for this mod comes from Truefuly, who made the first version of it. this version is a new rewrite by wysss.

## download

| jar | minecraft |
|---|---|
| `pack-blocker-mc1.21.11-2.0.0.jar` | 1.21.11 |
| `pack-blocker-mc26.1-26.2-2.0.0.jar` | 26.1 to 26.2 |

on the releases page. fabric loader 0.16 or newer.

## how it works

a mixin on the part of the client that handles the resource pack message of the server. the message is cancelled, so nothing is downloaded or loaded, and the three answers a real client would send are sent back right away.

all rights reserved. made by wysss.
