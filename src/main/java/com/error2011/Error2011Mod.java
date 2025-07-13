package com.error2011;

import com.error2011.block.ModBlocks;
import com.error2011.init.ModItems;
import com.error2011.init.ModMenus;
import com.error2011.init.ModBlockEntities;
import com.error2011.network.ModNetwork;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Error2011Mod.MODID)
public class Error2011Mod {
    public static final String MODID = "error2011";

    public Error2011Mod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register blocks, items, menus
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModMenus.MENUS.register(modEventBus);
        ModNetwork.register();

        System.out.println("ERROR2011 initialized. Welcome Interface: PlayerNull.");
    }
}
