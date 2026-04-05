package com.supervanillatools.item.shovel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class GoldAreaShovel extends BaseAreaShovel {
    public GoldAreaShovel(Item.Properties properties) {
        super(properties, ToolMaterial.GOLD);
    }

    public static Item.Properties getProperties() {
        return BaseAreaShovel.getProperties(ToolMaterial.GOLD);
    }
}
