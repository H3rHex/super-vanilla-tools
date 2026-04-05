package com.supervanillatools.item.pickaxe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class DiamondAreaPickaxe extends BaseAreaPickaxe<ToolMaterial> {
    public DiamondAreaPickaxe(Item.Properties properties) {
        super(properties, ToolMaterial.DIAMOND);
    }

    public static Item.Properties getProperties() {
        return BaseAreaPickaxe.getProperties(ToolMaterial.DIAMOND);
    }
}
