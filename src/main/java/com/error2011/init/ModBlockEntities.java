package com.error2011.init;

import com.error2011.Error2011Mod;
import com.error2011.block.entity.TerminalCoreBlockEntity;
import com.error2011.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Error2011Mod.MODID);

    public static final RegistryObject<BlockEntityType<TerminalCoreBlockEntity>> TERMINAL_CORE =
        BLOCK_ENTITIES.register("terminal_core", () ->
            BlockEntityType.Builder.of(TerminalCoreBlockEntity::new, ModBlocks.TERMINAL_CORE.get()).build(null)
        );

    public static void register() {
        BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
