package com.samsthenerd.dyeables.items;

import com.samsthenerd.dyeables.api.IDyeProvider;

import net.minecraft.item.Item;

public abstract class AbstractDyeProviderItem extends Item implements IDyeProvider{
    public AbstractDyeProviderItem(Settings settings) {
        super(settings);
    }
}
