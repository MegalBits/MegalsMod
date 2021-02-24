
package net.mcreator.megalsmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.megalsmod.item.PlaceholderItemItem;
import net.mcreator.megalsmod.MegalsmodModElements;

@MegalsmodModElements.ModElement.Tag
public class PlaceholdersItemGroup extends MegalsmodModElements.ModElement {
	public PlaceholdersItemGroup(MegalsmodModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabplaceholders") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PlaceholderItemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
