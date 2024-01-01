package net.jamesb.necromancy.entity;

import net.jamesb.necromancy.Necromancy;
import net.jamesb.necromancy.entity.custom.WraithEntity;
import net.jamesb.necromancy.entity.custom.possessed.PossessedSkeleton;
import net.jamesb.necromancy.entity.custom.possessed.PossessedZombie;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Necromancy.MOD_ID);

    public static final RegistryObject<EntityType<WraithEntity>> WRAITH =
            ENTITY_TYPES.register("wraith", () -> EntityType.Builder.of(WraithEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("wraith"));

    public static final RegistryObject<EntityType<PossessedZombie>> POSSESSED_ZOMBIE =
            ENTITY_TYPES.register("possessed_zombie", () -> EntityType.Builder.of(PossessedZombie::new, MobCategory.MONSTER)
                    .sized(1f, 2f).build("possessed_zombie"));

    public static final RegistryObject<EntityType<PossessedSkeleton>> POSSESSED_SKELETON =
            ENTITY_TYPES.register("possessed_skeleton", () -> EntityType.Builder.of(PossessedSkeleton::new, MobCategory.MONSTER)
                    .sized(1f, 2f).build("possessed_skeleton"));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
