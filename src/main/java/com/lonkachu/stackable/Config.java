package com.lonkachu.stackable;

import com.lonkachu.stackable.StacksizeOverride;

import java.util.ArrayList;
import java.util.Stack;


public class Config {
    private int maxStack;
    private ArrayList<StacksizeOverride> StacksizeOverride = new ArrayList<StacksizeOverride>();
    public Config(int maxCount) {
        maxStack = maxCount;
        StacksizeOverride.add(new StacksizeOverride("minecraft:egg", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:snowball", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:oak_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:spruce_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:birch_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:jungle_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:acacia_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:dark_oak_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:mangrove_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:cherry_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:bamboo_oak_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:oak_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:spruce_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:birch_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:jungle_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:acacia_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:dark_oak_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:mangrove_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:cherry_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:bamboo_wall_sign", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:honey_bottle", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:white_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:orange_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:magenta_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:light_blue_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:yellow_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:lime_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:pink_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:gray_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:light_gray_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:cyan_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:purple_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:blue_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:brown_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:green_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:red_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:black_banner", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:writable_book", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:ender_pearl", maxCount / 4));
        StacksizeOverride.add(new StacksizeOverride("minecraft:armor_stand", maxCount / 4));
    }

    public int getMaxStackSize() {
        return maxStack;
    }
    public ArrayList<StacksizeOverride> GetOverrides()
    {
        return StacksizeOverride;
    }
}