package com.supervanillatools.item.pickaxe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class BaseAreaPickaxe<T extends ToolMaterial> extends Item {
    protected final T material;

    public BaseAreaPickaxe(Item.Properties properties, T material) {
        super(properties);
        this.material = material;
    }

    public static Item.Properties getProperties(ToolMaterial material) {
        return new Item.Properties().pickaxe(material, 1, -2.8f);
    }
}