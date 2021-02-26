package site.liangbai.backpack.inventory.container;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.function.BiPredicate;

public final class PredicateItemHandlerSlot extends SlotItemHandler {

    private final BiPredicate<PredicateItemHandlerSlot, ItemStack> predicate;

    public PredicateItemHandlerSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition,
                                    BiPredicate<PredicateItemHandlerSlot, ItemStack> predicate) {
        super(itemHandler, index, xPosition, yPosition);
        this.predicate = predicate;
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack itemStack) {
        return this.predicate.test(this, itemStack);
    }
}

