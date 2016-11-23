package by.it.artiuschik.project_Testing_system.java.shifr;

/**
 * @author Artischik Elena
 */
public class EncoderDecoder {
    /**
     *
     * @param text text to encode
     * @param keyStr key
     * @return encoded text
     */
    public static byte[] encode(String text, String keyStr) {
        byte[] txt = text.getBytes();
        byte[] key = keyStr.getBytes();
        byte[] res = new byte[text.length()];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }

        return res;
    }

    /**
     *
     * @param text text to decode
     * @param strKey key
     * @return decoded text
     */
    public static String decode(byte[] text, String strKey) {
        byte[] res = new byte[text.length];
        byte[] key = strKey.getBytes();

        for (int i = 0; i < text.length; i++) {
            res[i] = (byte) (text[i] ^ key[i % key.length]);
        }

        return new String(res);
    }


}
