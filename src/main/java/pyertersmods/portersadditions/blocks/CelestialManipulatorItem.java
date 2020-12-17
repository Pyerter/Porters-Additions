package pyertersmods.portersadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import pyertersmods.portersadditions.PortersAdditions;

public class CelestialManipulatorItem extends BlockItem {

    public CelestialManipulatorItem(Block block) {
        super(block, new Item.Properties().group(PortersAdditions.TAB));
    }

}
