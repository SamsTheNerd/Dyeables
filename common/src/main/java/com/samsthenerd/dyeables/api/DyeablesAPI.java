package com.samsthenerd.dyeables.api;

import java.util.Collection;

import com.samsthenerd.dyeables.items.AbstractDyeProviderItem;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;

/**
 * Main API class for Dyeables.
 * <p>
 * Use {@link #registerDyeProvider(Item, IDyeProvider)} or implement {@link IDyeProvider} to add a new dye provider.
 * </p>
 */
public class DyeablesAPI {
    /**
     * Registers a dye provider.
     * 
     * <p>You don't need to register if you are extending {@link AbstractDyeProviderItem} 
     * or implementing {@link IDyeProvider} on your item</p>
     * @param item item to register a provider for
     * @param provider a {@link IDyeProvider} to handle dyeing from this item
     * @return if the provider was registered successfully
     */
    public static boolean registerDyeProvider(Item item, IDyeProvider provider){
        return false;
    }

    /**
     * Like {@link #registerDyeProvider(Item, IDyeProvider)} but for multiple items
     * @param items items to register a provider for
     * @param provider a {@link IDyeProvider} to handle dyeing from these items
     * @return if the provider was registered successfully for all items
     */
    public static boolean registerDyeProvider(Collection<? extends Item> items, IDyeProvider provider){
        boolean success = true;
        for (Item i : items){
            if(!registerDyeProvider(i, provider)) success = false;
        }
        return success;
    }

    /**
     * Gets the {@link IDyeProvider} associated with the given item, if it has one
     * <p> Note that normal vanilla-type dyes will not have a provider so you should handle those separately</p>
     * @param item item to get the provider of
     * @return the {@link IDyeProvider} for this item, or null if there is none
     */
    public static IDyeProvider getDyeProvider(Item item){
        return null;
    }

    /**
     * Registers a dyeable block entity handler.
     * 
     * <p>You don't need to register if you are implementing {@link IDyeableBlockEntityHandler} on your block entity</p>
     * @param type block entity type to register a handler for
     * @param handler handler to register
     * @return if the handler was registered successfully
     */
    public static boolean registerDyeableBlockEntityHandler(BlockEntityType<? extends BlockEntity> type, IDyeableBlockEntityHandler handler){
        return false;
    }
    
    /**
     * Like {@link #registerDyeableBlockEntityHandler(BlockEntityType, IDyeableBlockEntityHandler)} but for multiple block entity types
     * @param types block entity types to register a handler for
     * @param handler handler to register
     * @return if the handler was registered successfully
     */
    public static boolean registerDyeableBlockEntityHandler(Collection<? extends BlockEntityType<? extends BlockEntity>> types, IDyeableBlockEntityHandler handler){
        boolean success = true;
        for (BlockEntityType<? extends BlockEntity> t : types){
            if(!registerDyeableBlockEntityHandler(t, handler)) success = false;
        }
        return success;
    }

    /**
     * Gets the {@link IDyeableBlockEntityHandler} associated with the given block entity type, if it has one
     * @param type block entity type to get the handler of
     * @return the {@link IDyeableBlockEntityHandler} for this block entity type, or null if there is none
     */
    public static IDyeableBlockEntityHandler getDyeableBlockEntityHandler(BlockEntityType<? extends BlockEntity> type){
        return null;
    }
}
