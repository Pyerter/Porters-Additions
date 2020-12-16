package pyertersmods.portersadditions.util;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pyertersmods.portersadditions.PortersAdditions;
import pyertersmods.portersadditions.blocks.SapphireDustOre;
import pyertersmods.portersadditions.blocks.SapphireDustOreItem;
import pyertersmods.portersadditions.blocks.SpiralCubeItem;
import pyertersmods.portersadditions.blocks.SpiralCube;
import pyertersmods.portersadditions.items.ItemBase;
import pyertersmods.portersadditions.tools.ModItemTier;

import javax.sound.sampled.Port;

public class RegistryHandler {

    // Create DeferredRegistries for items and blocks
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PortersAdditions.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PortersAdditions.MOD_ID);

    public static void init() {

        // Register the DeferredRegistries
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> SAPPHIRE_STAR = ITEMS.register("sapphire_star", ItemBase::new);

    public static final RegistryObject<Item> SAPPHIRE_STAR_BASE = ITEMS.register("sapphire_star_base", ItemBase::new);

    public static final RegistryObject<Item> SAPPHIRE_DUST = ITEMS.register("sapphire_dust", ItemBase::new);

    // Tools
    public static final RegistryObject<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_star_sword", () ->
        new SwordItem(ModItemTier.SAPPHIRE_STAR, 4, -2.0f, new Item.Properties().group(PortersAdditions.TAB)));

    public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_star_pickaxe", () ->
            new PickaxeItem(ModItemTier.SAPPHIRE_STAR, 1, -2.6f, new Item.Properties().group(PortersAdditions.TAB)));

    public static final RegistryObject<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_star_axe", () ->
            new AxeItem(ModItemTier.SAPPHIRE_STAR, 8, -2.8f, new Item.Properties().group(PortersAdditions.TAB)));

    public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_star_shovel", () ->
            new ShovelItem(ModItemTier.SAPPHIRE_STAR, 0.5f, -2.4f, new Item.Properties().group(PortersAdditions.TAB)));

    public static final RegistryObject<HoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_star_hoe", () ->
            new HoeItem(ModItemTier.SAPPHIRE_STAR, -2, -1.0f, new Item.Properties().group(PortersAdditions.TAB)));

    // Blocks
    public static final RegistryObject<Block> SPIRAL_CUBE = BLOCKS.register("spiral_cube", SpiralCube::new);

    public static final RegistryObject<Block> SAPPHIRE_DUST_ORE = BLOCKS.register("sapphire_dust_ore", SapphireDustOre::new);

    // Block Items
    public static final RegistryObject<Item> SPIRAL_CUBE_ITEM = ITEMS.register("spiral_cube", () -> new SpiralCubeItem(SPIRAL_CUBE.get()));

    public static final RegistryObject<Item> SAPPHIRE_DUST_ORE_ITEM = ITEMS.register("sapphire_dust_ore", () -> new SapphireDustOreItem(SAPPHIRE_DUST_ORE.get()));

}
