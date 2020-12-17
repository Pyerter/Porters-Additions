package pyertersmods.portersadditions.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import pyertersmods.portersadditions.util.RegistryHandler;

import java.util.function.Supplier;

/*
 * This class holds tiers of items for weapons.
 */
public enum ModItemTier implements IItemTier {

    SAPPHIRE_STAR(4, 3000, 12.0f, 5.0f, 25, () -> Ingredient.fromItems(RegistryHandler.SAPPHIRE_SWORD.get()));

    private final int HARVEST_LEVEL;
    private final int MAX_USES;
    private final float EFFICIENY;
    private final float ATTACK_DAMAGE;
    private final int ENCHANTABILITY;
    private final Supplier<Ingredient> REPAIR_MATERIAL;

    ModItemTier(int harvestLevel, int maxUses, float efficieny, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        HARVEST_LEVEL = harvestLevel;
        MAX_USES = maxUses;
        EFFICIENY = efficieny;
        ATTACK_DAMAGE = attackDamage;
        ENCHANTABILITY = enchantability;
        REPAIR_MATERIAL = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return MAX_USES;
    }

    @Override
    public float getEfficiency() {
        return EFFICIENY;
    }

    @Override
    public float getAttackDamage() {
        return ATTACK_DAMAGE;
    }

    @Override
    public int getHarvestLevel() {
        return HARVEST_LEVEL;
    }

    @Override
    public int getEnchantability() {
        return ENCHANTABILITY;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return REPAIR_MATERIAL.get();
    }
}
