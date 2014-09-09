package vanillanms;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import vanillanms.util.StringUtils;

public class VanillaNMS extends JavaPlugin {

	@Override
	public void onLoad() {
		super.getDataFolder().mkdirs();
	}

	@Override
	public void onEnable() {
		Set<String> loadedVersions = new TreeSet<String>();
		for(File file : super.getDataFolder().listFiles()) {
			if(file.isDirectory()) {
				continue;
			}
			if(!file.getName().endsWith(".jar")) {
				continue;
			}
			try {
				loadedVersions.add(VersionLoader.load(VersionChecksumRegistryNMS.instance, file));
			} catch(VersionLoaderNotFoundException exception) {
				super.getLogger().warning(exception.getMessage());
			} catch(Exception exception) {
				super.getLogger().log(Level.SEVERE, "Error while loading " + file.getPath(), exception);
			}
		}
		if (!loadedVersions.isEmpty()) {
			super.getLogger().info("Loaded NMS libraries: " + StringUtils.concat(loadedVersions, ", "));
		}
	}

}
