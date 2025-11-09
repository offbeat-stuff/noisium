package io.github.steveplays28.noisium.util;

import net.fabricmc.loader.api.FabricLoader;

public class ModUtil {
  public static boolean isModPresent(String id) {
    return FabricLoader.getInstance().isModLoaded(id);
  }
}
