package io.github.boogiemonster1o1.obsidiplates;

import io.github.boogiemonster1o1.obsidiplates.block.ObsidianPressurePlateBlock;
import io.github.boogiemonster1o1.obsidiplates.block.PressurePlateType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.api.ModInitializer;

@SuppressWarnings("unused")
public class ObsidiplatesInitializer implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger(ObsidiplatesInitializer.class);
	public static final String MOD_ID = "obsidiplates";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Obsidiplates");
	}

	public static final Block OBSIDIAN_PRESSURE_PLATE = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_pressure_plate"), new ObsidianPressurePlateBlock(PressurePlateType.NORMAL));
	public static final Block SILENT_OBSIDIAN_PRESSURE_PLATE = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "silent_obsidian_pressure_plate"), new ObsidianPressurePlateBlock(PressurePlateType.SILENT));
	public static final Block SHROUDED_OBSIDIAN_PRESSURE_PLATE = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "shrouded_obsidian_pressure_plate"), new ObsidianPressurePlateBlock(PressurePlateType.NORMAL));
	public static final Block SILENT_SHROUDED_OBSIDIAN_PRESSURE_PLATE = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "silent_shrouded_obsidian_pressure_plate"), new ObsidianPressurePlateBlock(PressurePlateType.SILENT));

	public static final Item OBSIDIAN_PRESSURE_PLATE_ITEM = Registry.register(Registry.ITEM,new Identifier(MOD_ID, "obsidian_pressure_plate"), new BlockItem(OBSIDIAN_PRESSURE_PLATE, new Item.Settings().group(ItemGroup.REDSTONE)));
	public static final Item SILENT_OBSIDIAN_PRESSURE_PLATE_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "silent_obsidian_pressure_plate"), new BlockItem(SILENT_OBSIDIAN_PRESSURE_PLATE, new Item.Settings().group(ItemGroup.REDSTONE)));
	public static final Item SHROUDED_OBSIDIAN_PRESSURE_PLATE_ITEM = Registry.register(Registry.ITEM,new Identifier(MOD_ID, "shrouded_obsidian_pressure_plate"), new BlockItem(SHROUDED_OBSIDIAN_PRESSURE_PLATE, new Item.Settings().group(ItemGroup.REDSTONE)));
	public static final Item SILENT_SHROUDED_OBSIDIAN_PRESSURE_PLATE_ITEM = Registry.register(Registry.ITEM,new Identifier(MOD_ID, "silent_shrouded_obsidian_pressure_plate"), new BlockItem(SILENT_SHROUDED_OBSIDIAN_PRESSURE_PLATE, new Item.Settings().group(ItemGroup.REDSTONE)));
}
