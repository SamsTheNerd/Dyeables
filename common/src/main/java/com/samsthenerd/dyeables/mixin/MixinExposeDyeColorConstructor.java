package com.samsthenerd.dyeables.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.MapColor;
import net.minecraft.util.DyeColor;

@Mixin(DyeColor.class)
public interface MixinExposeDyeColorConstructor {
    /*
     * Don't use this raw please
     */
    @Invoker("<init>")
    static DyeColor newDyeColor(String enumName, int enumOrdinal, int id, String name, int color, MapColor mapColor, int fireworkColor, int signColor) {
        throw new AssertionError();
    }
}
