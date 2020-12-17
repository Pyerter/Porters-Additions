package pyertersmods.portersadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class CelestialManipulator extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    private Properties prop;

    public CelestialManipulator() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(4.0f, 4.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
        this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH).with(LIT, false));
    }

    /*public CelestialManipulator createCelestialManipulator() {
        CelestialManipulator cm = new CelestialManipulator(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(4.0f, 4.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
        return cm;
    }*/

    /*@Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }*/

    /*@Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return
    }*/

}
