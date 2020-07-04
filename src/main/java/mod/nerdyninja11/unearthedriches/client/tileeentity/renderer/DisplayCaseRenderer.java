package mod.nerdyninja11.unearthedriches.client.tileeentity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.nerdyninja11.unearthedriches.tileentity.DisplayCaseTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class DisplayCaseRenderer extends TileEntityRenderer<DisplayCaseTileEntity>{
	
	private float degrees;
	

	public DisplayCaseRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
		degrees = 0.0f;
	}

	@Override
	public void render(DisplayCaseTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		NonNullList<ItemStack> items = tileEntityIn.getItems();
		for (ItemStack stack: items) {
			if (!stack.isEmpty()) {
				matrixStackIn.push();
				matrixStackIn.scale(0.75f, 0.75f, 0.75f);
				matrixStackIn.translate(0.67D, 0.8D, 0.67D);
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(degrees ++ / 4 ));
				renderItem(stack, partialTicks, matrixStackIn, bufferIn, combinedLightIn);
				matrixStackIn.pop();
				
			}
		} 
		
	}
	
	private void renderItem(ItemStack stack, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn) {
		Minecraft.getInstance().getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
	}

}
