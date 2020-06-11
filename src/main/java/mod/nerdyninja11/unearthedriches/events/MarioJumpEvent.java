package mod.nerdyninja11.unearthedriches.events;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.entities.LivingMushroomEntity;
import mod.nerdyninja11.unearthedriches.init.SoundInit;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.FORGE)
public class MarioJumpEvent {
	@SubscribeEvent
	public static void marioJumpEvent(LivingJumpEvent event) {
		LivingEntity livingEntity = event.getEntityLiving();
		if (livingEntity instanceof LivingMushroomEntity) {
			if (livingEntity.getName().getString().equals("Mario")) {
				livingEntity.playSound(SoundInit.LIVING_MUSHROOM_JUMP_JOKE.get(), 1.0F,
						livingEntity.world.rand.nextFloat() * 0.1F + 0.9F);
			}
		}
	}
}
