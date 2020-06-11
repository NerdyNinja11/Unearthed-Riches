package mod.nerdyninja11.unearthedriches.objects.items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.RegistryObject;

public class ModSpawnEggItem extends SpawnEggItem {
    private RegistryObject<?> supplier;
    
    public ModSpawnEggItem(RegistryObject<?> supplierIn, int primaryColorIn, int secondaryColorIn, Properties builder)
    {
        super(null, primaryColorIn, secondaryColorIn, builder);
        supplier = supplierIn;
    }
    
    @Override
    public EntityType<?> getType(CompoundNBT p_208076_1_)
    {
    	DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior()  {
			public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
				Direction direction = source.getBlockState().get(DispenserBlock.FACING);
				EntityType<?> entitytype = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
				entitytype.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
				stack.shrink(1);
				return stack;
			}};
			
		DispenserBlock.registerDispenseBehavior(this, defaultDispenseItemBehavior);
        return (EntityType<?>) supplier.get();
    }
    
    
}