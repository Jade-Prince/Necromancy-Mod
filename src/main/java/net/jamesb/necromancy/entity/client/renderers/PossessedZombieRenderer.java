package net.jamesb.necromancy.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jamesb.necromancy.Necromancy;
import net.jamesb.necromancy.entity.client.ModModelLayers;
import net.jamesb.necromancy.entity.client.models.PossessedZombieModel;
import net.jamesb.necromancy.entity.custom.possessed.PossessedZombie;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PossessedZombieRenderer extends MobRenderer<PossessedZombie, PossessedZombieModel<PossessedZombie>>
{
    public PossessedZombieRenderer(EntityRendererProvider.Context pContext)
    {
        super(pContext, new PossessedZombieModel<>(pContext.bakeLayer(ModModelLayers.POSSESSED_ZOMBIE_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(PossessedZombie pEntity) {
        return new ResourceLocation(Necromancy.MOD_ID, "textures/entity/zombie.png");
    }

    @Override
    public void render(PossessedZombie pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight)
    {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
