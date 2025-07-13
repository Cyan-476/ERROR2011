package com.error2011.init;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "error2011")
public class ModCommands {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(
            Commands.literal("puzzlecode")
                .then(Commands.argument("code", StringArgumentType.string())
                    .executes(ctx -> {
                        String input = StringArgumentType.getString(ctx, "code");
                        ServerPlayer player = ctx.getSource().getPlayerOrException();
                        return handleCode(player, input);
                    }))
        );
    }

    private static int handleCode(ServerPlayer player, String input) {
        String correctCode = "echo_patch.2011";
        CompoundTag data = player.getPersistentData();
        int tries = data.getInt("error2011_tries");

        if (tries >= 5) {
            player.sendSystemMessage(Component.literal(">> SYSTEM LOCKED"));
            return 1;
        }

        if (input.equalsIgnoreCase(correctCode)) {
            player.sendSystemMessage(Component.literal(">> CODE ACCEPTED. NEUTRALIZING CORE..."));
            data.putInt("error2011_tries", 0); // Reset
            // TODO: Trigger special animation/effects
        } else {
            data.putInt("error2011_tries", tries + 1);
            player.sendSystemMessage(Component.literal(">> INVALID CODE. TRIES: " + (tries + 1) + "/5"));
        }

        return 1;
    }
}
