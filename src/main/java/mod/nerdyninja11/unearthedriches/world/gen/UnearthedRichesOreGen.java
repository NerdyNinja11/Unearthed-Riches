package mod.nerdyninja11.unearthedriches.world.gen;

import mod.nerdyninja11.unearthedriches.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class UnearthedRichesOreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.SWAMP || biome == Biomes.DESERT) {
				ConfiguredPlacement<CountRangeConfig> mithrilOreConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 0, 0, 32));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										BlockInit.raw_mithril_ore.getDefaultState(), 6)).withPlacement(mithrilOreConfig));
			}
		}
	}
}