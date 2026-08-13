package com.anticreate.brassrocket;

import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.Item;

/**
 * Cohete idéntico al firework vanilla (misma clase base, mismo comportamiento
 * de vuelo/boost con élitro, heredado de FireworkRocketItem), pero con su
 * propio registry name y una receta personalizada definida por datapack.
 *
 * El "power 3" fijo se define en el registro del item (BrassRocketMod),
 * seteando el DataComponent FIREWORKS directamente en las Properties,
 * así toda instancia del item nace ya con ese valor sin necesitar
 * lógica adicional en esta clase.
 */
public class BrassRocketItem extends FireworkRocketItem {

    public BrassRocketItem(Properties properties) {
        super(properties);
    }
}
