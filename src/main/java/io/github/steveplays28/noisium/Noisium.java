package io.github.steveplays28.noisium;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.chunk.PalettedContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Noisium implements ModInitializer {
  public static final String MOD_ID = "noisium";
  public static final String MOD_NAME = "Noisium";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    LOGGER.info("Loading {}.", MOD_NAME);
  }

  public static <T> void fastSet(PalettedContainer<T> container, int x, int y, int z, T value) {
    var val = container.data.palette.index(value, container);
    container.data.storage().set(container.paletteProvider.computeIndex(x, y, z), val);
  }
}
