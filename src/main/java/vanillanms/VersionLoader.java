package vanillanms;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import vanillanms.util.JarJarUtils;

public class VersionLoader {

	public static String load(VersionChecksumRegistry registry, File file) throws Exception {
		String version = registry.getVersionByFile(file);
		if(version == null) {
			throw new VersionLoaderNotFoundException(file);
		}
		File refactoredFile = new File(file.getAbsolutePath() + ".refactored");
		String versionPackaged = "net.minecraft.server." + version;
		String entryPoint = "net.minecraft.server.MinecraftServer";
		if(refactoredFile.exists()) {
			loadJar(refactoredFile, entryPoint);
			return version;
		}
		JarJarUtils.prefixPackages(file, refactoredFile, "net.minecraft.server." + version);
		loadJar(refactoredFile, versionPackaged + entryPoint, entryPoint);
		return version;
	}

	@SuppressWarnings({ "deprecation", "resource" })
	private static void loadJar(File jarFile, String... entryPoints) throws Exception {
		// todo: is this correct?
		URLClassLoader classLoader = new URLClassLoader(new URL[] { jarFile.toURL() }, Thread.currentThread().getContextClassLoader());
		for(int i = 0; i < entryPoints.length; i++) {
			try {
				classLoader.loadClass(entryPoints[i]);
			} catch(Exception exception) {
				if (i == (entryPoints.length - 1)) {
					throw exception;
				}
			}
		}
	}

}
