package ninja.coelho.vanillanms;

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
		super.submit("v1_1", "3dbadea4e8a0923ac5fde9f4b9e98a244ea2589a");
		super.submit("v1_0", "ecf944fcef1a630f95ded840de0059d4922f81c2");
		super.submit("b1_8_1", "8cdfd85eaebfb1f0c70fd4b2d5301a547e2d4caa");
		super.submit("b1_7_3", "b0dc6c83046f47efed58ad9192884d1b3a103513");
		super.submit("b1_6_6", "e6c5db853f3b019599c24ce3d97b45bb7d8e02bd");
		// todo: missing 1.5.1
		super.submit("b1_4_1", "b6e923a3438711a9a9c438ee6eb996a6f37950ef");
		super.submit("b1_3_1", "505bf204e59294806ca2dec930f01baf04679814");
		super.submit("b1_2_2", "4f2a8d6035dd8bde767b91613cd9ea03c65b465a");
		// todo: missing 1.1.2
		super.submit("b1_0_2", "582fa899199e9eb5d739806db4f4f06655edff3a");
		super.submit("a1_2_6", "4d1a4c2f1513b1c019b8ab1b720b8881caccd0d4");
		super.submit("a1_1_2_1", "007da998189756f77260d68a0f421947c8b17b42");
	}

}
