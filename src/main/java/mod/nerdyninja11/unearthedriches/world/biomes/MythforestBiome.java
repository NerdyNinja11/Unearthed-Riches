package mod.nerdyninja11.unearthedriches.world.biomes;

import mod.nerdyninja11.unearthedriches.init.BlockInit;
import mod.nerdyninja11.unearthedriches.world.feature.MagicTree;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MythforestBiome extends Biome {

	public static final HugeTreeFeatureConfig BIG_MAGIC_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.MAGIC_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.MAGIC_LEAVES.get().getDefaultState()))).baseHeight(8)
					.setSapling((net.minecraftforge.common.IPlantable) BlockInit.MAGIC_SAPLING.get()).build();

	public MythforestBiome() {
		super(new Biome.Builder().precipitation(RainType.RAIN).scale(0.4F).depth(0.4F).temperature(0.6F)
				.waterColor(5387423).waterFogColor(2954587)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
				.category(Category.FOREST).downfall(0.6F).parent((String) null));

	    this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.002D, MineshaftStructure.Type.NORMAL)));
	    this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addLakes(this);
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES,
				Feature.MONSTER_ROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.DUNGEONS.configure(new ChanceConfig(20))));
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addMushrooms(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addDoubleFlowers(this);
		
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 12, 4, 6));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 2, 4));

		this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 50, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 45, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 50, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 50, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.VEX, 100, 3, 4));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(MagicTree.MAGIC_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(15, 0.1F, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.DARK_OAK_TREE.withConfiguration(BIG_MAGIC_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));

	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		double d0 = INFO_NOISE.noiseAt(posX * 0.0225D, posZ * 0.0225D, false);
		return d0 < 0 ? 6793870 : 7649593;
	}

	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		return 11198866;
	}

}
