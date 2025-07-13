package com.error2011.world;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "error2011")
public class DeletionFieldHandler {

    private static final BlockPos PYRAMID_CENTER = new BlockPos(1500, 80, 0);
    private static final int FIELD_RADIUS = 40;

    @SubscribeEvent
    public static void onMobSpawn(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        Level world = event.getLevel();
        if (!(entity instanceof Mob)) return;

        if (entity.blockPosition().closerThan(PYRAMID_CENTER, FIELD_RADIUS)) {
            event.setCanceled(true);
            entity.discard();
            for (ServerPlayer player : world.getServer().getPlayerList().getPlayers()) {
                player.sendSystemMessage(Component.literal("[ERROR2011 SYSTEM]: UNAUTHORIZED ENTITY DELETED."));
            }
        }
    }

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        BlockPos pos = event.getPos();
        if (pos.closerThan(PYRAMID_CENTER, FIELD_RADIUS)) {
            event.setCanceled(true);
            Entity placer = event.getEntity();
            if (placer instanceof ServerPlayer player) {
                player.sendSystemMessage(Component.literal("[ERROR2011 SYSTEM]: UNAUTHORIZED ENTITY DELETED."));
            }
        }
    }
}