package net.jamesb.necromancy.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jamesb.necromancy.Necromancy;
import net.jamesb.necromancy.entity.client.ModModelLayers;
import net.jamesb.necromancy.entity.client.models.WraithModel;
import net.jamesb.necromancy.entity.custom.WraithEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WraithRenderer extends MobRenderer<WraithEntity, WraithModel<WraithEntity>>
{
    public WraithRenderer(EntityRendererProvider.Context pContext)
    {
        super(pContext, new WraithModel<>(pContext.bakeLayer(ModModelLayers.WRAITH_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(WraithEntity pEntity) {
        return new ResourceLocation(Necromancy.MOD_ID, "textures/entity/wraith.png");
    }

    @Override
    public void render(WraithEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight)
    {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
