package cn.foggyhillside.dumplings_delight.item;

import cn.foggyhillside.dumplings_delight.registry.DumplingsDelightEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.LONG_DURATION;

public class DumplingsDelightFoodValues {
    public static final FoodProperties PORK_CABBAGE_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(8).saturationMod(0.9F).build();
    public static final FoodProperties PORK_CARROT_WONTON = new FoodProperties.Builder().nutrition(14).saturationMod(0.5F).effect(new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties PORK_MUSHROOM_WONTON = new FoodProperties.Builder().nutrition(12).saturationMod(0.6F).effect(new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties PORK_CABBAGE_WONTON = new FoodProperties.Builder().nutrition(11).saturationMod(0.8F).effect(new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties FUNGUS_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties PORK_KELP_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(7).saturationMod(0.8F).build();
    public static final FoodProperties CALAMARI_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(7).saturationMod(0.8F).build();
    public static final FoodProperties PORK_CELERY_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(8).saturationMod(0.9F).build();
    public static final FoodProperties DANDELION_LEAF_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).effect(new MobEffectInstance(MobEffects.REGENERATION, 3*20, 0), 1.0F).build();
    public static final FoodProperties PUFFERFISH_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).effect(new MobEffectInstance(MobEffects.POISON, 3*20, 0), 0.01F).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 3*20, 0), 1.0F).build();
    public static final FoodProperties RABBIT_MEAT_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).effect(new MobEffectInstance(MobEffects.JUMP, 15*20, 0), 1.0F).build();
    public static final FoodProperties TOMATO_EGG_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties MUTTON_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties BEEF_TOMATO_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(8).saturationMod(0.9F).build();
    public static final FoodProperties CHICKEN_MUSHROOM_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(7).saturationMod(0.8F).build();
    public static final FoodProperties MUSHROOM_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties COD_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties PORK_POTATO_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).build();
    public static final FoodProperties SALMON_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).build();
    public static final FoodProperties EGGPLANT_EGG_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();
    public static final FoodProperties GARLIC_CLOVE = new FoodProperties.Builder().nutrition(0).saturationMod(0).effect(new MobEffectInstance(DumplingsDelightEffects.GARLIC.get(), 18*20, 0), 1).alwaysEat().build();
    public static final FoodProperties CALAMARI = new FoodProperties.Builder().nutrition(1).saturationMod(0.4F).build();
    public static final FoodProperties CHINESE_CABBAGE = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties CHINESE_CABBAGE_LEAF = new FoodProperties.Builder().nutrition(1).saturationMod(0.4F).build();
    public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).effect(new MobEffectInstance(DumplingsDelightEffects.GARLIC.get(), 75*20, 0), 1).alwaysEat().build();
    public static final FoodProperties GREENONION = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties EGGPLANT = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties GARLIC_CHIVE = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties FENNEL = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties GARLIC_CHIVE_EGG_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).build();
    public static final FoodProperties PORK_FENNEL_BOILED_DUMPLING = new FoodProperties.Builder().nutrition(6).saturationMod(0.7F).build();



}
