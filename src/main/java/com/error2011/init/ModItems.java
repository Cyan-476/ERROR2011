package com.error2011.init;

import com.error2011.Error2011Mod;
import com.error2011.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Error2011Mod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Error2011Mod.MODID);

    public static final RegistryObject<Item> TERMINAL_CORE = ITEMS.register("terminal_core",
            () -> new BlockItem(ModBlocks.TERMINAL_CORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> RESET_FILE = ITEMS.register("reset_file",
            () -> new BlockItem(ModBlocks.RESET_FILE.get(), new Item.Properties()));

    @SubscribeEvent
    public static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(TERMINAL_CORE);
            event.accept(RESET_FILE);
        }
    }
}