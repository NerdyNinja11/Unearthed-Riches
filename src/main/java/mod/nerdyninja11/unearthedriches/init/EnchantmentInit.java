package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.enchantments.StrafingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(
			ForgeRegistries.ENCHANTMENTS, UnearthedRiches.MOD_ID);

	public static final RegistryObject<Enchantment> STRAFING = ENCHANTMENTS.register("strafing",
			() -> new StrafingEnchantment(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_LEGS,
					EquipmentSlotType.LEGS));
}
