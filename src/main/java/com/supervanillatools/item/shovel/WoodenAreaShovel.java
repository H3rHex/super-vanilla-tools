package com.supervanillatools.item.shovel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class WoodenAreaShovel extends BaseAreaShovel {
    public WoodenAreaShovel(Item.Properties properties) {
        super(properties, ToolMaterial.WOOD);
    }

    public static Item.Properties getProperties() {
        return BaseAreaShovel.getProperties(ToolMaterial.WOOD);
    }
}
