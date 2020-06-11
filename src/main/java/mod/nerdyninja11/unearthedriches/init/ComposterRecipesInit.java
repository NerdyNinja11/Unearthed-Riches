package mod.nerdyninja11.unearthedriches.init;

import net.minecraft.block.ComposterBlock;

public class ComposterRecipesInit {
	
	public static void initRecipes() {
		ComposterBlock.registerCompostable(1.0F, ItemInit.BIOFUEL.get());
		ComposterBlock.registerCompostable(1.0F, ItemInit.CHOCOLATE_BAR.get());
		ComposterBlock.registerCompostable(0.3F, BlockInit.MAGIC_LEAVES.get());
		ComposterBlock.registerCompostable(0.3F, BlockInit.PINE_LEAVES.get());
		ComposterBlock.registerCompostable(0.3F, BlockInit.MAGIC_SAPLING.get());
		ComposterBlock.registerCompostable(0.3F, BlockInit.PINE_SAPLING.get());

	}
}
