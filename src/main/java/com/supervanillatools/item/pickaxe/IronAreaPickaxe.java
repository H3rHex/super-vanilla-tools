package com.supervanillatools.item.pickaxe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class IronAreaPickaxe extends BaseAreaPickaxe<ToolMaterial> {
    public IronAreaPickaxe(Item.Properties properties) {
        super(properties, ToolMaterial.IRON);
    }

    public static Item.Properties getProperties() {
        return BaseAreaPickaxe.getProperties(ToolMaterial.IRON);
    }
}
