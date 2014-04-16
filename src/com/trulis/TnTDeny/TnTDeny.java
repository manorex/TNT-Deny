package com.trulis.TnTDeny;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TnTDeny extends JavaPlugin{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public static TnTDeny plugin;
	public final TrulisBlockListener bl = new TrulisBlockListener();
	
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " by " + pdfFile.getAuthors() + " Has Been Disabled!");
	}

	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " by " + pdfFile.getAuthors() + " Has Been Enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.bl, this);
		
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
	}

}
