package site.liangbai.backpack.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import site.liangbai.backpack.Backpack;
import site.liangbai.backpack.capability.storage.impl.StorageImpl;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Backpack.ID);


    // ================================================================================
    // Small backpacks
    // ================================================================================

    public static final RegistryObject<Item> SMALL_RED_BACKPACK = ITEMS
            .register("small_red_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(1)));
    
    public static final RegistryObject<Item> SMALL_BLUE_BACKPACK = ITEMS
            .register("small_blue_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(1)));

    public static final RegistryObject<Item> SMALL_GREEN_BACKPACK = ITEMS
            .register("small_green_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(1)));

    public static final RegistryObject<Item> SMALL_PURPLE_BACKPACK = ITEMS
            .register("small_purple_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(1)));

    public static final RegistryObject<Item> SMALL_ORANGE_BACKPACK = ITEMS
            .register("small_orange_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(1)));

    public static final RegistryObject<Item> SMALL_YELLOW_BACKPACK = ITEMS
            .register("small_yellow_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(1)));

    // ================================================================================
    // Medium backpacks
    // ================================================================================

    public static final RegistryObject<Item> MEDIUM_BLACK_BACKPACK = ITEMS
            .register("medium_black_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_BLUE_BACKPACK = ITEMS
            .register("medium_blue_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_GHILLIE_BACKPACK = ITEMS
            .register("medium_ghillie_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_GREEN_BACKPACK = ITEMS
            .register("medium_green_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_GREY_BACKPACK = ITEMS
            .register("medium_grey_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_ORANGE_BACKPACK = ITEMS
            .register("medium_orange_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_PURPLE_BACKPACK = ITEMS
            .register("medium_purple_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_RED_BACKPACK = ITEMS
            .register("medium_red_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_WHITE_BACKPACK = ITEMS
            .register("medium_white_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    public static final RegistryObject<Item> MEDIUM_YELLOW_BACKPACK = ITEMS
            .register("medium_yellow_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(2)));

    // ================================================================================
    // Large backpacks
    // ================================================================================

    public static final RegistryObject<Item> LARGE_BLACK_BACKPACK = ITEMS
            .register("large_black_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(3)));

    public static final RegistryObject<Item> LARGE_GREY_BACKPACK = ITEMS
            .register("large_grey_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(3)));

    public static final RegistryObject<Item> LARGE_GHILLIE_BACKPACK = ITEMS
            .register("large_ghillie_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(3)));

    public static final RegistryObject<Item> LARGE_GREEN_BACKPACK = ITEMS
            .register("large_green_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(3)));

    public static final RegistryObject<Item> LARGE_TAN_BACKPACK = ITEMS
            .register("large_tan_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(3)));

    // ================================================================================
    // Gun backpacks
    // ================================================================================

    public static final RegistryObject<Item> GUN_BACKPACK = ITEMS
            .register("gun_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(1)));

    public static final RegistryObject<Item> GREY_GUN_BACKPACK = ITEMS
            .register("grey_gun_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(1)));

    // ================================================================================
    // Ammo backpacks
    // ================================================================================

    public static final RegistryObject<Item> AMMO_BACKPACK = ITEMS
            .register("ammo_backpack", () -> new StorageItem(new Item.Properties()
                    .maxStackSize(1)
                    .group(ModItemGroups.BACKPACK_ITEM_GROUP),
                    () -> new StorageImpl(3)));
}
