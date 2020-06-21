package mod.nerdyninja11.unearthedriches.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class StrafingEnchantment extends Enchantment {

	public StrafingEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType... slots) {
		super(rarityIn, typeIn, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return 5 + (enchantmentLevel - 1) * 9;
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + 15;
	}

	/*@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.FORGE)
	public static class StrafingEquipped {
		private static int level = 0;
		private static int oldLevel = 0;
		private static boolean needed = false;

		@SubscribeEvent
		public static void checkArmor(PlayerTickEvent event) {
			PlayerEntity playerIn = event.player;
			level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.STRAFING.get(),
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS));
			if (level != oldLevel) {
				UnearthedRiches.LOGGER.debug("new level " + level);
				UnearthedRiches.LOGGER.debug("old level " + oldLevel);
				needed = true;
				
			}
			
			if (needed) {
				UnearthedRiches.LOGGER.debug("old speed " + playerIn.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
				playerIn.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(new AttributeModifier(
						"strafe speed increase", (1 + oldLevel/10)/10, AttributeModifier.Operation.MULTIPLY_TOTAL));
				UnearthedRiches.LOGGER.debug( 0.1 * level + ":" + (1 + oldLevel/10)/10);
				UnearthedRiches.LOGGER.debug("mid speed " + playerIn.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
				playerIn.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(new AttributeModifier(
						"strafe speed increase", 0.1 * level, AttributeModifier.Operation.MULTIPLY_TOTAL));
				UnearthedRiches.LOGGER.debug("new speed " + playerIn.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
				needed = false;
			}
			
			if (playerIn.moveStrafing != 0) {
				UnearthedRiches.LOGGER.debug("eventp3");
				playerIn.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(new AttributeModifier(
						"strafe speed increase", 0.1 * level, AttributeModifier.Operation.MULTIPLY_BASE));
			}
			oldLevel = level;
		}



	} */
}