package io.github.steveplays28.noisium.mixin;

import io.github.steveplays28.noisium.Noisium;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSupplier;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.PalettedContainer;
import net.minecraft.world.chunk.ReadableContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChunkSection.class)
public class ChunkSectionMixin {
  @Shadow private ReadableContainer<RegistryEntry<Biome>> biomeContainer;

  /**
   * @author Steveplays28
   * @reason Axis order micro-optimisation
   */
  @Overwrite
  public void populateBiomes(
      BiomeSupplier biomeSupplier, MultiNoiseUtil.MultiNoiseSampler sampler, int x, int y, int z) {
    PalettedContainer<RegistryEntry<Biome>> palettedContainer = this.biomeContainer.slice();

    for (int posY = 0; posY < 4; ++posY) {
      for (int posZ = 0; posZ < 4; ++posZ) {
        for (int posX = 0; posX < 4; ++posX) {
          Noisium.fastSet(
              palettedContainer,
              posX,
              posY,
              posZ,
              biomeSupplier.getBiome(x + posX, y + posY, z + posZ, sampler));
        }
      }
    }

    this.biomeContainer = palettedContainer;
  }
}
