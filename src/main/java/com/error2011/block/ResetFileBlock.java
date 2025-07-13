package com.error2011.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ResetFileBlock extends Block {

    public ResetFileBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                  Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && player instanceof ServerPlayer sp) {
            sp.getPersistentData().putInt("error2011_tries", 0);
            sp.sendSystemMessage(Component.literal(">> RESET NODE ACTIVATED."));
        }
        return InteractionResult.SUCCESS;
    }
}
