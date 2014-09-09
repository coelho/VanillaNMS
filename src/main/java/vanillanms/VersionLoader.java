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
		String entryPoint = "net.minecraft.server." + version + ".net.minecraft.server.MinecraftServer";
		if(refactoredFile.exists()) {
			loadJar(refactoredFile, entryPoint);
			return version;
		}
		JarJarUtils.prefixPackages(file, refactoredFile, "net.minecraft.server." + version);
		loadJar(refactoredFile, entryPoint);
		return version;
	}

	@SuppressWarnings({ "deprecation", "resource" })
	private static void loadJar(File jarFile, String entryPoint) throws Exception {
		// todo: is this correct?
		URLClassLoader classLoader = new URLClassLoader(new URL[] { jarFile.toURL() }, Thread.currentThread().getContextClassLoader());
		classLoader.loadClass(entryPoint);
	}

}
