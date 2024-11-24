package com.lonkachu.stackable;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

public class StacksizeOverride {
    private String namespaceID;
    private int value;
    public StacksizeOverride(String namespaceID, int value)
    {
        this.namespaceID = namespaceID;
        this.value = value;
    }

    ResourceLocation GetIdentifier()
    {
        ResourceLocation location = ResourceLocation.bySeparator(namespaceID, ':');
        return location;
    }
    public int GetCount() { return value; }
}
