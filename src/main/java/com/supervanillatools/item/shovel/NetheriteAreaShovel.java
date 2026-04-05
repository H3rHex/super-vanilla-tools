package com.supervanillatools.item.shovel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class NetheriteAreaShovel extends BaseAreaShovel {
    public NetheriteAreaShovel(Item.Properties properties) {
        super(properties, ToolMaterial.NETHERITE);
    }

    public static Item.Properties getProperties() {
        return BaseAreaShovel.getProperties(ToolMaterial.NETHERITE);
    }
}
