package pyertersmods.portersadditions.items;

import com.google.common.primitives.UnsignedInteger;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import pyertersmods.portersadditions.PortersAdditions;
import pyertersmods.portersadditions.tools.ModItemTier;
import pyertersmods.portersadditions.util.InputHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public abstract class CelestialFocus extends SwordItem {

    protected float focusMultiplier;

    protected CelestialContainer celestialContainer;

    protected float maxManaStored;
    protected float defaultmanaStored;
    protected float manaStored;
    protected float manaRegenPerTick;
    protected boolean regenManaOnTick;
    protected int regenCD;
    protected int timeSinceUse;

    protected float defaultPhysicalUseCost;

    public enum UseType {OTHER, FOCUS, PHYSICAL};

    public CelestialFocus(IItemTier tier) {
        super(tier, 0, -3.0f,
                new Properties().group(PortersAdditions.TAB)
                        .maxDamage(1000)
                        .defaultMaxDamage(1000)
                        .isImmuneToFire()
                        .addToolType(ToolType.AXE, 4)
                        .addToolType(ToolType.PICKAXE, 4)
                        .addToolType(ToolType.SHOVEL, 4));

        maxManaStored = 100f;
        defaultmanaStored = 100f;
        manaStored = 100f;
        manaRegenPerTick = 0.05f;
        regenManaOnTick = true;
        regenCD = 100;
        timeSinceUse = 0;

        defaultPhysicalUseCost = 10f;
    }

    public void onFocusCast() {
        // do some cool stuff with the celestial container
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        // 0.0 is a full bar
        // 1.0 is an empty bar
        return 1.0 - (manaStored / maxManaStored);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        return manaStored < maxManaStored;
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (InputHandler.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Mana stored: " + ((int)manaStored * 100) / 100.0f + "/" + ((int)maxManaStored * 100) / 100.0f));
            tooltip.add(new StringTextComponent("Container: " + (celestialContainer != null ? celestialContainer.getInformationTooltip() : "empty")));
        } else {
            tooltip.add(new StringTextComponent("This focus hums with uncanny power."));
            tooltip.add(new StringTextComponent("Mana stored: " + ((int)manaStored * 100) / 100.0f + "/" + ((int)maxManaStored * 100) / 100.0f));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public float getAttackDamage() {
        if (canUse(UseType.PHYSICAL)) {
            return celestialContainer != null ? celestialContainer.getPhysicalDamageMultiplier() * super.getAttackDamage() : super.getAttackDamage();
        } else {
            return -this.getTier().getAttackDamage();
        }
    }

    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken, UseType useType) {
        float useCost = getUseCost(useType);
        if (manaStored > useCost) {
            manaStored -= useCost;
        }
        timeSinceUse = 0;
        return 0;
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        return damageItem(stack, amount, entity, onBroken, UseType.PHYSICAL);
    }

    protected float getUseCost(UseType useType) {
        switch (useType) {
            case FOCUS:
                return (celestialContainer != null ? celestialContainer.getFocusUseCost() : 0);
            default:
            case PHYSICAL:
                return (celestialContainer != null ? celestialContainer.getPhysicalUseCost() : defaultPhysicalUseCost);
        }
    }

    protected boolean canUse(UseType useType) {
        return getUseCost(useType) >= manaStored;
    }

    protected boolean attemptUse(UseType useType) {
        float useCost = getUseCost(useType);
        if (useCost >= manaStored) {
            manaStored -= useCost;
            return true;
        }
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        timeSinceUse++;
        if (regenManaOnTick && regenCD < timeSinceUse) {
            manaStored = (manaRegenPerTick + manaStored > maxManaStored ? maxManaStored : manaStored + manaRegenPerTick);
        }
    }
}