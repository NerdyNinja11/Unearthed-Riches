package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.UnearthedRiches.UnearthedRichesItemGroup;
import mod.nerdyninja11.unearthedriches.objects.items.FuelItem;
import mod.nerdyninja11.unearthedriches.objects.items.MithrilSwordItem;
import mod.nerdyninja11.unearthedriches.util.enums.ModArmorMaterial;
import mod.nerdyninja11.unearthedriches.util.enums.ModToolTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, UnearthedRiches.MOD_ID);
	
	public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot", 
			() -> new Item(new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)));
	public static final RegistryObject<Item> MITHRIL_NUGGET = ITEMS.register("mithril_nugget", 
			() -> new Item(new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)));
	
	public static final RegistryObject<Item> CHOCOLATE_BAR = ITEMS.register("chocolate_bar", 
			() -> new Item(new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)
					.food(new Food.Builder().hunger(9).saturation(0.1f).setAlwaysEdible()
							.effect(new EffectInstance(Effects.SPEED, 300, 0), 1.0f).build())));
	
	public static final RegistryObject<Item> BIOFUEL = ITEMS.register("biofuel", 
			() -> new FuelItem(new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES), 600));
	
	public static final RegistryObject<Item> MITHRIL_SWORD = ITEMS.register("mithril_dagger", 
			() -> new MithrilSwordItem(ModToolTier.MITHRIL, 1, -1.0F,
					new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)));
	
	public static final RegistryObject<Item> MITHRIL_HELMET = ITEMS.register("mithril_helmet", 
			() -> new ArmorItem(ModArmorMaterial.MITHRIL_CHAIN, EquipmentSlotType.HEAD,
					new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)));
	public static final RegistryObject<Item> MITHRIL_CHESTPLATE = ITEMS.register("mithril_chestplate", 
			() -> new ArmorItem(ModArmorMaterial.MITHRIL_CHAIN, EquipmentSlotType.CHEST,
					new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)));
	public static final RegistryObject<Item> MITHRIL_LEGGINGS = ITEMS.register("mithril_leggings", 
			() -> new ArmorItem(ModArmorMaterial.MITHRIL_CHAIN, EquipmentSlotType.LEGS,
					new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)));
	public static final RegistryObject<Item> MITHRIL_BOOTS = ITEMS.register("mithril_boots", 
			() -> new ArmorItem(ModArmorMaterial.MITHRIL_CHAIN, EquipmentSlotType.FEET,
					new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)));

}
