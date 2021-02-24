
package net.mcreator.megalsmod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.megalsmod.itemgroup.PlaceholdersItemGroup;
import net.mcreator.megalsmod.MegalsmodModElements;

import java.util.List;
import java.util.Collections;

@MegalsmodModElements.ModElement.Tag
public class PlaceholderBlockBlock extends MegalsmodModElements.ModElement {
	@ObjectHolder("megalsmod:placeholder_block")
	public static final Block block = null;
	public PlaceholderBlockBlock(MegalsmodModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(PlaceholdersItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE).hardnessAndResistance(2f, 5f).setLightLevel(s -> 0));
			setRegistryName("placeholder_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}
	}
}
