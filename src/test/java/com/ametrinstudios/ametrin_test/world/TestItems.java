package com.ametrinstudios.ametrin_test.world;

import com.ametrinstudios.ametrin.world.item.CustomBoatItem;
import com.ametrinstudios.ametrin_test.AmetrinTestMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TestItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(AmetrinTestMod.MOD_ID);

    public static final Supplier<Item> TEST_ITEM = REGISTRY.register("test_item", ()-> new BlockItem(TestBlocks.TEST_BLOCK.get(), new Item.Properties().setNoRepair().stacksTo(16).rarity(Rarity.EPIC)));
    public static final Supplier<CustomBoatItem> TROLL_BOAT = REGISTRY.register("troll_boat", ()-> CustomBoatItem.boat(TestBoatTypes.TROLL));
    public static final Supplier<CustomBoatItem> TROLL_CHEST_BOAT = REGISTRY.register("troll_chest_boat", ()-> CustomBoatItem.chest(TestBoatTypes.TROLL));
    public static final Supplier<CustomBoatItem> BEECH_BOAT = REGISTRY.register("beech_boat", ()-> CustomBoatItem.boat(TestBoatTypes.BEECH));
    public static final Supplier<CustomBoatItem> BEECH_CHEST_BOAT = REGISTRY.register("beech_chest_boat", ()-> CustomBoatItem.chest(TestBoatTypes.BEECH));
}
