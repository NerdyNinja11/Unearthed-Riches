package mod.nerdyninja11.unearthedriches.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.nerdyninja11.unearthedriches.entities.LivingMushroomEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;


public class LivingMushroomEntityModel<T extends LivingMushroomEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Legs;

	public LivingMushroomEntityModel() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 2.0F, 8.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 18).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		Legs.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
	}
	
	public ModelRenderer getBody() {
		return Body;
	}
	
	public ModelRenderer getHead() {
		return Head;
	}
	
	public ModelRenderer getLegs() {
		return Legs;
	}
}