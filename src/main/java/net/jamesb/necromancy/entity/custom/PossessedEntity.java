package net.jamesb.necromancy.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class PossessedEntity extends Animal
{
    public static float MAX_DAMAGE;
    public static float DAMAGE;
    public PossessedEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        MAX_DAMAGE = 10;
        DAMAGE = 2;
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new FloatGoal(this));
    }

    @Override
    public void tick()
    {
        Player player = this.level().getNearestPlayer(this, 64f);
        if (player != null)
        {
            this.move(MoverType.SELF, player.position());
            this.lookAt(player, 90f, 90f);
            float distToPlayer = this.distanceTo(player);
            if (distToPlayer <= 1.4)
            {
                player.hurt(this.damageSources().generic(), this.DAMAGE);
            }
        }
        int lookX = (int) Math.round(1.4f * Math.sin(this.getLookAngle().y));
        int lookZ = (int) Math.round(1.4f * Math.cos(this.getLookAngle().y));

        BlockPos pos                   = new BlockPos((int) (lookX + this.position().x), (int) this.position().y, (int) (lookZ + this.position().z));
        BlockState frontBlockState     = this.level().getBlockState(pos);
        BlockState frontDownBlockState = this.level().getBlockState(pos.below());
        if (!frontBlockState.isSolid() && !frontDownBlockState.isSolid())
        {
            this.moveRelative(1.0f, new Vec3(-lookX, this.position().y, -lookZ));
        }
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pAmount >= 8)
        {
            pAmount = 2;
        }
        if (this.isInvulnerableTo(pSource)) {
            return false;
        } else {
            this.DAMAGE += 0.25f;
            if (this.DAMAGE > this.MAX_DAMAGE)
            {
                this.DAMAGE = this.MAX_DAMAGE;
            } else
            {
                this.heal(2);
            }
            return super.hurt(pSource, pAmount);
        }
    }
}
