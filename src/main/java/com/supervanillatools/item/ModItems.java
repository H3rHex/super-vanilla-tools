package com.supervanillatools.item;
import com.supervanillatools.SuperVanillaTools;
import com.supervanillatools.item.pickaxe.*;
import com.supervanillatools.item.shovel.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item WOODEN_AREA_PICKAXE = register("wooden_area_pickaxe", WoodenAreaPickaxe::new, WoodenAreaPickaxe.getProperties());
    public static final Item WOODEN_AREA_SHOVEL = register("wooden_area_shovel", WoodenAreaShovel::new, WoodenAreaShovel.getProperties());
    public static final Item STONE_AREA_PICKAXE = register("stone_area_pickaxe", StoneAreaPickaxe::new, StoneAreaPickaxe.getProperties());
    public static final Item STONE_AREA_SHOVEL = register("stone_area_shovel", StoneAreaShovel::new, StoneAreaShovel.getProperties());
    public static final Item IRON_AREA_PICKAXE = register("iron_area_pickaxe", IronAreaPickaxe::new, IronAreaPickaxe.getProperties());
    public static final Item IRON_AREA_SHOVEL = register("iron_area_shovel", IronAreaShovel::new, IronAreaShovel.getProperties());
    public static final Item GOLD_AREA_PICKAXE = register("gold_area_pickaxe", GoldAreaPickaxe::new, GoldAreaPickaxe.getProperties());
    public static final Item GOLD_AREA_SHOVEL = register("gold_area_shovel", GoldAreaShovel::new, GoldAreaShovel.getProperties());
    public static final Item DIAMOND_AREA_PICKAXE = register("diamond_area_pickaxe", DiamondAreaPickaxe::new, DiamondAreaPickaxe.getProperties());
    public static final Item DIAMOND_AREA_SHOVEL = register("diamond_area_shovel", DiamondAreaShovel::new, DiamondAreaShovel.getProperties());
    public static final Item NETHERITE_AREA_PICKAXE = register("netherite_area_pickaxe", NetheriteAreaPickaxe::new, NetheriteAreaPickaxe.getProperties());
    public static final Item NETHERITE_AREA_SHOVEL = register("netherite_area_shovel", NetheriteAreaShovel::new, NetheriteAreaShovel.getProperties());

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SuperVanillaTools.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        SuperVanillaTools.LOGGER.info("Initializing ModItems");
    }
}