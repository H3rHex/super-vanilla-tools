package com.supervanillatools.item.shovel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class BaseAreaShovel extends Item {
    public BaseAreaShovel(Item.Properties properties, ToolMaterial material) {
        super(properties);
    }

    public static Item.Properties getProperties(ToolMaterial material) {
        return new Item.Properties().shovel(material, material.attackDamageBonus(), -3.0f);
    }
}
