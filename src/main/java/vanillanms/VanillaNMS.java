package vanillanms;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class VanillaNMS extends JavaPlugin {

	@Override
	public void onLoad() {
		super.getDataFolder().mkdirs();
	}

	@Override
	public void onEnable() {
		for(File file : super.getDataFolder().listFiles()) {
			if(file.isDirectory()) {
				continue;
			}
			if(!file.getName().endsWith(".jar")) {
				continue;
			}
			try {
				String version = VersionLoader.load(VersionChecksumRegistryNMS.instance, file);
				super.getLogger().info("Loaded NMS: " + version);
			} catch(VersionLoaderNotFoundException exception) {
				super.getLogger().warning(exception.getMessage());
			} catch(Exception exception) {
				super.getLogger().log(Level.SEVERE, "", exception);
			}
		}
	}

}
