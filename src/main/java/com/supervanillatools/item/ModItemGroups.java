package com.supervanillatools.item;

import com.supervanillatools.SuperVanillaTools;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(SuperVanillaTools.MOD_ID, "creative_tab")
    );
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.IRON_AREA_PICKAXE))
            .title(Component.translatable("itemGroup.supervanillatools"))
            .displayItems((params, output) -> {
                output.accept(ModItems.WOODEN_AREA_PICKAXE);
                output.accept(ModItems.WOODEN_AREA_SHOVEL);
                output.accept(ModItems.STONE_AREA_PICKAXE);
                output.accept(ModItems.STONE_AREA_SHOVEL);
                output.accept(ModItems.IRON_AREA_PICKAXE);
                output.accept(ModItems.IRON_AREA_SHOVEL);
                output.accept(ModItems.GOLD_AREA_PICKAXE);
                output.accept(ModItems.GOLD_AREA_SHOVEL);
                output.accept(ModItems.DIAMOND_AREA_PICKAXE);
                output.accept(ModItems.DIAMOND_AREA_SHOVEL);
                output.accept(ModItems.NETHERITE_AREA_PICKAXE);
                output.accept(ModItems.NETHERITE_AREA_SHOVEL);
            })
            .build();
}