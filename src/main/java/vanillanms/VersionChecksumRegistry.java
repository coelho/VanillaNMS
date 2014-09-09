package vanillanms;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import vanillanms.util.ChecksumUtils;

public class VersionChecksumRegistry {

	private Map<String, String> checksumToVersion = new HashMap<String, String>();

	public void submit(String version, String checksum) {
		this.checksumToVersion.put(checksum, version);
	}

	public String getVersionByFile(File file) throws Exception {
		String checksum = null;
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			checksum = ChecksumUtils.hex(ChecksumUtils.checksumSha1(inputStream));
		} catch(Exception exception) {
			throw exception;
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch(Exception exception) {
					// ignore
				}
			}
		}
		return this.checksumToVersion.get(checksum);
	}

}
