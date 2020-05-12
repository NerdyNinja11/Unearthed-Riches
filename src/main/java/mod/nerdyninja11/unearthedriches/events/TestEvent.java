package mod.nerdyninja11.unearthedriches.events;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.FORGE)
public class TestEvent {
	@SubscribeEvent
	public static void testEvent(LivingJumpEvent event) {
	  /*LivingEntity livingEntity = event.getEntityLiving();
		double xLevel = livingEntity.getPosX();
		double yLevel = livingEntity.getPosY();
		double zLevel = livingEntity.getPosZ();
		livingEntity.setPosition(xLevel, yLevel+1, zLevel); */
	}
}
