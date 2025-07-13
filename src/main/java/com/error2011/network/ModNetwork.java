package com.error2011.network;

import com.error2011.Error2011Mod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;

import java.util.Optional;

public class ModNetwork {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(Error2011Mod.MODID, "main"),
        () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals
    );

    private static int packetId = 0;

    private static int nextId() {
        return packetId++;
    }

    public static void register() {
        INSTANCE.registerMessage(
            nextId(),
            SendCodePacket.class,
            SendCodePacket::encode,
            SendCodePacket::decode,
            SendCodePacket::handle,
            Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );
    }
}
