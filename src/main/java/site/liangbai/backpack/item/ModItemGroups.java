package site.liangbai.backpack.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public final class ModItemGroups {
    public static final ItemGroup BACKPACK_ITEM_GROUP = new ItemGroup("backpack_backpack") {
        @Override
        public ItemStack createIcon() {
            return ModItems.LARGE_TAN_BACKPACK.get().getDefaultInstance();
        }
    };
}
