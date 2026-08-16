package com.anticreate.brassrocket;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Fireworks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(AntiCreateMod.MODID)
public class AntiCreateMod {

    public static final String MODID = "anticreate";

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MODID);

    public static final DeferredItem<BrassRocketItem> BRASS_ROCKET =
            ITEMS.register("brass_rocket", () -> new BrassRocketItem(new Item.Properties()
                    .stacksTo(64)
                    // Rocket Power SET 3
                    .component(DataComponents.FIREWORKS, new Fireworks(4, NonNullList.create()))));

    public AntiCreateMod(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    // Add Items to Combat Menu
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(BRASS_ROCKET);
            // event.accept(EASTER_EGG);
        }
    }
}
