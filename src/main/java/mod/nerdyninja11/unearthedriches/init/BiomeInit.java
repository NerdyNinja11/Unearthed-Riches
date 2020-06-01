package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.world.biomes.MythforestBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			UnearthedRiches.MOD_ID);

	public static final RegistryObject<Biome> MYTHFOREST_BIOME = BIOMES.register("mythforest_biome",
			() -> new MythforestBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.4F).depth(0.4F)
					.temperature(0.6F).waterColor(5387423).waterFogColor(2954587)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
					.category(Category.FOREST).downfall(0.6F).parent((String)null))))));
					
	
	public static void registerBiomes() {
		registerBiome(MYTHFOREST_BIOME.get(), Type.FOREST, Type.OVERWORLD);
	}
					
	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 3));
	}
}
