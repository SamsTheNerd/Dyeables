package com.samsthenerd.dyeables.api;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemUsageContext;

/**
 * An interface for dyeing block entities.
 * <p>
 * The easiest way to use this is to implement it on your block entity class.
 * If you are attaching this to a block entity from outside your mod or using Dyeables as an 
 * optional dependency then you can 
 * </p><p>
 * Note that this shouldn't modify anything outside of the block entity itself.
 * </p>
 */
public interface IDyeableBlockEntityHandler {
    /**
     * check if a block entity can be dyed
     * @param blockEntity block entity to dye 
     * @param color color to dye the block entity
     * @param context item usage context for more specifics. May be null if the dyeing is not from an item
     * @return if the block entity can be dyed in this context
     */
    public boolean canDye(BlockEntity blockEntity, int color, @Nullable ItemUsageContext context);

    /**
     * actually do the dyeing. 
     * @param blockEntity block entity to dye 
     * @param color color to dye the block entity
     * @param context item usage context for more specifics. May be null if the dyeing is not from an item
     */
    public void dye(BlockEntity blockEntity, int color, @Nullable ItemUsageContext context);
}
