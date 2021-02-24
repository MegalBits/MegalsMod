package net.mcreator.megalsmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.megalsmod.MegalsmodModElements;
import net.mcreator.megalsmod.MegalsmodMod;

import java.util.Map;

@MegalsmodModElements.ModElement.Tag
public class DeepoceanRender1UpdateTickProcedure extends MegalsmodModElements.ModElement {
	public DeepoceanRender1UpdateTickProcedure(MegalsmodModElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MegalsmodMod.LOGGER.warn("Failed to load dependency x for procedure DeepoceanRender1UpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MegalsmodMod.LOGGER.warn("Failed to load dependency y for procedure DeepoceanRender1UpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MegalsmodMod.LOGGER.warn("Failed to load dependency z for procedure DeepoceanRender1UpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MegalsmodMod.LOGGER.warn("Failed to load dependency world for procedure DeepoceanRender1UpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.WATER.getDefaultState(), 3);
	}
}
