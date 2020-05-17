  package mod.nerdyninja11.unearthedriches.objects.items;

import java.util.List;

import mod.nerdyninja11.unearthedriches.util.helpers.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class MithrilSwordItem extends SwordItem {

	public MithrilSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
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
		/*
		ItemStack heldItem = playerIn.getHeldItem(handIn);
		ServerPlayerEntity player = playerIn.getServer();
		heldItem.attemptDamageItem(5, playerIn.getRNG(), playerIn);
		*/
		playerIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 200));
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
}
