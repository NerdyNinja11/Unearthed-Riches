package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.particles.QuarryParticle;
import mod.nerdyninja11.unearthedriches.particles.QuarryParticle.QuarryParticleData;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ParticleInit {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = new DeferredRegister<>(
			ForgeRegistries.PARTICLE_TYPES, UnearthedRiches.MOD_ID);

	public static final RegistryObject<ParticleType<QuarryParticleData>> QUARRY_PARTICLE = PARTICLE_TYPES.register(
			"quarry_particle", () -> new ParticleType<QuarryParticleData>(false, QuarryParticleData.DESERIALIZER));
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(ParticleInit.QUARRY_PARTICLE.get(), QuarryParticle.Factory::new);
	}
}
