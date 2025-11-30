package com.hasnat4763.kacchi.block;

import com.hasnat4763.kacchi.fluids.ModFluids;
import com.hasnat4763.kacchi.kacchi;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(kacchi.MODID);
    public static final DeferredBlock<LiquidBlock> CHAI_BLOCK = BLOCKS.register("chai_block",
            ()-> new LiquidBlock(ModFluids.SOURCE_CHAI_FLUID.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final DeferredBlock<Block> CHAI_CROP = BLOCKS.register(
            "chai_crop",
            () -> new ChaiCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT))
    );


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
