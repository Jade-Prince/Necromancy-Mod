package net.jamesb.necromancy.item;

import net.jamesb.necromancy.Necromancy;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Necromancy.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NECROMANCY_TAB = CREATIVE_MODE_TABS.register("necromancy_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.SKELETON_SKULL))
                            .title(Component.translatable("creativetab.necromancy_tab"))
                            .displayItems((pParameters, pOutput) -> {
//                                example item
//                                pOutput.accept(ModItems.CAPITAL_ITEM_NAME.get());
//                                example block
//                                pOutput.accept(ModBlocks.CAPITAL_BLOCK_NAME.get());
                                pOutput.accept(ModItems.MAGIC_RING.get());
                                pOutput.accept(ModItems.PROTECTED_BOTTLE.get());
                                pOutput.accept(ModItems.SOUL_BOTTLE.get());
                                pOutput.accept(ModItems.SOUL_SHARD.get());
                                pOutput.accept(ModItems.SOUL_CORE.get());
                            })
                            .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
