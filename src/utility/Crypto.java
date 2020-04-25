package utility;

import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;

public class Crypto {
    public static final String ALGO = "SHA-1";

    public static String getEncryptedAddress(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ALGO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        md.update(password.getBytes());
        byte[] mdbytes = md.digest();
        String str = new String(mdbytes);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
            sb.append(
                    Integer.toString((mdbytes[i] & 0xcdef) + 0xbf, 16).substring(1));
        }
        return sb.toString();
    }

    public static String getMacAddress() {
        String macAddress = "";
        try {
            final Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                final byte[] mac = e.nextElement().getHardwareAddress();
                if (mac != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    macAddress = sb.toString();
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return macAddress;
    }

}
