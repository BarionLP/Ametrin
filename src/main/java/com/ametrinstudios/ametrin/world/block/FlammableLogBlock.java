package com.ametrinstudios.ametrin.world.block;

import com.ametrinstudios.ametrin.util.VanillaCompat;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * use {@link VanillaCompat#addFlammableLog(Block)}
 */
@Deprecated(forRemoval = true)
public class FlammableLogBlock extends RotatedPillarBlock {
    public FlammableLogBlock(Properties properties) {super(properties);}

    @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return true;}
    @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return 5;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return 5;}
}