package pyertersmods.portersadditions.world.gen;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
import pyertersmods.portersadditions.PortersAdditions;
import pyertersmods.portersadditions.util.RegistryHandler;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = PortersAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OreGenHandler {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres() {
        //BASE_STONE_OVERWORLD is for generating in stone, granite, diorite, and andesite

        // Overworld Ore Register
        overworldOres.add(register("sapphire_dust_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.SAPPHIRE_DUST_ORE.get().getDefaultState(), 6)) //Vein Size
                .range(18).square() //Spawn height start
                .func_242731_b(4))); //Chunk spawn frequency

        // Nether Ore Register

        // The End Ore Register
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        // Biome Gen Builder
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        // Overworld Gen
        if (event.getCategory().equals(Biome.Category.DESERT) || event.getCategory().equals(Biome.Category.OCEAN)) {
            for (ConfiguredFeature<?, ?> ore : overworldOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, PortersAdditions.MOD_ID + ":" + name, configuredFeature);
    }
}
