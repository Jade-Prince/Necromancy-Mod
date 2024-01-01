package net.jamesb.necromancy.entity.custom;

import com.mojang.logging.LogUtils;
import net.jamesb.necromancy.data.NLevelTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class WraithEntity extends TamableAnimal {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final int tickDelay = 80;
    private int tick = 0;
    public WraithEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1f, 1, 0.5f, true));
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 160D)
                .add(Attributes.ATTACK_DAMAGE, 5D)
                .add(Attributes.FOLLOW_RANGE, 10D);
    }

    @Override
    public void tick()
    {
        super.tick();

        if (this.level().isClientSide && tick == 0)
        {
            for (float h = 0f; h > -5f; h -= 0.1f)
            {
                for (int a = 0; a < 360; a += 5)
                {
                    float pX = (float) Math.sin(a);
                    float pZ = (float) Math.cos(a);

                    Vec3 particlePos = new Vec3(pX + this.position().x, h + this.position().y, pZ + this.position().z);

                    this.level().addParticle(ParticleTypes.LARGE_SMOKE,
                            particlePos.x, particlePos.y, particlePos.z,
                            pX * 0.1f, -0.25f, pZ * 0.1f);
                }
            }
            tick = tickDelay;
        } else
        {
            tick--;
        }
    }

    @Nullable
    @Override public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }
    @Override public boolean canBeLeashed(Player pPlayer) {
        return false;
    }
    @Override public boolean canAttack(LivingEntity pLivingentity, TargetingConditions pCondition) {
        return true;
    }
    @Override protected boolean canAddPassenger(Entity pPassenger) {
        return false;
    }
    @Override public void setInSittingPose(boolean pSitting) {}
    @Override public void setInLove(@Nullable Player pPlayer) {}
    @Override public boolean canBreed() {
        return false;
    }

    @Override public boolean hurt(DamageSource pSource, float pAmount) {
        super.hurt(pSource, pAmount);
        if (isDeadOrDying())
        {
            Entity killEntity = pSource.getEntity();
            if (killEntity instanceof Player)
            {
                CompoundTag entityNBT = killEntity.serializeNBT();
                if (!entityNBT.contains("necromancy_level"))
                {
                    NLevelTag levelTag = new NLevelTag(1, 0);
//                    levelTag.levelUp();
                    entityNBT.put("necromancy_level", levelTag);
//                } else
//                {
//                    NLevelTag levelTag = (NLevelTag) entityNBT.get("necromancy_level");
//                    levelTag.levelUp();
                }
            }
        }
        return true;
    }
}
