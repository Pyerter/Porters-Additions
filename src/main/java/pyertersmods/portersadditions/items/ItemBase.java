package pyertersmods.portersadditions.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import pyertersmods.portersadditions.PortersAdditions;

import java.util.function.Supplier;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(PortersAdditions.TAB));
    }

}
