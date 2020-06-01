package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.objects.blocks.ChainBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableLeavesBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableLogBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.ModPressurePlateBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.ModSaplingBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.ModWoodButtonBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.QuarryBlock;
import mod.nerdyninja11.unearthedriches.world.feature.MagicTree;
import mod.nerdyninja11.unearthedriches.world.feature.PineTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f).lightValue(3)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MITHRIL_ORE = BLOCKS.register("mithril_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> MITHRIL_CHAIN = BLOCKS.register("mithril_chain", () -> new ChainBlock(
			Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry", () -> new QuarryBlock(
			Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> MAGIC_PLANKS = BLOCKS.register("magic_planks",
			() -> new FlammableBlock(
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
						.hardnessAndResistance(3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE), 20, 5));
	public static final RegistryObject<Block> MAGIC_STAIRS = BLOCKS.register("magic_stairs",
			() -> new StairsBlock(() -> MAGIC_PLANKS.get().getDefaultState(),
					Block.Properties.from(MAGIC_PLANKS.get())));
	public static final RegistryObject<Block> MAGIC_FENCE = BLOCKS.register("magic_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
					.hardnessAndResistance(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MAGIC_FENCE_GATE = BLOCKS.register("magic_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
					.hardnessAndResistance(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MAGIC_BUTTON = BLOCKS.register("magic_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
					.hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MAGIC_PRESSURE_PLATE = BLOCKS.register("magic_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA).doesNotBlockMovement()
							.hardnessAndResistance(0.5F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> MAGIC_LOG = BLOCKS.register("magic_log",
			() -> new FlammableLogBlock(MaterialColor.BLUE_TERRACOTTA,
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
						.hardnessAndResistance(3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE), 5, 5));
	public static final RegistryObject<Block> MAGIC_LEAVES = BLOCKS.register("magic_leaves",() -> new FlammableLeavesBlock(
			Block.Properties.create(Material.LEAVES, MaterialColor.BLUE_TERRACOTTA)
				.hardnessAndResistance(0.2f).sound(SoundType.WOOD).tickRandomly().sound(SoundType.PLANT).notSolid(), 60, 30, 2));
	public static final RegistryObject<Block> MAGIC_SAPLING = BLOCKS.register("magic_sapling",() -> new ModSaplingBlock(
			() -> new MagicTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	

	public static final RegistryObject<Block> PINE_PLANKS = BLOCKS.register("pine_planks",
			() -> new FlammableBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)
					.hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE), 20, 5));
	public static final RegistryObject<Block> PINE_STAIRS = BLOCKS.register("pine_stairs",
			() -> new StairsBlock(() -> PINE_PLANKS.get().getDefaultState(), Block.Properties.from(PINE_PLANKS.get())));
	public static final RegistryObject<Block> PINE_FENCE = BLOCKS.register("pine_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)
					.hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_FENCE_GATE = BLOCKS.register("pine_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)
					.hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_BUTTON = BLOCKS.register("pine_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
					.hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_PRESSURE_PLATE = BLOCKS.register("pine_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.GOLD).doesNotBlockMovement()
							.hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> PINE_LOG = BLOCKS.register("pine_log",
			() -> new FlammableLogBlock(MaterialColor.BLUE_TERRACOTTA,
					 Block.Properties.from(Blocks.SPRUCE_LOG), 5, 5));
	public static final RegistryObject<Block> PINE_LEAVES = BLOCKS.register("pine_leaves",() -> new FlammableLeavesBlock(
			 Block.Properties.from(Blocks.SPRUCE_LEAVES), 60, 30, 1));
	public static final RegistryObject<Block> PINE_SAPLING = BLOCKS.register("pine_sapling",() -> new ModSaplingBlock(
			() -> new PineTree(), Block.Properties.from(Blocks.SPRUCE_SAPLING)));

}
