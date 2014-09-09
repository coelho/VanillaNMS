package vanillanms;

public class VersionChecksumRegistryNMS extends VersionChecksumRegistry {

	public static final VersionChecksumRegistry instance = new VersionChecksumRegistryNMS();

	private VersionChecksumRegistryNMS() {
		super.submit("v1_8", "a028f00e678ee5c6aef0e29656dca091b5df11c7");
		super.submit("v1_7_10", "952438ac4e01b4d115c5fc38f891710c4941df29");
		super.submit("v1_6_4", "050f93c1f3fe9e2052398f7bd6aca10c63d64a87");
		super.submit("v1_5_2", "f9ae3f651319151ce99a0bfad6b34fa16eb6775f");
		super.submit("v1_4_7", "2f0ec8efddd2f2c674c77be9ddb370b727dec676");
		super.submit("v1_3_2", "3de2ae6c488135596e073a9589842800c9f53bfe");
		super.submit("v1_2_5", "d8321edc9470e56b8ad5c67bbd16beba25843336");
	}

}
