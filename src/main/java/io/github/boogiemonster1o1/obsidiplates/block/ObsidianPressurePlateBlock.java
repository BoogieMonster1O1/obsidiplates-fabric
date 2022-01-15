package io.github.boogiemonster1o1.obsidiplates.block;

import java.util.concurrent.atomic.AtomicInteger;

import net.minecraft.util.DyeColor;
import org.jetbrains.annotations.NotNull;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

public class ObsidianPressurePlateBlock extends AbstractPressurePlateBlock {
    public static final BooleanProperty POWERED = Properties.POWERED;
    private static final Box BOX = new Box(0.125D, 0.0D, 0.125D, 0.875D, 0.25D, 0.875D);
    @NotNull
    public PressurePlateType type;

    public ObsidianPressurePlateBlock(@NotNull PressurePlateType type) {
        super(FabricBlockSettings.of(Material.STONE, DyeColor.BLACK).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(25.0F, 500.0F));
        this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false));
        this.type = type;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    protected void playPressSound(WorldAccess world, BlockPos pos) {
        if (this.type.isNoisy()) {
            world.playSound(null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.5F);
        }
    }

    @Override
    protected void playDepressSound(WorldAccess world, BlockPos pos) {
        if (this.type.isNoisy()) {
            world.playSound(null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.6F);
        }
    }

    protected int getRedstoneOutput(World world, BlockPos pos) {
        Box box = BOX.offset(pos);
        AtomicInteger ret = new AtomicInteger();
        world.getOtherEntities(null, box).forEach((e) -> {
            if (e instanceof PlayerEntity) {
                ret.set(15);
            }
        });

        return ret.get();
    }

    @Override
    protected int getRedstoneOutput(BlockState state) {
        return state.get(POWERED) ? 15 : 0;
    }

    @Override
    protected BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return state.with(POWERED, rsOut > 0);
    }
}
