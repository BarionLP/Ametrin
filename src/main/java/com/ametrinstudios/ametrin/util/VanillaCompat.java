package com.ametrinstudios.ametrin.util;

import com.google.common.collect.ImmutableMap;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.ApiStatus;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class VanillaCompat {
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final Map<Block, Block> _strippableRequests = new HashMap<>();
    private static boolean _pushed = false;

    /**
     * Registers simple brewing recipes
     * call during {@link FMLCommonSetupEvent}
     */
    public static void addBrewingRecipe(Potion startPotion, Item ingredient, Potion resultPotion){
        PotionBrewing.addMix(startPotion, ingredient, resultPotion);
    }

    /**
     * @param chance
     * Cake: 1
     * Bread: 0.85
     * Apple/Flower: 0.65
     * Vines: 0.5
     * Sapling/Seed: 0.3
     * call during {@link FMLCommonSetupEvent}
     */
    public static void addCompostable(ItemLike item, float chance){
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }

    /**
     * Registers FlowerPots
     * call during {@link FMLCommonSetupEvent}
     */
    public static void addFlowerPot(ResourceLocation plant, Supplier<? extends FlowerPotBlock> fullPot){
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plant, fullPot);
    }

    /**
     * Allows blocks to be converted by an axe (e.g. oak log to stripped oak log)
     * both blocks need to have the {@link RotatedPillarBlock#AXIS} state (stupid minecraft...)
     * call during {@link FMLCommonSetupEvent}
     */
    public static void addStrippable(Block log, Block strippedLog){
        _strippableRequests.put(log, strippedLog);
        if(_pushed){
            throw new UnsupportedOperationException("Strippables must be registered during FMLCommonSetupEvent");
        }
    }

    /**
     * Allows blocks to be converted by a shovel (e.g. grass block to path block)
     * call during {@link FMLCommonSetupEvent}
     */
    public static void addFlattenable(Block block, BlockState flattenedBlockState){
        ShovelItem.FLATTENABLES.put(block, flattenedBlockState);
    }

    /**
     * Allows blocks to be converted by a shovel (e.g. grass block to path block)
     * call during {@link FMLCommonSetupEvent}
     */
    public static void addFlattenable(Block block, Block flattenedBlock){
        addFlattenable(block, flattenedBlock.defaultBlockState());
    }

    public interface Flammable{
        static void add(Block block, int encouragement, int flammability){
            ((FireBlock)Blocks.FIRE).setFlammable(block, encouragement, flammability);
        }
        static void addLog(Block log) {add(log, 5, 5);}
        static void addPlank(Block plank) {add(plank, 5, 20);}
        static void addLeave(Block leave) {add(leave, 30, 60);}
        static void addPlant(Block plant) {add(plant, 60, 100);}
        static void addWool(Block wool) {add(wool, 30, 60);}
        static void addCarpet(Block carpet) {add(carpet, 60, 20);}
    }


    @ApiStatus.Internal
    public static void PushRequests(){
        AxeItem.STRIPPABLES = (new ImmutableMap.Builder<Block, Block>()).putAll(AxeItem.STRIPPABLES).putAll(_strippableRequests).build();
        _pushed = true;
    }
}