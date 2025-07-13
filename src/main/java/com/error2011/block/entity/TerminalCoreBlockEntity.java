package com.error2011.block.entity;

import com.error2011.init.ModBlockEntities;
import com.error2011.screen.menu.TerminalCoreMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.MenuProvider;

public class TerminalCoreBlockEntity extends BlockEntity implements MenuProvider {

    public TerminalCoreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TERMINAL_CORE.get(), pos, state);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new TerminalCoreMenu(id, inv, this.getBlockPos());
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Terminal Core");
    }

    public String tryCode(String input) {
        return input.equals("c00l64m3r") ? "Access Granted" : "Access Denied";
    }
}
