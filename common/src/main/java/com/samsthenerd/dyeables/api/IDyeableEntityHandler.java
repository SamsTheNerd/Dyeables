package com.samsthenerd.dyeables.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

/**
 * An interface for dyeing entities.
 * <p>
 * The easiest way to use this is to implement it on your entity class.
 * If you are attaching this to a entity from outside your mod or using Dyeables as an 
 * optional dependency then you can 
 * </p><p>
 * Note that this shouldn't modify anything outside of the entity itself.
 * </p>
 */
public interface IDyeableEntityHandler {
    /**
     * check if a entity can be dyed
     * @param entity entity to dye 
     * @param color color to dye the entity
     * @param stack itemstack to dye the entity - shouldn't be modified
     * @param user player using the itemstack to dye the entity
     * @param hand hand the itemstack is in
     * @return if the entity can be dyed in this context
     */
    public boolean canDye(Entity entity, int color, ItemStack stack, PlayerEntity user, Hand hand);

    /**
     * actually dye the entity
     * @param entity entity to dye 
     * @param color color to dye the entity
     * @param stack itemstack to dye the entity - shouldn't be modified
     * @param user player using the itemstack to dye the entity
     * @param hand hand the itemstack is in
     */
    public void dye(Entity entity, int color, ItemStack stack, PlayerEntity user, Hand hand);
}
