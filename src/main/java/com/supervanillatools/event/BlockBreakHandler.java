package com.supervanillatools.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.core.Direction;
import com.supervanillatools.item.ModItems;

public class BlockBreakHandler {

    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register((level, player, pos, state, entity) -> {
            if (isAreaTool(player.getMainHandItem()) && !player.isCrouching()) {
                breakArea(level, player, pos);
            }
            return true;
        });
    }

    private static boolean isAreaTool(ItemStack stack) {
        return stack.is(ModItems.WOODEN_AREA_PICKAXE) ||
                stack.is(ModItems.STONE_AREA_PICKAXE) ||
                stack.is(ModItems.IRON_AREA_PICKAXE) ||
                stack.is(ModItems.GOLD_AREA_PICKAXE) ||
                stack.is(ModItems.DIAMOND_AREA_PICKAXE) ||
                stack.is(ModItems.NETHERITE_AREA_PICKAXE) ||
                stack.is(ModItems.WOODEN_AREA_SHOVEL) ||
                stack.is(ModItems.STONE_AREA_SHOVEL) ||
                stack.is(ModItems.IRON_AREA_SHOVEL) ||
                stack.is(ModItems.GOLD_AREA_SHOVEL) ||
                stack.is(ModItems.DIAMOND_AREA_SHOVEL) ||
                stack.is(ModItems.NETHERITE_AREA_SHOVEL);
    }

    private static void breakArea(Level level, Player player, BlockPos pos) {
        // Obtener la dirección en la que está mirando el jugador
        var hitResult = player.pick(5.0D,0.0f, false);
        if (!(hitResult instanceof BlockHitResult blockHit)) {
            return;
        }
        Direction face = blockHit.getDirection();

        if (face == Direction.UP || face == Direction.DOWN) {
            // if it looks up/down: 3x3 horizontal (X-Z)
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos blockPos = pos.offset(x, 0, z);
                    destroyBlockIfValid(level, player,blockPos);
                }
            }
        } else if (face == Direction.NORTH || face == Direction.SOUTH) {
            // if it looks north/south: 3x3 vertical (X-Y)
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    BlockPos blockPos = pos.offset(x, y, 0);
                    destroyBlockIfValid(level, player,blockPos);
                }
            }
        } else if (face == Direction.EAST || face == Direction.WEST) {
            // if it looks east/west: 3x3 vertical (Y-Z)
            for (int z = -1; z <= 1; z++) {
                for (int y = -1; y <= 1; y++) {
                    BlockPos blockPos = pos.offset(0, y, z);
                    destroyBlockIfValid(level, player,blockPos);
                }
            }
        }
    }

    private static void destroyBlockIfValid(Level level, Player player, BlockPos blockPos) {
        var blockState = level.getBlockState(blockPos);
        var tool = player.getMainHandItem();

        if (blockState.getDestroySpeed(level, blockPos) < 0) {
            return;
        }

        if (blockState.requiresCorrectToolForDrops() && !tool.isCorrectToolForDrops(blockState)) {
            return;
        }

        boolean shouldDrop = !player.isCreative();
        level.destroyBlock(blockPos, shouldDrop);
    }
}