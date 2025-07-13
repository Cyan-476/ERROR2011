package com.error2011.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CorruptionGemBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 12, 12); // smaller cube

    public CorruptionGemBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)
              .lightLevel(state -> 12)
              .noOcclusion());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }
}