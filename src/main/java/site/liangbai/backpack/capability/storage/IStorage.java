package site.liangbai.backpack.capability.storage;

import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandler;

public interface IStorage extends IContainerProvider, IItemHandler, INBTSerializable<CompoundNBT> {
    default boolean isEmpty() {
        for (int i = 0; i < this.getSlots(); i++) {
            if (!this.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
