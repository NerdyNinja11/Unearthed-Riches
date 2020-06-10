package mod.nerdyninja11.unearthedriches.client.entity.render;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.client.entity.model.LivingMushroomEntityModel;
import mod.nerdyninja11.unearthedriches.entities.LivingMushroomEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LivingMusroomEntityRenderer
		extends MobRenderer<LivingMushroomEntity, LivingMushroomEntityModel<LivingMushroomEntity>> {

	protected static final ResourceLocation RED = new ResourceLocation(UnearthedRiches.MOD_ID,
			"textures/entity/living_mushroom/red.png");
	protected static final ResourceLocation BROWN = new ResourceLocation(UnearthedRiches.MOD_ID,
			"textures/entity/living_mushroom/brown.png");

	public LivingMusroomEntityRenderer(EntityRendererManager rendererManagerIn) {
		super(rendererManagerIn, new LivingMushroomEntityModel<LivingMushroomEntity>(), 0.2F);
	}

	@Override
	public ResourceLocation getEntityTexture(LivingMushroomEntity entity) {
		switch(entity.getLivingMushroomType()) {
		case 0:
			return RED;
		default:
			return BROWN;
		
		}
	}
}
