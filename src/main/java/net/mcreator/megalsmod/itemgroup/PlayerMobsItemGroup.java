
package net.mcreator.megalsmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.megalsmod.item.PlayerMobCatagoryImageItem;
import net.mcreator.megalsmod.MegalsmodModElements;

@MegalsmodModElements.ModElement.Tag
public class PlayerMobsItemGroup extends MegalsmodModElements.ModElement {
	public PlayerMobsItemGroup(MegalsmodModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabplayer_mobs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PlayerMobCatagoryImageItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
