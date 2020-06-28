package mod.nerdyninja11.unearthedriches.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class FlammableWoodBlock extends FlammableBlock {
	private Block stripped;


	public FlammableWoodBlock(Properties properties, int flammabilityIn, int encouragementIn, Block stripTo) {
		super(properties, flammabilityIn, encouragementIn);
		stripped = stripTo;
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (player.getHeldItem(handIn).getItem() instanceof AxeItem) {
	      if (stripped != null) {
	         worldIn.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
	         if (!worldIn.isRemote) {
	            worldIn.setBlockState(pos, stripped.getDefaultState(), 11);
	            if (player != null) {
	            	player.getHeldItem(handIn).damageItem(1, player, (p_220040_1_) -> {
	                  p_220040_1_.sendBreakAnimation(handIn);
	               });
	            }
	         }

	         return ActionResultType.SUCCESS;
	      } else {
	         return ActionResultType.PASS;
	      }
		} return ActionResultType.PASS;
	}
}
