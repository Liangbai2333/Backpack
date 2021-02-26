package site.liangbai.backpack;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import site.liangbai.backpack.capability.ModCapabilities;
import site.liangbai.backpack.client.ClientDist;
import site.liangbai.backpack.inventory.container.ModContainerTypes;
import site.liangbai.backpack.item.ModItems;
import site.liangbai.backpack.server.ServerDist;

@Mod(Backpack.ID)
public final class Backpack {
    public static final String ID = "backpack";

    /**
     * Mod distribution.
     */
    private final IModDist modDist;

    public Backpack() {
        this.modDist = DistExecutor.safeRunForDist(() -> ClientDist::new, () -> ServerDist::new);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::handleCommonSetup);

        ModItems.ITEMS.register(modEventBus);
        ModContainerTypes.CONTAINERS.register(modEventBus);
    }

    public IModDist getModDist() {
        return modDist;
    }

    // ================================================================================
    // Mod Events
    // ================================================================================
    private void handleCommonSetup(FMLCommonSetupEvent event) {
        ModCapabilities.registerCapabilities();
    }
}
