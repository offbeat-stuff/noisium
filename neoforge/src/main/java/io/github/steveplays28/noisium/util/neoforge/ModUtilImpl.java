package io.github.steveplays28.noisium.util.neoforge;

import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.LoadingModList;

/**
 * Implements {@link io.github.steveplays28.noisium.util.ModUtil}.
 */
@SuppressWarnings("unused")
public class ModUtilImpl {
	/**
	 * Checks if a mod is present during loading.
	 */
	public static boolean isModPresent(String id) {
		return FMLLoader.getCurrent().getLoadingModList().getModFileById(id) != null;
	}
}
