package com.samsthenerd.dyeables.expandedDyeing;

import com.samsthenerd.dyeables.mixin.MixinExposeDyeColorConstructor;

import net.minecraft.util.DyeColor;

public class BetterDyeColorHelper {

    public static final String BETTER_DYE_COLOR_KEY = "dyeables_dye_color";

    /*
     * returns a faked DyeColor object with the given color.
     * it *should* just default to the nearest real dye color if it's passed to 
     * something not meant to handle it, but avoid doing that if you can.
     */
    public static DyeColor makeDyeColor(int color){
        DyeColor closestRealColor = getNearestRealDye(color);
        return MixinExposeDyeColorConstructor.newDyeColor(closestRealColor.asString(), closestRealColor.ordinal(), closestRealColor.getId(), closestRealColor.getName(), color, closestRealColor.getMapColor(), color, color);
    }

    /*
     * returns the nearest real dye color to the given color.
     * so if color is a nice tea green, this would return lime green.
     */
    public static DyeColor getNearestRealDye(int color){
        double bestDiff = 10000000;
        DyeColor bestColor = null;
        float[] colorComponents = getColorComponents(color);
        for(DyeColor realColor : DyeColor.values()){
            double diff = 0;
            for(int i = 0; i < 3; i++){
                diff += Math.abs(colorComponents[i] - realColor.getColorComponents()[i]);
            }
            if(diff <= bestDiff){
                bestDiff = diff;
                bestColor = realColor;
            }
        }
        return bestColor;
    }

    /*
     * Yoinked from DyeColor constructor
     */
    public static float[] getColorComponents(int color){
        int j = (color & 16711680) >> 16;
        int k = (color & '\uff00') >> 8;
        int l = (color & 255) >> 0;
        return new float[]{(float)j / 255.0F, (float)k / 255.0F, (float)l / 255.0F};
    }

    public static int getHexColor(DyeColor color){
        return (int)(color.getColorComponents()[0]*255) << 16 | (int)(color.getColorComponents()[1]) << 8 | (int)(color.getColorComponents()[2]);
    }

    /*
     * returns true if the given DyeColor is a real dye color.
     */
    public static boolean isRealDye(DyeColor color){
        return DyeColor.byId(color.getId()) == color;
    }
}
