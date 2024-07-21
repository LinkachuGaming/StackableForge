# Stackable

Stackable is a mod that increases all block stacking limits to any value less than 2147483647 for Minecraft 1.20.5

# Why 127?

As of Stackable 1.1.4 and Minecraft 1.20.5, this mod now can work with stack sizes above 127, however, for versions below 1.20.5, the following is still accurate.

Effectively, I'm lazy, but in reality, Minecraft stores all items with a single signed byte which for our purposes only can be between -128 to 127, since negative values are invalid that leaves a maximum stack size of 127. Moreover, this mod is intended to be compatible with other mods which may also use signed bytes to store items.

# Why make this mod
I don't know, this was more for experimentation with creating mixins and understanding Minecraft's code a little better.

# Will you update to X?
Maybe.

# Will you backport to X?
Eh, not really.

# There's a bug here?
I might fix bugs that are Vanilla specific, but mod compatibility is gonna be kinda hard to do 
