package com.samsthenerd.dyeables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.samsthenerd.dyeables.expandedDyeing.BetterDyeColorHelper;

import net.minecraft.util.DyeColor;

public class Dyeables {
    public static final String MOD_ID = "dyeables";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final void logPrint(String message) {
        LOGGER.info(message);
	}

    public static void init(){
        doingGarbageTests();
    }

    public static void doingGarbageTests(){
        DyeColor customColor = BetterDyeColorHelper.makeDyeColor(0x69eb96);
        int colorCount = 0;
        for (DyeColor color : DyeColor.values()){
            colorCount++;
        }
        logPrint("There are " + colorCount + " vanilla colors");
        logPrint("We also have (" + customColor.getColorComponents()[0]*255 + ", " + customColor.getColorComponents()[1]*255 + ", " + customColor.getColorComponents()[2]*255 + ")");
    }
}
