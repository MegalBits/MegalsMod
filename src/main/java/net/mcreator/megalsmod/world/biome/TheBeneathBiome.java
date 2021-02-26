
package net.mcreator.megalsmod.world.biome;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.SoundAdditionsAmbience;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.block.Blocks;

import net.mcreator.megalsmod.MegalsmodModElements;

import com.google.common.collect.ImmutableList;

@MegalsmodModElements.ModElement.Tag
public class TheBeneathBiome extends MegalsmodModElements.ModElement {
	public static Biome biome;
	public TheBeneathBiome(MegalsmodModElements instance) {
		super(instance, 29);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(12638463).setWaterColor(4159204).setWaterFogColor(329011)
						.withSkyColor(7972607).withFoliageColor(10387789).withGrassColor(9470285)
						.setAmbientSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.underwater.loop")))
						.setMoodSound(new MoodSoundAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.underwater.loop.additions.ultra_rare")), 10000, 8, 2))
						.setAdditionsSound(new SoundAdditionsAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.underwater.loop.additions")), 0.0111D))
						.setMusic(new BackgroundMusicSelector(
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("music.creative")), 12000,
								24000, true))
						.setParticle(new ParticleEffectAmbience(ParticleTypes.FALLING_WATER, 0.003f)).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.WATER.getDefaultState(),
								Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState())));
				biomeGenerationSettings.withStructure(StructureFeatures.MONUMENT);
				biomeGenerationSettings.withStructure(StructureFeatures.SHIPWRECK);
				biomeGenerationSettings.withStructure(StructureFeatures.OCEAN_RUIN_COLD);
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK
								.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), FeatureSpread.func_242253_a(2, 4), 2,
										ImmutableList.of(Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(100));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK
								.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(2, 3), 2,
										ImmutableList.of(Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(70));
				DefaultBiomeFeatures.withSimpleSeagrass(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.COD, 2, 4, 10));
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.SALMON, 1, 3, 7));
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 3, 5, 14));
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.DOLPHIN, 1, 1, 3));
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.SQUID, 2, 1, 20));
				biome = new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.NONE).depth(10f).scale(0f).temperature(0.5f)
						.downfall(0f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("megalsmod:the_beneath"));
			}
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
