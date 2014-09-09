package vanillanms;

public class VersionChecksumRegistryNMS extends VersionChecksumRegistry {

	public static final VersionChecksumRegistry instance = new VersionChecksumRegistryNMS();

	private VersionChecksumRegistryNMS() {
		super.submit("v17", "a028f00e678ee5c6aef0e29656dca091b5df11c7");
	}

}
