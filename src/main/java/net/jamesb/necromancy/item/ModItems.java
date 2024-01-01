package net.jamesb.necromancy.item;

import net.jamesb.necromancy.Necromancy;
import net.jamesb.necromancy.item.custom.MagicRingItem;
import net.jamesb.necromancy.item.custom.SoulBottleItem;
import net.jamesb.necromancy.item.custom.SoulCoreItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Necromancy.MOD_ID);

//    Item Example
//    public static final RegistryObject<Item> CAPITAL_ITEM_NAME = ITEMS.register("item_name",
//            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_RING = ITEMS.register("magic_ring",
            () -> new MagicRingItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> PROTECTED_BOTTLE = ITEMS.register("protected_bottle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOUL_BOTTLE = ITEMS.register("soul_bottle",
            () -> new SoulBottleItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SOUL_SHARD = ITEMS.register("soul_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOUL_CORE = ITEMS.register("soul_core",
            () -> new SoulCoreItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
