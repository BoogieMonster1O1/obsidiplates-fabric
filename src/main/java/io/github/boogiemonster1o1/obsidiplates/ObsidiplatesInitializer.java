package io.github.boogiemonster1o1.obsidiplates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class ObsidiplatesInitializer implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger(ObsidiplatesInitializer.class);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Obsidiplates");
	}
}
