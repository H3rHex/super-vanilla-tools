package com.supervanillatools.item.pickaxe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class NetheriteAreaPickaxe extends BaseAreaPickaxe<ToolMaterial> {
    public NetheriteAreaPickaxe(Item.Properties properties) {
        super(properties, ToolMaterial.NETHERITE);
    }

    public static Item.Properties getProperties() {
        return BaseAreaPickaxe.getProperties(ToolMaterial.NETHERITE);
    }
}
