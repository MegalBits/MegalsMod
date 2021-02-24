
package net.mcreator.megalsmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.megalsmod.itemgroup.PlaceholdersItemGroup;
import net.mcreator.megalsmod.MegalsmodModElements;

@MegalsmodModElements.ModElement.Tag
public class PlaceholderItemItem extends MegalsmodModElements.ModElement {
	@ObjectHolder("megalsmod:placeholder_item")
	public static final Item block = null;
	public PlaceholderItemItem(MegalsmodModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PlaceholdersItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("placeholder_item");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
