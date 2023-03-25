package com.ametrinstudios.ametrin.datagen;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Objects;

public class DataProviderExtensions {
    /**
     * blocks containing strings from this list try to use the plank texture in some cases look at the usages to find out where exactly
     */
    private static final ArrayList<String> plankIndicators = new ArrayList<>();


    public static void addPlankIndicator(String indicator){
        plankIndicators.add(indicator);
    }
    public static boolean isPlank(String name) {
        for(String indicator : plankIndicators){
            if(name.contains(indicator)){
                return true;
            }
        }
        return false;
    }

    public static boolean shouldAppendS(String name) {return name.matches(".*brick(?!s).*|.*tile(?!s).*");}
    public static boolean isWood(String name) {return name.matches(".*(wood|hyphae).*");}
    public static boolean isLog(String name) {return name.matches(".*(log|stem).*");}
    public static boolean isWooden(String name) {return isLog(name) || isWood(name) || name.contains("plank") || isPlank(name);}

    public static String getItemName(Item item) {return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();}
    public static String getBlockName(Block block) {return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();}
}