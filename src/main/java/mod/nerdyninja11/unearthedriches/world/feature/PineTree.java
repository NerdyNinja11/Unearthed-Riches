package mod.nerdyninja11.unearthedriches.world.feature;

import java.util.Random;

import mod.nerdyninja11.unearthedriches.init.BlockInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class PineTree extends Tree {
	public static final TreeFeatureConfig PINE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.PINE_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.PINE_LEAVES.get().getDefaultState()), new PineFoliagePlacer(1, 0)))
					.baseHeight(7).heightRandA(4).trunkTopOffset(1).foliageHeight(3).foliageHeightRandom(1)
					.ignoreVines().setSapling((IPlantable) BlockInit.PINE_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG);
	}
}
