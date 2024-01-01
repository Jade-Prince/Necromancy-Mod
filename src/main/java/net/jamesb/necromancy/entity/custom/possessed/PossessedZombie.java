package net.jamesb.necromancy.entity.custom.possessed;

import net.jamesb.necromancy.entity.ModEntities;
import net.jamesb.necromancy.entity.custom.PossessedEntity;
import net.jamesb.necromancy.entity.custom.WraithEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class PossessedZombie extends PossessedEntity {
    public PossessedZombie(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.ATTACK_DAMAGE, 5D)
                .add(Attributes.FOLLOW_RANGE, 10D);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        super.hurt(pSource, pAmount);
        if (this.getHealth() <= 0)
        {
            WraithEntity wraith = ModEntities.WRAITH.get().create(this.level());
            wraith.setPos(this.position());
            wraith.lookAt(EntityAnchorArgument.Anchor.EYES, this.getLookAngle());

            Zombie selfMobType = new Zombie(this.level());
            selfMobType.setPos(this.position());
            selfMobType.lookAt(EntityAnchorArgument.Anchor.EYES, this.getLookAngle());

            this.kill();
        }
        return true;
    }
}
