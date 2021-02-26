package site.liangbai.backpack.item;

import com.google.common.collect.ImmutableSet;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.CapabilityItemHandler;
import site.liangbai.backpack.capability.ModCapabilities;
import site.liangbai.backpack.capability.SerializableCapabilityProvider;
import site.liangbai.backpack.capability.storage.IStorage;
import site.liangbai.backpack.inventory.container.SimpleNamedContainerProvider;
import site.liangbai.backpack.util.Text;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class StorageItem extends Item {

    public static final int MAX_SLOTS_TO_SHOW = 6;

    private final Supplier<IStorage> storageContainer;

    public StorageItem(Properties properties, Supplier<IStorage> storageContainer) {
        super(properties);

        this.storageContainer = storageContainer;
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return new SerializableCapabilityProvider<>(this.storageContainer.get(), ImmutableSet
                .of(() -> ModCapabilities.STORAGE, () -> CapabilityItemHandler.ITEM_HANDLER_CAPABILITY));
    }

    @Override
    public void addInformation(@Nonnull ItemStack itemStack, @Nullable World worldIn, @Nonnull List<ITextComponent> lines, @Nonnull ITooltipFlag tooltipFlag) {
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        itemStack.getCapability(ModCapabilities.STORAGE).ifPresent(storage -> {
            if (!storage.isEmpty()) {
                lines.add(Text.of(" "));
                lines.add(Text.translate("container.inventory")
                        .mergeStyle(TextFormatting.RED, TextFormatting.BOLD));

                int rowsBeyondLimit = 0;

                for (int i = 0; i < storage.getSlots(); i++) {
                    ItemStack stack = storage.getStackInSlot(i);
                    if (!stack.isEmpty()) {
                        if (i >= MAX_SLOTS_TO_SHOW) {
                            ++rowsBeyondLimit;
                        } else {
                            IFormattableTextComponent amountText =
                                    Text.of(stack.getCount() + "x ").mergeStyle(TextFormatting.DARK_GRAY);
                            ITextComponent itemText =
                                    stack.getDisplayName().copyRaw().mergeStyle(TextFormatting.GRAY);
                            lines.add(amountText.append(itemText));
                        }
                    }
                }

                if (rowsBeyondLimit > 0) {
                    lines.add(Text.of(". . . +" + rowsBeyondLimit).mergeStyle(TextFormatting.RED));
                }
            }
        });
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull PlayerEntity playerEntityIn, @Nonnull Hand handIn) {
        ItemStack itemStack = playerEntityIn.getHeldItem(handIn);

        itemStack.getCapability(ModCapabilities.STORAGE).ifPresent(storage -> playerEntityIn.openContainer(
                new SimpleNamedContainerProvider(() -> storage, itemStack.getDisplayName())));

        return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
    }

    @Override
    public CompoundNBT getShareTag(ItemStack stack) {
        CompoundNBT shareTag = stack.getTag();

        if (shareTag == null) {
            shareTag = new CompoundNBT();
        }

        CompoundNBT storageTag = stack.getCapability(ModCapabilities.STORAGE)
                .map(IStorage::serializeNBT)
                .orElse(null);

        if (storageTag != null && !storageTag.isEmpty()) {
            shareTag.put("storage", storageTag);
        }

        return shareTag;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        if (nbt != null && nbt.contains("storage", Constants.NBT.TAG_COMPOUND)) {
            stack.getCapability(ModCapabilities.STORAGE)
                    .ifPresent(storage -> storage.deserializeNBT(nbt.getCompound("storage")));
        }

        super.readShareTag(stack, nbt);
    }
}
