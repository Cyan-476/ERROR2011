package com.error2011.network;

import com.error2011.block.entity.TerminalCoreBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SendCodePacket {
    private final String input;
    private final BlockPos pos;

    public SendCodePacket(String input, BlockPos pos) {
        this.input = input;
        this.pos = pos;
    }

    public static void encode(SendCodePacket pkt, FriendlyByteBuf buf) {
        buf.writeUtf(pkt.input);
        buf.writeBlockPos(pkt.pos);
    }

    public static SendCodePacket decode(FriendlyByteBuf buf) {
        return new SendCodePacket(buf.readUtf(32767), buf.readBlockPos());
    }

    public static void handle(SendCodePacket pkt, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            Level level = player.level();
            if (level.getBlockEntity(pkt.pos) instanceof TerminalCoreBlockEntity be) {
                String result = be.tryCode(pkt.input);
                player.sendSystemMessage(net.minecraft.network.chat.Component.literal(result));
            }
        });
        ctx.get().setPacketHandled(true);
    }
}