package ninja.coelho.vanillanms.util;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class ChecksumUtils {

	public static byte[] checksumSha1(InputStream inputStream) throws Exception {
		return checksum(inputStream, MessageDigest.getInstance("SHA1"));
	}
	
	public static byte[] checksum(InputStream inputStream, MessageDigest messageDigest) throws Exception {
		byte[] buffer = new byte[1024];
		int n;
		while((n = inputStream.read(buffer)) != -1) {
			messageDigest.update(buffer, 0, n);
		}
		return messageDigest.digest();
	}
	
	public static String hex(byte[] hash) {
		String hex = new BigInteger(1, hash).toString(16);
		while (hex.length() < 40) {
			hex = "0" + hex;
		}
		return hex.toLowerCase();
	}
	
}
