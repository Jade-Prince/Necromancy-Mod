package net.jamesb.necromancy.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jamesb.necromancy.Necromancy;
import net.jamesb.necromancy.entity.client.ModModelLayers;
import net.jamesb.necromancy.entity.client.models.PossessedSkeletonModel;
import net.jamesb.necromancy.entity.custom.possessed.PossessedSkeleton;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PossessedSkeletonRenderer extends MobRenderer<PossessedSkeleton, PossessedSkeletonModel<PossessedSkeleton>>
{
    public PossessedSkeletonRenderer(EntityRendererProvider.Context pContext)
    {
        super(pContext, new PossessedSkeletonModel<>(pContext.bakeLayer(ModModelLayers.POSSESSED_SKELETON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PossessedSkeleton pEntity) {
        return new ResourceLocation(Necromancy.MOD_ID, "textures/entity/skeleton.png");
    }

    @Override
    public void render(PossessedSkeleton pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight)
    {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}