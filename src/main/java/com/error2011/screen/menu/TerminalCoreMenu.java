package com.error2011.screen.menu;

import com.error2011.init.ModMenus;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class TerminalCoreMenu extends AbstractContainerMenu {

    private final BlockPos pos;

    // Called from network packet (client)
    public TerminalCoreMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, buf.readBlockPos());
    }

    // Called from server logic
    public TerminalCoreMenu(int id, Inventory inv, BlockPos pos) {
        super(ModMenus.TERMINAL_CORE_MENU.get(), id);
        this.pos = pos;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}
