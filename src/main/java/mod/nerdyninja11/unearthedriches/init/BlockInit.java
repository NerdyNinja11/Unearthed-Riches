package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.objects.blocks.ChainBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.DisplayCaseBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableFenceBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableFenceGateBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableLeavesBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableLogBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableSlabBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableStairsBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.FlammableWoodBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.ModDoorBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.ModPressurePlateBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.ModSaplingBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.ModTrapDoorBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.ModWoodButtonBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.NetherChestBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.QuarryBlock;
import mod.nerdyninja11.unearthedriches.objects.blocks.StrippableLogBlock;
import mod.nerdyninja11.unearthedriches.world.feature.MagicTree;
import mod.nerdyninja11.unearthedriches.world.feature.PineTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SoundType;
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
			() -> new FlammableBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
					.hardnessAndResistance(3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE), 20, 5));
	public static final RegistryObject<Block> MAGIC_STAIRS = BLOCKS.register("magic_stairs",
			() -> new FlammableStairsBlock(() -> MAGIC_PLANKS.get().getDefaultState(),
					Block.Properties.from(MAGIC_PLANKS.get()), 20, 5));
	public static final RegistryObject<Block> MAGIC_FENCE = BLOCKS.register("magic_fence",
			() -> new FlammableFenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
					.hardnessAndResistance(3.0F).sound(SoundType.WOOD), 20, 5));
	public static final RegistryObject<Block> MAGIC_FENCE_GATE = BLOCKS.register("magic_fence_gate",
			() -> new FlammableFenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
					.hardnessAndResistance(3.0F).sound(SoundType.WOOD), 20, 5));
	public static final RegistryObject<Block> MAGIC_BUTTON = BLOCKS.register("magic_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
					.hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MAGIC_PRESSURE_PLATE = BLOCKS.register("magic_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA).doesNotBlockMovement()
							.hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MAGIC_SLAB = BLOCKS.register("magic_slab",
			() -> new FlammableSlabBlock(Block.Properties.from(MAGIC_PLANKS.get()), 20, 5));
	public static final RegistryObject<Block> MAGIC_DOOR = BLOCKS.register("magic_door",
			() -> new ModDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
					.hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final RegistryObject<Block> MAGIC_TRAPDOOR = BLOCKS.register("magic_trapdoor",
			() -> new ModTrapDoorBlock(Block.Properties.from(MAGIC_DOOR.get())));

	
	public static final RegistryObject<Block> STRIPPED_MAGIC_LOG = BLOCKS.register("stripped_magic_log",
			() -> new FlammableLogBlock(MaterialColor.BLUE_TERRACOTTA,
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
					.hardnessAndResistance(3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE),5, 5));
	public static final RegistryObject<Block> STRIPPED_MAGIC_WOOD = BLOCKS.register("stripped_magic_wood",
			() -> new FlammableBlock(Block.Properties.from(STRIPPED_MAGIC_LOG.get()),5, 5));
	
	public static final RegistryObject<Block> MAGIC_LOG = BLOCKS.register("magic_log",
			() -> new StrippableLogBlock(MaterialColor.BLUE_TERRACOTTA,
					Block.Properties.from(STRIPPED_MAGIC_LOG.get()), 5, 5, STRIPPED_MAGIC_LOG.get()));
	public static final RegistryObject<Block> MAGIC_WOOD = BLOCKS.register("magic_wood",
			() -> new FlammableWoodBlock(Block.Properties.from(MAGIC_LOG.get()),5, 5, STRIPPED_MAGIC_WOOD.get()));
	
	public static final RegistryObject<Block> MAGIC_LEAVES = BLOCKS.register("magic_leaves",
			() -> new FlammableLeavesBlock(Block.Properties.create(Material.LEAVES, MaterialColor.LIME_TERRACOTTA)
					.hardnessAndResistance(0.2f).sound(SoundType.WOOD).tickRandomly().sound(SoundType.PLANT).notSolid(),
					60, 30, 2));
	public static final RegistryObject<Block> MAGIC_SAPLING = BLOCKS.register("magic_sapling",
			() -> new ModSaplingBlock(() -> new MagicTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

	public static final RegistryObject<Block> PINE_PLANKS = BLOCKS.register("pine_planks",
			() -> new FlammableBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)
					.hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE), 20, 5));
	public static final RegistryObject<Block> PINE_STAIRS = BLOCKS.register("pine_stairs",
			() -> new FlammableStairsBlock(() -> PINE_PLANKS.get().getDefaultState(), Block.Properties.from(PINE_PLANKS.get()), 20, 5));
	public static final RegistryObject<Block> PINE_FENCE = BLOCKS.register("pine_fence",
			() -> new FlammableFenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)
					.hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD), 20, 5));
	public static final RegistryObject<Block> PINE_FENCE_GATE = BLOCKS.register("pine_fence_gate",
			() -> new FlammableFenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)
					.hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD), 20, 5));
	public static final RegistryObject<Block> PINE_BUTTON = BLOCKS.register("pine_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
					.hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_PRESSURE_PLATE = BLOCKS.register("pine_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.GOLD).doesNotBlockMovement()
							.hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_SLAB = BLOCKS.register("pine_slab",
			() -> new FlammableSlabBlock(Block.Properties.from(PINE_PLANKS.get()), 20, 5));
	public static final RegistryObject<Block> PINE_DOOR = BLOCKS.register("pine_door",
			() -> new ModDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)
					.hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final RegistryObject<Block> PINE_TRAPDOOR = BLOCKS.register("pine_trapdoor",
			() -> new ModTrapDoorBlock(Block.Properties.from(PINE_DOOR.get())));

	
	public static final RegistryObject<Block> STRIPPED_PINE_LOG = BLOCKS.register("stripped_pine_log",
			() -> new FlammableLogBlock(MaterialColor.GOLD, Block.Properties.from(Blocks.STRIPPED_SPRUCE_LOG),5, 5));
	public static final RegistryObject<Block> STRIPPED_PINE_WOOD = BLOCKS.register("stripped_pine_wood",
			() -> new FlammableBlock(Block.Properties.from(Blocks.STRIPPED_SPRUCE_WOOD),5, 5));
	
	public static final RegistryObject<Block> PINE_LOG = BLOCKS.register("pine_log",
			() -> new StrippableLogBlock(MaterialColor.GOLD, Block.Properties.from(Blocks.SPRUCE_LOG), 5, 5, STRIPPED_PINE_LOG.get()));
	public static final RegistryObject<Block> PINE_WOOD = BLOCKS.register("pine_wood",
			() -> new FlammableWoodBlock(Block.Properties.from(PINE_LOG.get()),5, 5, STRIPPED_PINE_WOOD.get()));
	
	public static final RegistryObject<Block> PINE_LEAVES = BLOCKS.register("pine_leaves",
			() -> new FlammableLeavesBlock(Block.Properties.from(Blocks.SPRUCE_LEAVES), 60, 30, 1));
	public static final RegistryObject<Block> PINE_SAPLING = BLOCKS.register("pine_sapling",
			() -> new ModSaplingBlock(() -> new PineTree(), Block.Properties.from(Blocks.SPRUCE_SAPLING)));

	public static final RegistryObject<Block> NETHER_CHEST = BLOCKS.register("nether_chest",
			() -> new NetherChestBlock(Block.Properties.from(Blocks.RED_NETHER_BRICKS)));
	public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case",
			() -> new DisplayCaseBlock(Block.Properties.from(Blocks.GLASS)));

	public static final RegistryObject<Block> COBBLESTONE_ROAD = BLOCKS.register("cobblestone_road",
			() -> new Block(Block.Properties.from(Blocks.COBBLESTONE).speedFactor(1.35F)));

}
