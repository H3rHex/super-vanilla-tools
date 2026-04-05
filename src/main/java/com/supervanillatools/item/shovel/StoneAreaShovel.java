package com.supervanillatools.item.shovel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class StoneAreaShovel extends BaseAreaShovel {
    public StoneAreaShovel(Item.Properties properties) {
        super(properties, ToolMaterial.STONE);
    }

    public static Item.Properties getProperties() {
        return BaseAreaShovel.getProperties(ToolMaterial.STONE);
    }
}
