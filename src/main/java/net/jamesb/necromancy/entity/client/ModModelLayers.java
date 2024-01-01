package net.jamesb.necromancy.entity.client;

import net.jamesb.necromancy.Necromancy;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers
{
    public static final ModelLayerLocation WRAITH_LAYER = new ModelLayerLocation(
            new ResourceLocation(Necromancy.MOD_ID, "wraith_layer"), "main");
    public static final ModelLayerLocation POSSESSED_ZOMBIE_LAYER = new ModelLayerLocation(
            new ResourceLocation(Necromancy.MOD_ID, "possessed_zombie_layer"), "main");
    public static final ModelLayerLocation POSSESSED_SKELETON_LAYER = new ModelLayerLocation(
            new ResourceLocation(Necromancy.MOD_ID, "possessed_skeleton_layer"), "main");
}
