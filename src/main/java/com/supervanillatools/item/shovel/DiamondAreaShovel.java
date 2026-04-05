package com.supervanillatools.item.shovel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class DiamondAreaShovel extends BaseAreaShovel {
    public DiamondAreaShovel(Item.Properties properties) {
        super(properties, ToolMaterial.DIAMOND);
    }

    public static Item.Properties getProperties() {
        return BaseAreaShovel.getProperties(ToolMaterial.DIAMOND);
    }
}
