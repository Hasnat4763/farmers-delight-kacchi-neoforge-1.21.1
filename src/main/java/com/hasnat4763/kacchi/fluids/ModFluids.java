package com.hasnat4763.kacchi.fluids;

import com.hasnat4763.kacchi.block.ModBlocks;
import com.hasnat4763.kacchi.item.ModItems;
import com.hasnat4763.kacchi.kacchi;
import net.minecraft.core.registries.Registries;
import net.minecraft.world. level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net. neoforged.bus.api. IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net. neoforged.neoforge.registries.DeferredRegister;

import java.util. function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister. create(Registries.FLUID, kacchi.MODID);

    public static final Supplier<FlowingFluid> SOURCE_CHAI_FLUID = FLUIDS.register("chai_fluid_source",
            () -> new BaseFlowingFluid.Source(getChaiFluidProperties()));

    public static final Supplier<FlowingFluid> FLOWING_CHAI_FLUID = FLUIDS. register("chai_fluid_flowing",
            () -> new BaseFlowingFluid.Flowing(getChaiFluidProperties()));

    private static BaseFlowingFluid. Properties getChaiFluidProperties() {
        return new BaseFlowingFluid.Properties(
                ModFluidTypes.CHAI_FLUID,
                SOURCE_CHAI_FLUID,
                FLOWING_CHAI_FLUID
        )
                .slopeFindDistance(1)
                .levelDecreasePerBlock(1)
                .block(ModBlocks.CHAI_BLOCK)
                .bucket(ModItems.CHAI_BUCKET);
    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}