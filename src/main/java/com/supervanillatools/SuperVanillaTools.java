package com.supervanillatools;

import com.supervanillatools.event.BlockBreakHandler;
import com.supervanillatools.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.supervanillatools.item.ModItemGroups.CUSTOM_CREATIVE_TAB;
import static com.supervanillatools.item.ModItemGroups.CUSTOM_CREATIVE_TAB_KEY;

public class SuperVanillaTools implements ModInitializer {
	public static final String MOD_ID = "supervanillatools";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.initialize();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
        BlockBreakHandler.register();
    }
}