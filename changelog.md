## 0.0.29 (ALPHA)
* more DataProvider fixes

## 0.0.28 (ALPHA)
* fixed DataProviders
* bunch of VanillaCompat helper methods
* `StructurePieces` now use Weighted List
* deprecated FlammableBlocks

## 0.0.27 (ALPHA)
* added `flammableStair()` to BlockRegistry
* added `hasEnchantment()`
* added helper methods for buttons to `BlockRegistry`
* removed deprecated methods
* ported to 1.19.3

## 0.0.26 (ALPHA)
* added `getApplicableSlots()` to `Enchantment`
* added more flammable blocks
* renamed `FlammableRotatedPillarBlock` to `FlammableLogBlock`
* `LiquidBlock`s now generate an empty model with particle texture
* fixes mixins

## 0.0.25 (ALPHA)
* added `FlammableBlock` and default implementations for Leaves, Planks and Logs/Woods
* fixed flammability for some blocks
* fixed `addFlowerPot()`
* fixed mixins
* deprecated a lot of unnecessary `BlockRegistry` helper methods

## 0.0.24 (ALPHA)
* added `LockedSlot`
* added helper methods for smoking recipes
* added helper method for Flower Pots

## 0.0.23 (ALPHA)
* added `ColorToIntWithAlpha`
* added `SimpleFluidType` and `CustomFluidType`
* added `stoneButton()` to `BlockRegistry`

## 0.0.22 (ALPHA)
* added proper build method to `StructurePieces.Builder`
* added method for copying `BlockBehaviour.Properties` (experimental)

## 0.0.21 (ALPHA)
* added `addCompostable`
* `xpDroppingBlock` now takes an `IntProvider`
* added base for `ExtendedLootTableProvider`
* added `StructurePieces` (updated from DungeonsEnhanced `DEStructurePiece`)
* `PortalCatalystItem` now has a description

## 0.0.20 (ALPHA)
* added helper methods for `AxeItem#STRIPPABLES` and `PotionBrewing#addMix`
* `DataGenerator`s now use `Iterator`s (potentially breaking)

## 0.0.19 (ALPHA)
* added block registry helper methods
* added CustomTree API
* added `TerrainAnalyzer`

## 0.0.18 (ALPHA)
* fixed `PortalBlock` model generator

## 0.0.17 (ALPHA)
* added methods for converting `ChunkPos` to `BlockPos`
* added Amterin Portal API (thanks to KaupenJoe and The Undergarden mod)
* added `blockItem()` model provider with custom model
* fix `ExternalEffect` constructor was private (however that happened)
