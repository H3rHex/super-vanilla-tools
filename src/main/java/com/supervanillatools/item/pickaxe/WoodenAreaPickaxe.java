package com.supervanillatools.item.pickaxe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class WoodenAreaPickaxe extends BaseAreaPickaxe<ToolMaterial> {

    public WoodenAreaPickaxe(Item.Properties properties) {
        super(properties, ToolMaterial.WOOD);
    }

    public static Item.Properties getProperties() {
        return BaseAreaPickaxe.getProperties(ToolMaterial.WOOD);
    }
}