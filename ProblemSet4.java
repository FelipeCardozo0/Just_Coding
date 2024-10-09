/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet4 {
    public static void main(String[] args) {

        System.out.println(encrypt("Secrets secrets secrets", 10));
        System.out.println(decrypt("Wklv lv pb vhfuhw phvvdjh" , 3));
        System.out.println(decrypt("IY 7=6 oy znk hkyz irgyy", 6));
        System.out.println(decrypt("}om|o~} }om|o~} }om|o~}", 10));
        System.out.println(encrypt("This is my secret message", 3));
        System.out.println(encrypt("CS 170 is the best class", 6));
    }

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedtext = new StringBuilder();

        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (Character.isLetter (c))
            {
                c = (char) ((c - 'a' + shift +26) % 26 + 'a');
            }
            encryptedtext.append(c);
        }
        
        return encryptedtext.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder decryptedText = new StringBuilder();

        // Loop through each character in the text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!Character.isWhitespace(ch)) {
                // Shift alphabetic characters (handling both upper and lower case)
                if (Character.isLetter(ch)) {
                    if (Character.isUpperCase(ch)) {
                        // Wrap around uppercase letters
                        char shiftedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                        decryptedText.append(shiftedChar);
                    } else {
                        // Wrap around lowercase letters
                        char shiftedChar = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                        decryptedText.append(shiftedChar);
                    }
                } else if (Character.isDigit(ch)) {
                    // Shift numeric characters (wrap around '0' to '9')
                    char shiftedChar = (char) ((ch - '0' - shift + 10) % 10 + '0');
                    decryptedText.append(shiftedChar);
                } else {
                    // Non-alphabetic, non-numeric characters are added unchanged
                    decryptedText.append(ch);
                }
            } else {
                decryptedText.append(ch); // Retain spaces
            }
        }

        return decryptedText.toString();
    }
}
