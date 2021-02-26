package site.liangbai.backpack.util;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;

public final class Text {

    public static TranslationTextComponent translate(String key, Object... objects) {
        return new TranslationTextComponent(key, objects);
    }

    public static StringTextComponent of(@Nonnull Object object) {
        return new StringTextComponent(object.toString());
    }
}
