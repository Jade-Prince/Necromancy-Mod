package net.jamesb.necromancy.item.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class MagicRingItem extends Item {
    public MagicRingItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (pLevel.isClientSide)
        {
            use(pLevel, pPlayer);
        }
        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide)
        {
            use(pContext.getLevel(), pContext.getPlayer());
        }
        return InteractionResult.SUCCESS;
    }

    public void use(Level level, Player pPlayer)
    {
        for (int y = 0; y < 90; y+=3) {
            for (int xz = 0; xz < 360; xz+=3)
            {
                double xPoint = Math.cos(Math.toRadians(xz));
                double zPoint = Math.sin(Math.toRadians(xz));

                double offsetX = pPlayer.getX() + 5*xPoint;
                double offsetY = pPlayer.getY() + 5*y;
                double offsetZ = pPlayer.getZ() + 5*zPoint;
                level.addParticle(ParticleTypes.FLAME, offsetX, offsetY+0.75, offsetZ, 0, 0, 0);//xPoint, yPoint, zPoint);
            }
        }
        pPlayer.sendSystemMessage(Component.literal("Spawned Particles"));
    }

}
