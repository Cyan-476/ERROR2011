package com.error2011.init;

import com.error2011.screen.menu.TerminalCoreMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, "error2011");

    public static final RegistryObject<MenuType<TerminalCoreMenu>> TERMINAL_CORE_MENU =
            MENUS.register("terminal_core_menu", () ->
                    IForgeMenuType.create(TerminalCoreMenu::new));
}