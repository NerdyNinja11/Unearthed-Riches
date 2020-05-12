package mod.nerdyninja11.unearthedriches.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelItem extends Item {
	
	private int burnTime;

	public FuelItem(Properties properties, int time) {
		super(properties);
		burnTime = time;
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return burnTime;
	}
	
}
