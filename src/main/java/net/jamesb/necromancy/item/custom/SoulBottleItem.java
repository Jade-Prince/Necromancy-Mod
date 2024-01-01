package net.jamesb.necromancy.item.custom;

import net.jamesb.necromancy.entity.ModEntities;
import net.jamesb.necromancy.entity.custom.WraithEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SoulBottleItem extends Item
{
    public SoulBottleItem(Item.Properties properties) {
        super(properties.food((new FoodProperties.Builder()).nutrition(10).saturationMod(10).build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player)
        {
            Player pPlayer = (Player) pLivingEntity;
            WraithEntity wraith = ModEntities.WRAITH.get().create(pLevel);
            wraith.setPos(pPlayer.position());
            Vec3 lookAngle = pPlayer.getLookAngle();
            lookAngle.subtract(0f, lookAngle.y, 0f);

            wraith.lookAt(EntityAnchorArgument.Anchor.EYES, lookAngle);
            wraith.setOwnerUUID(pPlayer.getUUID());
        }
        return new ItemStack(Items.GLASS_BOTTLE);
    }
}
