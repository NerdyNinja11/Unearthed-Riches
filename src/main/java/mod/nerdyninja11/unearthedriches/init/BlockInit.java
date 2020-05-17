package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.objects.blocks.ChainBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.QuarryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			UnearthedRiches.MOD_ID);

	public static final RegistryObject<Block> MITHRIL_BLOCK = BLOCKS.register("mithril_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f)
					.sound(SoundType.METAL).lightValue(4).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> RAW_MITHRIL_ORE = BLOCKS.register("raw_mithril_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f)
					.lightValue(3).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MITHRIL_ORE = BLOCKS.register("mithril_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> MITHRIL_CHAIN = BLOCKS.register("mithril_chain",
			() -> new ChainBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f)
					.harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry",
			() -> new QuarryBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f)
					.harvestTool(ToolType.PICKAXE)));
	
	
	

}
