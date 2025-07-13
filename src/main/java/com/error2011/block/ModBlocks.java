package com.error2011.block;

import com.error2011.Error2011Mod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, Error2011Mod.MODID);

    public static final RegistryObject<Block> TERMINAL_CORE =
        BLOCKS.register("terminal_core", () ->
            new Block(BlockBehaviour.Properties
                .copy(Blocks.IRON_BLOCK)
                .mapColor(MapColor.METAL)
                .strength(3.5F))
        );

    public static final RegistryObject<Block> RESET_FILE =
        BLOCKS.register("reset_file", () ->
            new Block(BlockBehaviour.Properties
                .copy(Blocks.IRON_BLOCK)
                .strength(1.0F))
        );
}
