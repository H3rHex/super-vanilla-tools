package com.supervanillatools.item.pickaxe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class GoldAreaPickaxe extends BaseAreaPickaxe<ToolMaterial> {
    public GoldAreaPickaxe(Item.Properties properties) {
        super(properties, ToolMaterial.GOLD);
    }

    public static Item.Properties getProperties() {
        return BaseAreaPickaxe.getProperties(ToolMaterial.GOLD);
    }
}
