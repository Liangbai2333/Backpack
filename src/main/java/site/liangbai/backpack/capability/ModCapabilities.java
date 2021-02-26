package site.liangbai.backpack.capability;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import site.liangbai.backpack.capability.storage.IStorage;
import site.liangbai.backpack.capability.storage.impl.StorageImpl;

public final class ModCapabilities {
    @CapabilityInject(IStorage.class)
    public static final Capability<IStorage> STORAGE = null;

    public static void registerCapabilities() {
        CapabilityManager.INSTANCE.register(IStorage.class, new EmptyStorage<>(), StorageImpl::new);
    }

    private static class EmptyStorage<C> implements Capability.IStorage<C> {

        @Override
        public INBT writeNBT(Capability<C> capability, C instance, Direction side) {
            return null;
        }

        @Override
        public void readNBT(Capability<C> capability, C instance, Direction side, INBT nbt) {}
    }
}
