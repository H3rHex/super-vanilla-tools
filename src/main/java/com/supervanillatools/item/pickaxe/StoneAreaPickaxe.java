package com.supervanillatools.item.pickaxe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class StoneAreaPickaxe extends BaseAreaPickaxe<ToolMaterial> {
    public StoneAreaPickaxe(Item.Properties properties) {
        super(properties, ToolMaterial.STONE);
    }

    public static Item.Properties getProperties() {
        return BaseAreaPickaxe.getProperties(ToolMaterial.STONE);
    }
}
