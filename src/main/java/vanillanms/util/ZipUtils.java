package vanillanms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

	public static void deletePrefix(File file, String prefix) throws Exception {
		File tempFile = File.createTempFile(file.getName(), ".tmp");
		tempFile.delete();
		tempFile.deleteOnExit();
		file.renameTo(tempFile);

		byte[] buffer = new byte[1024];
		ZipInputStream zipInputStream = null;
		ZipOutputStream zipOutputStream = null;
		ZipEntry entry = null;
		try {
			zipInputStream = new ZipInputStream(new FileInputStream(tempFile));
			zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
			while ((entry = zipInputStream.getNextEntry()) != null) {
				String name = entry.getName();
				if (name.startsWith(prefix)) {
					continue;
				}
				zipOutputStream.putNextEntry(new ZipEntry(name));
				int n;
				while ((n = zipInputStream.read(buffer)) > 0) {
					zipOutputStream.write(buffer, 0, n);
				}
			}
		} catch(Exception exception) {
			exception.printStackTrace();
		} finally {
			if (zipInputStream != null) {
				try {
					zipInputStream.close();
				} catch(Exception exception) {
					// ignore
				}
			}
			if (zipOutputStream != null) {
				try {
					zipOutputStream.close();
				} catch(Exception exception) {
					// ignore
				}
			}
			tempFile.delete();
		}
	}

}
