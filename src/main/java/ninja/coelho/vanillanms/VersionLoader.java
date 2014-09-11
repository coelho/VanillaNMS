package ninja.coelho.vanillanms;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import ninja.coelho.vanillanms.util.JarJarUtils;

public class VersionLoader {

	public static String load(VersionChecksumRegistry registry, File file) throws Exception {
		String version = registry.getVersionByFile(file);
		if(version == null) {
			throw new VersionLoaderNotFoundException(file);
		}
		File refactoredFile = new File(file.getAbsolutePath() + ".refactored");
		if(refactoredFile.exists()) {
			loadJar(refactoredFile);
			return version;
		}
		JarJarUtils.prefixPackages(file, refactoredFile, "net.minecraft.server." + version);
		loadJar(refactoredFile);
		return version;
	}

	@SuppressWarnings({ "deprecation" })
	private static void loadJar(File jarFile) throws Exception {
		// todo: this seems hackish
		URLClassLoader systemLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Method addURLMethod = URLClassLoader.class.getDeclaredMethod("addURL", new Class<?>[] { URL.class });
		addURLMethod.setAccessible(true);
		addURLMethod.invoke(systemLoader, new Object[] { jarFile.toURL() });
	}

}
