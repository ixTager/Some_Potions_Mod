package dev.ixtager;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;

public class CreativeEffect extends MobEffect {
    protected CreativeEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFD700);
    }

    protected CreativeEffect(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            serverPlayer.setGameMode(GameType.CREATIVE);
        }

        return super.applyEffectTick(level, entity, amplifier);
    }


}
