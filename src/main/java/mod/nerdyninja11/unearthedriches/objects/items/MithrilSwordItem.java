  package mod.nerdyninja11.unearthedriches.objects.items;

import java.util.List;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.util.helpers.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MithrilSwordItem extends SwordItem {

	public MithrilSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		this.addPropertyOverride(new ResourceLocation(UnearthedRiches.MOD_ID, "is_glowing"), new IItemPropertyGetter() {
			
			@Override
			@OnlyIn(Dist.CLIENT)
			public float call(ItemStack stack, World worldIn, LivingEntity entityIn) {
				/*boolean flag = entityIn != null;
	            Entity entity = (Entity)(flag ? entityIn : stack.getItemFrame());
	            if (worldIn == null && entity != null) {
	               worldIn = entity.world;
	            }

	            if (worldIn == null) {
	               return 0.0F;
	            } else {	
					AxisAlignedBB axisalignedbb = (new AxisAlignedBB(entityIn.getPosition())).grow(16.0D);
					//if (worldIn.getEntitiesWithinAABB(CreeperEntity.class, axisalignedbb) != null) {
					if (worldIn.isRemote) {
						return 1.0F;
					}
					return 0.0F;
	            }*/ return 0.0F;
			}
		});
		
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (KeyboardHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("Glows when there are creepers nearby"));
		} else {
			tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "SHIFT" + "\u00A77" + " for more info"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote) {
			ItemStack heldItem = playerIn.getHeldItem(handIn);
			ServerPlayerEntity player = (ServerPlayerEntity)playerIn;
			heldItem.attemptDamageItem(5, playerIn.getRNG(), player);
			
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(playerIn.getPosition())).grow(16.0D);
			List<CreeperEntity> creepers = worldIn.getEntitiesWithinAABB(CreeperEntity.class, axisalignedbb);
			for (CreeperEntity creeper : creepers) {
				creeper.addPotionEffect(new EffectInstance(Effects.GLOWING, 200));
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	
	
}
