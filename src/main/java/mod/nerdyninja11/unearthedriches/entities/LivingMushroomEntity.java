package mod.nerdyninja11.unearthedriches.entities;

import mod.nerdyninja11.unearthedriches.init.ModEntityTypes;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class LivingMushroomEntity extends AnimalEntity {
	private static final DataParameter<Integer> LIVING_MUSHROOM_TYPE = EntityDataManager.createKey(LivingMushroomEntity.class, DataSerializers.VARINT);
	private EatGrassGoal eatGrassGoal;
	private int eatTimer;

	public LivingMushroomEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		LivingMushroomEntity entity = new LivingMushroomEntity(ModEntityTypes.LIVING_MUSHROOM_ENTITY.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		entity.setLivingMushroomType(((LivingMushroomEntity)ageable).getLivingMushroomType());
		return entity;
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
	    this.eatGrassGoal = new EatGrassGoal(this);
	    this.goalSelector.addGoal(0, new SwimGoal(this));
	    this.goalSelector.addGoal(1, new PanicGoal(this, 0.25D));
	    this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
	    this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.WHEAT), false));
	    this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
	    this.goalSelector.addGoal(5, this.eatGrassGoal);
	    this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
	    this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
	    this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void updateAITasks() {
		this.eatTimer = this.eatGrassGoal.getEatingGrassTimer();
		super.updateAITasks();
	}
	
	@Override
	public void livingTick() {
		if (this.world.isRemote) {
			this.eatTimer = Math.max(0, this.eatTimer - 1);
		}
		super.livingTick();
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.1F);
	}
	
	@Override
	public void onStruckByLightning(LightningBoltEntity lightningBolt) {
	      MooshroomEntity mooshroomEntity = EntityType.MOOSHROOM.create(this.world);
	      mooshroomEntity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
	      mooshroomEntity.setNoAI(this.isAIDisabled());
	      if (this.hasCustomName()) {
	    	  mooshroomEntity.setCustomName(this.getCustomName());
	      }

	      this.world.addEntity(mooshroomEntity);
	      this.remove();
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(LIVING_MUSHROOM_TYPE, 0);
	}
	
	public int getLivingMushroomType() {
		return this.dataManager.get(LIVING_MUSHROOM_TYPE);
	}

	public void setLivingMushroomType(int livingMushroomTypeId) {
	   this.dataManager.set(LIVING_MUSHROOM_TYPE, livingMushroomTypeId);
	}
	
	public void writeAdditional(CompoundNBT compound) {
	   super.writeAdditional(compound);
	   compound.putInt("LivingMushroomType", this.getLivingMushroomType());
	}
	
	public void readAdditional(CompoundNBT compound) {
	   super.readAdditional(compound);
	   this.setLivingMushroomType(compound.getInt("LivingMushroomType"));
	}

	
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setLivingMushroomType(this.rand.nextInt(2));
		
		return spawnDataIn;
	}
}
