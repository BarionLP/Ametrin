package com.ametrinstudios.ametrin.world.block;

import com.ametrinstudios.ametrin.util.VanillaCompat;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * use {@link VanillaCompat#addFlammablePlank(Block)}
 */
@Deprecated(forRemoval = true)
public class FlammablePlankBlock extends Block {
    public FlammablePlankBlock(Properties properties) {super(properties);}

    @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return true;}
    @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return 5;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return 20;}
}
