package site.liangbai.backpack.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public final class SimpleNamedContainerProvider implements INamedContainerProvider {
    private final Supplier<? extends IContainerProvider> supplier;

    private final ITextComponent displayName;

    public SimpleNamedContainerProvider(Supplier<? extends IContainerProvider> supplier, ITextComponent displayName) {
        this.supplier = supplier;
        this.displayName = displayName;
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return displayName;
    }

    @Nullable
    @Override
    public Container createMenu(int windowId, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity playerEntity) {
        return supplier.get().createMenu(windowId, playerInventory, playerEntity);
    }
}
