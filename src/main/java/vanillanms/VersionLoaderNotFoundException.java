package vanillanms;

import java.io.File;

public class VersionLoaderNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private File file;

	public VersionLoaderNotFoundException(File file) {
		this.file = file;
	}

	@Override
	public String getMessage() {
		return file.getName() + " not found in the checksum registry";
	}

}
