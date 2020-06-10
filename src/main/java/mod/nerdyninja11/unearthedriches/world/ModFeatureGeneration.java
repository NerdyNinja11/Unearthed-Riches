package mod.nerdyninja11.unearthedriches.world;

import java.util.List;

import com.google.common.collect.Lists;

import mod.nerdyninja11.unearthedriches.init.BiomeInit;
import mod.nerdyninja11.unearthedriches.init.ModEntityTypes;
import mod.nerdyninja11.unearthedriches.world.feature.PineTree;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModFeatureGeneration {

	public static void biomeGen() {
		List<Biome> spawnableBiomes = Lists.newArrayList();
		spawnableBiomes.add(Biomes.TAIGA);
		spawnableBiomes.add(Biomes.TAIGA_HILLS);
		spawnableBiomes.add(Biomes.TAIGA_MOUNTAINS);

		for (Biome biome : spawnableBiomes) {
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.NORMAL_TREE.withConfiguration(PineTree.PINE_TREE_CONFIG).withPlacement(
							Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.3F, 1))));
		}
	}

	public static void entityBiomeGen() {
		List<Biome> spawnableBiomes = Lists.newArrayList();
		spawnableBiomes.add(BiomeInit.MYTHFOREST_BIOME.get());
		spawnableBiomes.add(Biomes.MUSHROOM_FIELD_SHORE);
		spawnableBiomes.add(Biomes.MUSHROOM_FIELDS);
		for (Biome biome : spawnableBiomes) {
			biome.getSpawns(EntityClassification.CREATURE)
					.add(new Biome.SpawnListEntry(ModEntityTypes.LIVING_MUSHROOM_ENTITY.get(), 20, 4, 6));
		}
	}
}
