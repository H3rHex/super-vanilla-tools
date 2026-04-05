package com.supervanillatools.item.shovel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class IronAreaShovel extends BaseAreaShovel {
    public IronAreaShovel(Item.Properties properties) {
        super(properties, ToolMaterial.IRON);
    }

    public static Item.Properties getProperties() {
        return BaseAreaShovel.getProperties(ToolMaterial.IRON);
    }
}
