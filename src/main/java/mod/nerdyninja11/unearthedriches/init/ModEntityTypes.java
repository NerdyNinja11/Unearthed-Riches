package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.entities.LivingMushroomEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			UnearthedRiches.MOD_ID);

	public static final RegistryObject<EntityType<LivingMushroomEntity>> LIVING_MUSHROOM_ENTITY = ENTITY_TYPES.register(
			"living_mushroom_entity",
			() -> EntityType.Builder
					.<LivingMushroomEntity>create(LivingMushroomEntity::new, EntityClassification.CREATURE)
					.size(0.4F, 0.4F)
					.build(new ResourceLocation(UnearthedRiches.MOD_ID, "living_mushroom_entity").toString()));
	
	

}
