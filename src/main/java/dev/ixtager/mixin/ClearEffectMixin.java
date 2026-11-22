package dev.ixtager.mixin;

import dev.ixtager.CreativeEffect;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(LivingEntity.class)
public class ClearEffectMixin {

    @Inject(at = @At("TAIL"), method = "onEffectsRemoved")
    public void onEffectsRemoved(Collection<MobEffectInstance> collection, CallbackInfo ci) {
        if ((Object) this instanceof ServerPlayer player) {
            for (MobEffectInstance mobEffectInstance : collection) {
                if (mobEffectInstance.getEffect().value() instanceof CreativeEffect) {
                    player.setGameMode(GameType.SURVIVAL);
                }
            }
        }
    }
}
