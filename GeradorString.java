import java.util.*;
import java.nio.charset.*;

public class GeradorString {
    //Fonte: https://www.delftstack.com/pt/howto/java/random-alphanumeric-string-in-java/
    public static String getRandomString(int i) {
        byte[] bytearray;
        String mystring;
        StringBuffer thebuffer;

        bytearray = new byte[256];
        new Random().nextBytes(bytearray);

        mystring = new String(bytearray, Charset.forName("UTF-8"));

        // Create the StringBuffer
        thebuffer = new StringBuffer();

        for (int m = 0; m < mystring.length(); m++) {

            char n = mystring.charAt(m);

            if (((n >= 'A' && n <= 'Z') || (n >= '0' && n <= '9')) && (i > 0)) {
                thebuffer.append(n);
                i--;
            }
        }

        // resulting string
        return thebuffer.toString();
    }
}
