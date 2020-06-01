package mod.nerdyninja11.unearthedriches.world.feature;

import java.util.Random;

import com.google.common.collect.ImmutableList;

import mod.nerdyninja11.unearthedriches.init.BlockInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraftforge.common.IPlantable;

public class MagicTree extends Tree {
	public static final TreeFeatureConfig MAGIC_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.MAGIC_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.MAGIC_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(3, 0)))
					.baseHeight(6).heightRandA(7).foliageHeight(2).ignoreVines()
					.decorators(ImmutableList.of(new BeehiveTreeDecorator(0.005F)))
					.setSapling((IPlantable) BlockInit.MAGIC_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(MAGIC_TREE_CONFIG);
	}
}
