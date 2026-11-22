package dev.ixtager;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

public class CustomModEffects implements ModInitializer {
    public static final Holder<MobEffect> CREATIVE =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT,
                    Identifier.fromNamespaceAndPath(SomePotionsMod.MOD_ID, "creative"),
                    new CreativeEffect());


    @Override
    public void onInitialize() {
        //
    }
}
