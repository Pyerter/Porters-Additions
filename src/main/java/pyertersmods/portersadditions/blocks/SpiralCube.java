package pyertersmods.portersadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SpiralCube extends Block {


    public SpiralCube() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(25.0f, 30.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
    }
}
