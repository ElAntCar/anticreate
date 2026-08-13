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

@Mod(BrassRocketMod.MODID)
public class BrassRocketMod {

    public static final String MODID = "brassrocket";

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MODID);

    public static final DeferredItem<BrassRocketItem> BRASS_ROCKET =
            ITEMS.register("brass_rocket", () -> new BrassRocketItem(new Item.Properties()
                    .stacksTo(64)
                    // Power 3 fijo, sin estrellas de color (lista de explosiones vacía)
                    .component(DataComponents.FIREWORKS, new Fireworks(3, NonNullList.create()))));

    public BrassRocketMod(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    // Agrega el item a la pestaña de "Combate" del inventario creativo (donde vive el firework vanilla)
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(BRASS_ROCKET);
        }
    }
}
