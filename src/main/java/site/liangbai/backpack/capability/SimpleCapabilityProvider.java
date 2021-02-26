package site.liangbai.backpack.capability;

import com.google.common.collect.ImmutableSet;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import java.util.Set;
import java.util.function.Supplier;

public class SimpleCapabilityProvider<C> implements ICapabilityProvider {

    protected final C capability;
    protected final Set<Supplier<Capability<? super C>>> capabilityHolder;

    public SimpleCapabilityProvider(C capability, Supplier<Capability<? super C>> capabilityHolder) {
        this(capability, ImmutableSet.of(capabilityHolder));
    }

    public SimpleCapabilityProvider(C capability, Set<Supplier<Capability<? super C>>> capabilityHolder) {
        this.capability = capability;
        this.capabilityHolder = capabilityHolder;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap != null ? this.capabilityHolder.stream().map(Supplier::get).anyMatch(cap::equals)
                ? LazyOptional.of(() -> this.capability).cast()
                : LazyOptional.empty() : LazyOptional.empty();
    }
}
