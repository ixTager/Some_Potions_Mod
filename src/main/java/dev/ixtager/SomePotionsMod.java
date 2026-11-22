package dev.ixtager;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomePotionsMod implements ModInitializer {
	public static final String MOD_ID = "some-potions-mod";

    public static final Holder<Potion> CREATIVE_POTION =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    Identifier.fromNamespaceAndPath(MOD_ID, "creative"),
                    new Potion("creative",
                            new MobEffectInstance(
                                    CustomModEffects.CREATIVE,
                                    3600,
                                    0)));

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.addMix(
                    // Input potion.
                    Potions.WATER,
                    // Ingredient
                    Items.NETHER_STAR,
                    // Output potion.
                    CREATIVE_POTION
            );
        });
    }

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
