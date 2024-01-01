package net.jamesb.necromancy.event;

import net.jamesb.necromancy.Necromancy;
import net.jamesb.necromancy.entity.ModEntities;
import net.jamesb.necromancy.entity.custom.WraithEntity;
import net.jamesb.necromancy.entity.custom.possessed.PossessedSkeleton;
import net.jamesb.necromancy.entity.custom.possessed.PossessedZombie;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Necromancy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents
{

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.WRAITH.get(), WraithEntity.createAttributes().build());
        event.put(ModEntities.POSSESSED_SKELETON.get(), PossessedSkeleton.createAttributes().build());
        event.put(ModEntities.POSSESSED_ZOMBIE.get(), PossessedZombie.createAttributes().build());
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event)
    {
        event.register(PlayerEvent.class);
    }
}
