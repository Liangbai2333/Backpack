package site.liangbai.backpack.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import site.liangbai.backpack.capability.ModCapabilities;
import site.liangbai.backpack.item.StorageItem;

import javax.annotation.Nonnull;
import java.util.function.BiPredicate;

public final class GenericContainer extends Container {

    private final int rows;

    public GenericContainer(ContainerType<?> containerType, int windowId,
                            PlayerInventory playerInventory, int rows,
                            BiPredicate<PredicateItemHandlerSlot, ItemStack> predicate) {
        this(containerType, windowId, playerInventory, new ItemStackHandler(9 * rows), rows, predicate);
    }

    public GenericContainer(ContainerType<?> containerType, int windowId,
                            PlayerInventory playerInventory, IItemHandler itemHandler, int rows,
                            BiPredicate<PredicateItemHandlerSlot, ItemStack> predicate) {
        super(containerType, windowId);
        assert itemHandler.getSlots() >= rows * 9;
        this.rows = rows;

        int i = (this.rows - 4) * 18;

        // Container inventory
        for (int j = 0; j < this.rows; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new PredicateItemHandlerSlot(itemHandler, k + j * 9, 8 + k * 18, 18 + j * 18,
                                predicate));
            }
        }

        // Player inventory
        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        // Hot bar
        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerEntity) {
        return true;
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(@Nonnull PlayerEntity playerEntity, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < this.rows * 9) {
                if (!this.mergeItemStack(itemstack1, this.rows * 9, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.rows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    public int getRowCount() {
        return this.rows;
    }

    @Nonnull
    public static ContainerType<?> getChestContainerType(int rows) {
        ContainerType<?> type;

        switch (rows) {
            case 2:
                type = ModContainerTypes.GENERIC_9X2.get();
                break;
            case 3:
                type = ModContainerTypes.GENERIC_9X3.get();
                break;
            case 4:
                type = ModContainerTypes.GENERIC_9X4.get();
                break;
            case 5:
                type = ModContainerTypes.GENERIC_9X5.get();
                break;
            case 6:
                type = ModContainerTypes.GENERIC_9X6.get();
                break;
            default:
                type = ModContainerTypes.GENERIC_9X1.get();

                break;
        }

        return type;
    }

    public static GenericContainer create(int windowId, PlayerInventory playerInventory,
                                              IItemHandler itemHandler, int rows) {
        ContainerType<?> type = getChestContainerType(rows);

        return new GenericContainer(type, windowId, playerInventory,
                itemHandler, rows,
                (slot, itemStack) -> !itemStack.getCapability(ModCapabilities.STORAGE).isPresent() && !(itemStack.getItem() instanceof StorageItem));
    }

    public static GenericContainer createGeneric9X1(int windowId, PlayerInventory playerInventory) {
        return new GenericContainer(ModContainerTypes.GENERIC_9X1.get(), windowId, playerInventory, 1,
                (slot, itemStack) -> !itemStack.getCapability(ModCapabilities.STORAGE).isPresent() && !(itemStack.getItem() instanceof StorageItem));
    }

    public static GenericContainer createGeneric9X2(int windowId, PlayerInventory playerInventory) {
        return new GenericContainer(ModContainerTypes.GENERIC_9X2.get(), windowId, playerInventory, 2,
                (slot, itemStack) -> !itemStack.getCapability(ModCapabilities.STORAGE).isPresent() && !(itemStack.getItem() instanceof StorageItem));
    }

    public static GenericContainer createGeneric9X3(int windowId, PlayerInventory playerInventory) {
        return new GenericContainer(ModContainerTypes.GENERIC_9X3.get(), windowId, playerInventory, 3,
                (slot, itemStack) -> !itemStack.getCapability(ModCapabilities.STORAGE).isPresent() && !(itemStack.getItem() instanceof StorageItem));
    }

    public static GenericContainer createGeneric9X4(int windowId, PlayerInventory playerInventory) {
        return new GenericContainer(ModContainerTypes.GENERIC_9X4.get(), windowId, playerInventory, 4,
                (slot, itemStack) -> !itemStack.getCapability(ModCapabilities.STORAGE).isPresent() && !(itemStack.getItem() instanceof StorageItem));
    }

    public static GenericContainer createGeneric9X5(int windowId, PlayerInventory playerInventory) {
        return new GenericContainer(ModContainerTypes.GENERIC_9X5.get(), windowId, playerInventory, 5,
                (slot, itemStack) -> !itemStack.getCapability(ModCapabilities.STORAGE).isPresent() && !(itemStack.getItem() instanceof StorageItem));
    }

    public static GenericContainer createGeneric9X6(int windowId, PlayerInventory playerInventory) {
        return new GenericContainer(ModContainerTypes.GENERIC_9X6.get(), windowId, playerInventory, 6,
                (slot, itemStack) -> !itemStack.getCapability(ModCapabilities.STORAGE).isPresent() && !(itemStack.getItem() instanceof StorageItem));
    }
}
