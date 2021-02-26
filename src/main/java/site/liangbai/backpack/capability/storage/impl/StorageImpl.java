package site.liangbai.backpack.capability.storage.impl;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.ItemStackHandler;
import site.liangbai.backpack.capability.storage.IStorage;
import site.liangbai.backpack.inventory.container.GenericContainer;

import javax.annotation.Nonnull;

public final class StorageImpl extends ItemStackHandler implements IStorage {
    private final int row;

    public StorageImpl() {
        this(1);
    }

    public StorageImpl(int row) {
        super(row * 9);
        this.row = row;
    }

    @Override
    public Container createMenu(int windowId, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity playerEntity) {
        return GenericContainer.create(windowId, playerInventory, this, row);
    }
}
