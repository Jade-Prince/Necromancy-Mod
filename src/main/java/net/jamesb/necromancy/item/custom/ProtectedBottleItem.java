package net.jamesb.necromancy.item.custom;

import net.jamesb.necromancy.entity.custom.WraithEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ProtectedBottleItem extends Item
{
    public ProtectedBottleItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pInteractionTarget instanceof WraithEntity) return InteractionResult.CONSUME_PARTIAL;
        return InteractionResult.PASS;
    }
}
