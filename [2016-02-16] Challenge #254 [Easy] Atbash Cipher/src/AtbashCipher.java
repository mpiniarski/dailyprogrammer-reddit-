/**
 * Created by marcin on 28.02.16.
 */
public class AtbashCipher {
    private static final String alphabetSmall = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphabetBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String ciphre(String message) {
        StringBuilder messageSb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currChar = message.charAt(i);
            messageSb.append(getOppositeChar(currChar));
        }
        return messageSb.toString();
    }

    private static char getOppositeChar(char currChar) {
        if (currChar >= 'a' && currChar <= 'z')
            return alphabetSmall.charAt(alphabetSmall.length() - letterIndexInAlphabet(currChar));
        else if (currChar >= 'A' && currChar <= 'Z')
            return alphabetBig.charAt(alphabetBig.length() - letterIndexInAlphabet(currChar));
        else
            return currChar;
    }

    private static int letterIndexInAlphabet(char c) {
        if (c >= 'a' && c <= 'z')
            return alphabetSmall.indexOf(c) + 1;
        else if (c >= 'A' && c <= 'Z')
            return alphabetBig.indexOf(c) + 1;
        else
            return ' ';
    }
}
