package ninja.coelho.vanillanms.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.tonicsystems.jarjar.Main;

public class JarJarUtils {

	public static void prefixPackages(File in, File out, String packagePrefix) throws Exception {
		File rules = new File(in.getAbsoluteFile() + ".rules.tmp");
		rules.createNewFile();
		try {
			BufferedWriter rulesWriter = null;
			ZipFile zipFile = null;
			try {
				rulesWriter = new BufferedWriter(new FileWriter(rules));
				zipFile = new ZipFile(in);
				Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
				ZipEntry zipEntry;
				String name;
				while (zipEntries.hasMoreElements()) {
					zipEntry = zipEntries.nextElement();
					name = zipEntry.getName();
					if (name.contains("META-INF")) {
						continue;
					}
					if (zipEntry.isDirectory()) {
						rulesWriter.append("rule " + name.replace('/', '.') + "* " + packagePrefix + ".@0\r\n");
						continue;
					}
					if (name.contains("/")) {
						continue;
					}
					if (!name.endsWith(".class")) {
						continue;
					}
					rulesWriter.append("rule " + name.replace(".class", "") + " " + packagePrefix + ".@0\r\n");
				}
				rulesWriter.flush();
			} catch (Exception exception) {
				throw exception;
			} finally {
				if (rulesWriter != null) {
					try {
						rulesWriter.close();
					} catch (Exception exception) {
						// ignore
					}
				}
				if (zipFile != null) {
					try {
						zipFile.close();
					} catch (Exception exception) {
						// ignore
					}
				}
			}
			String command = ("process " + rules.getPath() + " " + in.getPath() + " " + out.getPath());
			Main.main(command.split(" "));
			ZipUtils.deletePrefix(out, "META-INF");
		} finally {
			rules.delete();
		}
	}

}
