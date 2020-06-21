package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.particles.ColouredParticle;
import mod.nerdyninja11.unearthedriches.particles.ColouredParticle.ColouredParticleData;
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

	public static final RegistryObject<ParticleType<ColouredParticleData>> COLOURED_PARTICLE = PARTICLE_TYPES.register(
			"coloured_particle", () -> new ParticleType<ColouredParticleData>(false, ColouredParticleData.DESERIALIZER));
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(ParticleInit.COLOURED_PARTICLE.get(), ColouredParticle.Factory::new);
	}
}
