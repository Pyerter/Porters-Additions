package pyertersmods.portersadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import pyertersmods.portersadditions.PortersAdditions;

public class SapphireDustOreItem extends BlockItem {

    public SapphireDustOreItem(Block block) {
        super(block, new Item.Properties().group(PortersAdditions.TAB));
    }

}
