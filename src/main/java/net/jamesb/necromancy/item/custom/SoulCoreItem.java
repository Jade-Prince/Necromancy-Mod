package net.jamesb.necromancy.item.custom;

import com.mojang.logging.LogUtils;
import net.jamesb.necromancy.data.NLevelTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

public class SoulCoreItem extends Item
{
    private static final Logger LOGGER = LogUtils.getLogger();
    public SoulCoreItem(Properties pProperties) {
        super(pProperties.food((new FoodProperties.Builder()).nutrition(1).saturationMod(50).build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        LOGGER.debug(String.valueOf(pLivingEntity instanceof Player));
        if (pLivingEntity instanceof Player pPlayer)
        {
            CompoundTag entityNBT = pPlayer.serializeNBT();
            if (!entityNBT.contains("necromancy_level"))
            {
                NLevelTag levelTag = new NLevelTag(1, 0);
                levelTag.levelUp();
                entityNBT.put("necromancy_level", levelTag);
            } else
            {
                NLevelTag levelTag = (NLevelTag) entityNBT.get("necromancy_level");
                levelTag.levelUp(5);
            }
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }


    @Override public boolean isEdible() {
        return true;
    }
    @Override public boolean isFireResistant() {
        return true;
    }
}
