package com.supervanillatools.item.shovel;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;

public class BaseAreaShovel extends Item {
    private static final Map<Block, BlockState> FLATTENABLES = Map.ofEntries(
            Map.entry(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState()),
            Map.entry(Blocks.DIRT, Blocks.DIRT_PATH.defaultBlockState()),
            Map.entry(Blocks.PODZOL, Blocks.DIRT_PATH.defaultBlockState()),
            Map.entry(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.defaultBlockState()),
            Map.entry(Blocks.MYCELIUM, Blocks.DIRT_PATH.defaultBlockState()),
            Map.entry(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.defaultBlockState())
    );

    public BaseAreaShovel(Item.Properties properties, ToolMaterial material) {
        super(properties);
    }

    public static Item.Properties getProperties(ToolMaterial material) {
        return new Item.Properties().shovel(material, material.attackDamageBonus(), -3.0f);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos clickedPos = context.getClickedPos();
        Direction face = context.getClickedFace();

        if (face == Direction.DOWN || !canFlatten(level, clickedPos)) {
            return InteractionResult.PASS;
        }

        int flattened = 0;

        if (player != null && player.isCrouching()) {
            flattened += flattenBlock(level, player, clickedPos);
        } else {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    flattened += flattenBlock(level, player, clickedPos.offset(x, 0, z));
                }
            }
        }

        if (flattened <= 0) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide()) {
            ItemStack stack = context.getItemInHand();
            if (player != null) {
                EquipmentSlot slot = context.getHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                stack.hurtAndBreak(flattened, player, slot);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private static int flattenBlock(Level level, Player player, BlockPos pos) {
        if (!canFlatten(level, pos)) {
            return 0;
        }

        BlockState newState = FLATTENABLES.get(level.getBlockState(pos).getBlock());
        if (newState == null) {
            return 0;
        }

        if (!level.isClientSide()) {
            level.setBlock(pos, newState, 11);
            level.playSound(null, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
        }

        return 1;
    }

    private static boolean canFlatten(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return FLATTENABLES.containsKey(state.getBlock()) && level.getBlockState(pos.above()).isAir();
    }
}
