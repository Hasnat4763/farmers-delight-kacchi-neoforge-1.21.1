package com.hasnat4763.kacchi.fluids;

import com.hasnat4763.kacchi.kacchi;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.fromNamespaceAndPath(kacchi.MODID,"block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(kacchi.MODID, "block/water_flow");
    public static final ResourceLocation SOAP_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(kacchi.MODID,"misc/in_soap_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, kacchi.MODID);


    public static final Supplier<FluidType> CHAI_FLUID = register("chai_fluid",
            FluidType.Properties.create()
                    .density(10)
                    .viscosity(5)
                    .temperature(310)
                    .sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)
            );


    private static Supplier<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, ()-> new BaseFluidType(
                WATER_STILL_RL,
                WATER_FLOWING_RL,
                SOAP_OVERLAY_RL,
        0xA1E038,
                new Vector3f(224f/255f, 56f/255f, 208f/255f),
                properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }



}
