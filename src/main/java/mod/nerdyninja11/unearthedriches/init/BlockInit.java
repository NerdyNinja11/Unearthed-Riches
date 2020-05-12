package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.UnearthedRiches.UnearthedRichesItemGroup;
import mod.nerdyninja11.unearthedriches.objects.blocks.ChainBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(UnearthedRiches.MOD_ID)
@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.MOD)
public class BlockInit {
	public static final Block mithril_block = null;
	public static final Block mithril_ore = null;
	public static final Block raw_mithril_ore = null;
	
	public static final Block mithril_chain = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).lightValue(4).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("mithril_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("mithril_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f).lightValue(3).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("raw_mithril_ore"));
		
		event.getRegistry().register(new ChainBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).harvestLevel(0).harvestTool(ToolType.PICKAXE)).setRegistryName("mithril_chain"));

	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(mithril_block, new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)).setRegistryName("mithril_block"));
		event.getRegistry().register(new BlockItem(mithril_ore, new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)).setRegistryName("mithril_ore"));
		event.getRegistry().register(new BlockItem(raw_mithril_ore, new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)).setRegistryName("raw_mithril_ore"));

		event.getRegistry().register(new BlockItem(mithril_chain, new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES)).setRegistryName("mithril_chain"));

	}
}
