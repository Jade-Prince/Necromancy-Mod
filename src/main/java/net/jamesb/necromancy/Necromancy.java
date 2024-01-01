package net.jamesb.necromancy;

import com.mojang.logging.LogUtils;
import net.jamesb.necromancy.blocks.ModBlocks;
import net.jamesb.necromancy.entity.ModEntities;
import net.jamesb.necromancy.entity.client.renderers.PossessedSkeletonRenderer;
import net.jamesb.necromancy.entity.client.renderers.PossessedZombieRenderer;
import net.jamesb.necromancy.entity.client.renderers.WraithRenderer;
import net.jamesb.necromancy.item.ModCreativeModTabs;
import net.jamesb.necromancy.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Necromancy.MOD_ID)
public class Necromancy
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "necromancy";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Necromancy()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
//            example add item to existing tab
//            event.accept(ModItems.SAPPHIRE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.WRAITH.get(), WraithRenderer::new);
            EntityRenderers.register(ModEntities.POSSESSED_ZOMBIE.get(), PossessedZombieRenderer::new);
            EntityRenderers.register(ModEntities.POSSESSED_SKELETON.get(), PossessedSkeletonRenderer::new);
        }
    }
}
