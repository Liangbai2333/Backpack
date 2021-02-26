package site.liangbai.backpack.inventory.container;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import site.liangbai.backpack.Backpack;

public final class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, Backpack.ID);

    public static final RegistryObject<ContainerType<GenericContainer>> GENERIC_9X1 =
            register("generic_9x1", GenericContainer::createGeneric9X1);

    public static final RegistryObject<ContainerType<GenericContainer>> GENERIC_9X2 =
            register("generic_9x2", GenericContainer::createGeneric9X2);

    public static final RegistryObject<ContainerType<GenericContainer>> GENERIC_9X3 =
            register("generic_9x3", GenericContainer::createGeneric9X3);

    public static final RegistryObject<ContainerType<GenericContainer>> GENERIC_9X4 =
            register("generic_9x4", GenericContainer::createGeneric9X4);

    public static final RegistryObject<ContainerType<GenericContainer>> GENERIC_9X5 =
            register("generic_9x5", GenericContainer::createGeneric9X5);

    public static final RegistryObject<ContainerType<GenericContainer>> GENERIC_9X6 =
            register("generic_9x6", GenericContainer::createGeneric9X6);

    private static <T extends Container> RegistryObject<ContainerType<T>> register(String name, ContainerType.IFactory<T> iFactory) {
        return CONTAINERS.register(name, () -> new ContainerType<>(iFactory));
    }
}
