package pyertersmods.portersadditions.items;

public class CelestialContainer extends ItemBase {

    protected float physicalDamageMultiplier;
    protected float physicalUseCost;

    protected float focusDamageMultiplier;
    protected float focusPowerBase;
    protected float focusPowerMultiplier;
    protected float focusUseCost;

    public CelestialContainer() {
        super();

        physicalDamageMultiplier = 1.0f;
        physicalUseCost = 10.0f;

        focusDamageMultiplier = 1.0f;
        focusPowerBase = 1.0f;
        focusPowerMultiplier = 1.0f;
        focusUseCost = 1.0f;
    }

    public float getPhysicalDamageMultiplier() {
        return physicalDamageMultiplier;
    }

    public float getPhysicalUseCost() {
        return physicalUseCost;
    }

    public float getFocusUseCost() {
        return focusUseCost;
    }

    public String getInformationTooltip() {
        return "neat container";
    }

}
