package com.error2011.client;

import com.error2011.screen.TerminalCoreScreen;
import com.error2011.init.ModMenus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(modid = "error2011", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenus.TERMINAL_CORE_MENU.get(), TerminalCoreScreen::new);
        });
    }
}
