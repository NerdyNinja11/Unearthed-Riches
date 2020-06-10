package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			UnearthedRiches.MOD_ID);
	
	public static final RegistryObject<SoundEvent> LIVING_MUSHROOM_AMBIENT = SOUNDS
			.register("entity.living_mushroom_entity.ambient", () -> new SoundEvent(
					new ResourceLocation(UnearthedRiches.MOD_ID, "entity.living_mushroom_entity.ambient")));
	public static final RegistryObject<SoundEvent> LIVING_MUSHROOM_HURT = SOUNDS
			.register("entity.living_mushroom_entity.hurt", () -> new SoundEvent(
					new ResourceLocation(UnearthedRiches.MOD_ID, "entity.living_mushroom_entity.hurt")));
	public static final RegistryObject<SoundEvent> LIVING_MUSHROOM_DEATH = SOUNDS
			.register("entity.living_mushroom_entity.death", () -> new SoundEvent(
					new ResourceLocation(UnearthedRiches.MOD_ID, "entity.living_mushroom_entity.death")));
	public static final RegistryObject<SoundEvent> LIVING_MUSHROOM_JUMP_JOKE = SOUNDS
			.register("entity.living_mushroom_entity.jump.joke", () -> new SoundEvent(
					new ResourceLocation(UnearthedRiches.MOD_ID, "entity.living_mushroom_entity.jump.joke")));
	public static final RegistryObject<SoundEvent> LIVING_MUSHROOM_DEATH_JOKE = SOUNDS
			.register("entity.living_mushroom_entity.death.joke", () -> new SoundEvent(
					new ResourceLocation(UnearthedRiches.MOD_ID, "entity.living_mushroom_entity.death.joke")));
					
}
