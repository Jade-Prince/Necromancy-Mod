package net.jamesb.necromancy.event;

import net.jamesb.necromancy.Necromancy;
import net.jamesb.necromancy.entity.client.ModModelLayers;
import net.jamesb.necromancy.entity.client.models.PossessedSkeletonModel;
import net.jamesb.necromancy.entity.client.models.PossessedZombieModel;
import net.jamesb.necromancy.entity.client.models.WraithModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Necromancy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents
{
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.WRAITH_LAYER, WraithModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.POSSESSED_ZOMBIE_LAYER, PossessedZombieModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.POSSESSED_SKELETON_LAYER, PossessedSkeletonModel::createBodyLayer);
    }
}
