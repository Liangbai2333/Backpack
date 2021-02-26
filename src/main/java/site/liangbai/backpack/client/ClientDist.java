package site.liangbai.backpack.client;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import site.liangbai.backpack.IModDist;
import site.liangbai.backpack.client.gui.screen.GenericContainerScreen;
import site.liangbai.backpack.inventory.container.GenericContainer;
import site.liangbai.backpack.inventory.container.ModContainerTypes;

public final class ClientDist implements IModDist {
    public ClientDist() {
        final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::handleClientSetup);
    }

    private void handleClientSetup(FMLClientSetupEvent event) {
        registerScreenWithGenericContainer(ModContainerTypes.GENERIC_9X1.get());
        registerScreenWithGenericContainer(ModContainerTypes.GENERIC_9X2.get());
        registerScreenWithGenericContainer(ModContainerTypes.GENERIC_9X3.get());
        registerScreenWithGenericContainer(ModContainerTypes.GENERIC_9X4.get());
        registerScreenWithGenericContainer(ModContainerTypes.GENERIC_9X5.get());
        registerScreenWithGenericContainer(ModContainerTypes.GENERIC_9X6.get());
    }

    private void registerScreenWithGenericContainer(ContainerType<GenericContainer> containerType) {
        ScreenManager.registerFactory(containerType, GenericContainerScreen::new);
    }
}
