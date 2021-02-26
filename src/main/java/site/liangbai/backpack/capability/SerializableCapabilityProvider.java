package site.liangbai.backpack.capability;

import net.minecraft.nbt.INBT;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Set;
import java.util.function.Supplier;

public final class SerializableCapabilityProvider<C extends INBTSerializable<S>, S extends INBT>
        extends SimpleCapabilityProvider<C> implements INBTSerializable<S> {

    public SerializableCapabilityProvider(C capability, Supplier<Capability<? super C>> capabilityHolder) {
        super(capability, capabilityHolder);
    }

    public SerializableCapabilityProvider(C capability, Set<Supplier<Capability<? super C>>> capabilityHolder) {
        super(capability, capabilityHolder);
    }

    @Override
    public S serializeNBT() {
        return this.capability.serializeNBT();
    }

    @Override
    public void deserializeNBT(S nbt) {
        this.capability.deserializeNBT(nbt);
    }
}
