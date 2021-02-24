
package net.mcreator.megalsmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.megalsmod.itemgroup.PlaceholdersItemGroup;
import net.mcreator.megalsmod.MegalsmodModElements;

@MegalsmodModElements.ModElement.Tag
public class PlaceholderWeaponItem extends MegalsmodModElements.ModElement {
	@ObjectHolder("megalsmod:placeholder_weapon")
	public static final Item block = null;
	public PlaceholderWeaponItem(MegalsmodModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 100;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2f, new Item.Properties().group(PlaceholdersItemGroup.tab)) {
		}.setRegistryName("placeholder_weapon"));
	}
}
