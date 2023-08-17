package com.samsthenerd.dyeables.api;

import com.samsthenerd.dyeables.items.AbstractDyeProviderItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * An interface for items that can be used as dye.
 * <br>
 * <p>
 * The easiest way to use this is to simply implement the interface on your item class 
 * or extend {@link AbstractDyeProviderItem}.
 * </p><p>
 * If you're working with an item from outside your mod or using Dyeables as an optional dependency then you can
 * use {@link DyeablesAPI#registerDyeProvider(Item, IDyeProvider)} to register a provider for your item instead.
 * </p><p>
 * See {@link DyeablesAPI#getDyeProvider(Item)} to get the provider from an item.
 * </p>
 */
public interface IDyeProvider {
    /**
     * @param stack itemstack to get the color from
     * @return the dye color from the item stack in rgb/hex format
     */
    public int getColor(ItemStack stack);

    /**
     * should always be called before using the dye. Some items may have conditions for being 
     * used, such as being 'charged' 
     * 
     * <p>Should usually use {@link #canUseDye(ItemStack)} unless you are are dyeing multiple things at once</p>
     * @param stack itemstack to check
     * @param uses number of times the dye may be used
     * @return if the itemstack can be used as dye the specified number of times.
     */
    public boolean canUseDye(ItemStack stack, int uses);

    /**
     * @param stack itemstack to check
     * @return if the itemstack can be used as dye
     * @see #canUseDye(ItemStack, int)
     */
    default public boolean canUseDye(ItemStack stack){
        return canUseDye(stack, 1);
    }

    /**
     * uses the dye potentially multiple times - handles any cost
     * @param stack stack to be used
     * @param uses number of uses to use
     * @see #useDye(ItemStack)
     */
    public void useDye(ItemStack stack, int uses);

    /**
     * uses the dye 
     * @param stack stack to be used
     * @see #useDye(ItemStack, int)
     */
    default public void useDye(ItemStack stack){
        useDye(stack, 1);
    }
}
