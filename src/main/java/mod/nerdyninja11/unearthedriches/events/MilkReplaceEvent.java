package mod.nerdyninja11.unearthedriches.events;

import javax.annotation.Nullable;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.init.FluidInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.FORGE)
public class MilkReplaceEvent {
	@SubscribeEvent
	public static void milkPlaceEvent(PlayerInteractEvent.RightClickItem event) {
		PlayerEntity playerIn = event.getPlayer();
		
		if (playerIn.getHeldItem(event.getHand()).getItem() instanceof MilkBucketItem) {
			  World worldIn = playerIn.getEntityWorld();
			  ItemStack itemstack = event.getItemStack();
			  RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.NONE);
			  if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
		         return;
		      } else {
		         BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
		         BlockPos blockpos = blockraytraceresult.getPos();
		         Direction direction = blockraytraceresult.getFace();
		         BlockPos blockpos1 = blockpos.offset(direction);
		         if (worldIn.isBlockModifiable(playerIn, blockpos) && playerIn.canPlayerEdit(blockpos1, direction, itemstack)) {
		               if (tryPlaceContainedLiquid(playerIn, worldIn, blockpos1, blockraytraceresult)) {
		                  if (playerIn instanceof ServerPlayerEntity) {
		                     CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, blockpos1, itemstack);
		                  }
		                  
		                  playerIn.addStat(Stats.ITEM_USED.get(itemstack.getItem()));
		                  playerIn.setItemStackToSlot(event.getHand() == Hand.MAIN_HAND ? EquipmentSlotType.MAINHAND : EquipmentSlotType.OFFHAND, new ItemStack(Items.BUCKET));
		               }
		               }
		            }
		         } 
		      }
		   

	@SuppressWarnings("deprecation")
	private static boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World worldIn, BlockPos posIn, @Nullable BlockRayTraceResult result) {
	         BlockState blockstate = worldIn.getBlockState(posIn);
	         Material material = blockstate.getMaterial();
	         boolean flag = blockstate.isReplaceable(FluidInit.MILK_FLUID.get());
	         if (blockstate.isAir() || flag) {
	            if (worldIn.dimension.doesWaterVaporize() && FluidInit.MILK_FLUID.get().isIn(FluidTags.WATER)) {
	               int i = posIn.getX();
	               int j = posIn.getY();
	               int k = posIn.getZ();
	               worldIn.playSound(player, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

	               for(int l = 0; l < 8; ++l) {
	                  worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
	               }
	            } else {
	               if (!worldIn.isRemote && flag && !material.isLiquid()) {
	                  worldIn.destroyBlock(posIn, true);
	               }

	               worldIn.playSound(player, posIn, FluidInit.MILK_FLUID.get().getAttributes().getEmptySound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
	               worldIn.setBlockState(posIn, FluidInit.MILK_FLUID.get().getDefaultState().getBlockState(), 11);
	            }

	            return true;
	         } else {
	            return result == null ? false : tryPlaceContainedLiquid(player, worldIn, result.getPos().offset(result.getFace()), (BlockRayTraceResult)null);
	         }
	      }
	
	
	   private static RayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
		      float f = player.rotationPitch;
		      float f1 = player.rotationYaw;
		      Vec3d vec3d = player.getEyePosition(1.0F);
		      float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		      float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		      float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
		      float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
		      float f6 = f3 * f4;
		      float f7 = f2 * f4;
		      double d0 = player.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();;
		      Vec3d vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
		      return worldIn.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
		   }
	   
}
	

