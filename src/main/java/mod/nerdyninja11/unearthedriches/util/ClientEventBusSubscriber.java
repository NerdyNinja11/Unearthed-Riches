package mod.nerdyninja11.unearthedriches.util;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.client.entity.render.LivingMusroomEntityRenderer;
import mod.nerdyninja11.unearthedriches.client.gui.DisplayCaseScreen;
import mod.nerdyninja11.unearthedriches.client.gui.NetherChestScreen;
import mod.nerdyninja11.unearthedriches.client.tileeentity.renderer.DisplayCaseRenderer;
import mod.nerdyninja11.unearthedriches.init.BlockInit;
import mod.nerdyninja11.unearthedriches.init.ModContainerTypes;
import mod.nerdyninja11.unearthedriches.init.ModEntityTypes;
import mod.nerdyninja11.unearthedriches.init.ModTileEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ModContainerTypes.NETHER_CHEST.get(), NetherChestScreen::new);
		ScreenManager.registerFactory(ModContainerTypes.DISPLAY_CASE.get(), DisplayCaseScreen::new);

		RenderTypeLookup.setRenderLayer(BlockInit.MAGIC_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PINE_SAPLING.get(), RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(BlockInit.MAGIC_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PINE_DOOR.get(), RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(BlockInit.MAGIC_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DISPLAY_CASE.get(), RenderType.getCutout());

		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LIVING_MUSHROOM_ENTITY.get(),
				LivingMusroomEntityRenderer::new);
		
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.DISPLAY_CASE.get(), DisplayCaseRenderer::new);
		
	}
}
