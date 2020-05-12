package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.UnearthedRiches.UnearthedRichesItemGroup;
import mod.nerdyninja11.unearthedriches.objects.items.FuelItem;
import mod.nerdyninja11.unearthedriches.objects.items.MithrilItem;
import mod.nerdyninja11.unearthedriches.objects.items.MithrilSwordItem;
import mod.nerdyninja11.unearthedriches.objects.materials.ModArmorMaterial;
import mod.nerdyninja11.unearthedriches.objects.materials.ModToolTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.MOD)
@ObjectHolder(UnearthedRiches.MOD_ID)
public class ItemInit {

	public static final Item mithril_ingot = null;
	public static final Item mithril_nugget = null;

	public static final Item chocalate_bar = null;
	public static final Item biofuel = null;

	public static final Item mithril_dagger = null;

	public static final Item mithril_helmet = null;
	public static final Item mithril_chestplate = null;
	public static final Item mithril_leggings = null;
	public static final Item mithril_boots = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new MithrilItem(new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES))
						.setRegistryName("mithril_ingot"));
		event.getRegistry()
		.register(new MithrilItem(new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES))
				.setRegistryName("mithril_nugget"));
		

		event.getRegistry()
		.register(new FuelItem(new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES), 600)
				.setRegistryName("biofuel"));
		event.getRegistry()
				.register(new Item(new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)
						.food(new Food.Builder().hunger(9).saturation(0.1f).setAlwaysEdible()
								.effect(new EffectInstance(Effects.SPEED, 300, 0), 1.0f).build()))
										.setRegistryName("chocolate_bar"));

		event.getRegistry()
				.register(new MithrilSwordItem(ModToolTier.MITHRIL, 1, -1.0F,
						new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES))
								.setRegistryName("mithril_dagger"));

		event.getRegistry()
		.register(new ArmorItem(ModArmorMaterial.MITHRIL_CHAIN, EquipmentSlotType.HEAD,
				new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES))
						.setRegistryName("mithril_helmet"));
		event.getRegistry()
		.register(new ArmorItem(ModArmorMaterial.MITHRIL_CHAIN, EquipmentSlotType.CHEST,
				new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES))
						.setRegistryName("mithril_chestplate"));
		event.getRegistry()
		.register(new ArmorItem(ModArmorMaterial.MITHRIL_CHAIN, EquipmentSlotType.LEGS,
				new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES))
						.setRegistryName("mithril_leggings"));
		event.getRegistry()
		.register(new ArmorItem(ModArmorMaterial.MITHRIL_CHAIN, EquipmentSlotType.FEET,
				new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES))
						.setRegistryName("mithril_boots"));
	}
	
}
