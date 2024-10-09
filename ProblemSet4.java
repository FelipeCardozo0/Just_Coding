/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet4 {
    public static void main(String[] args) {

        System.out.println(encrypt("Secrets secrets secrets", 10));
        System.out.println(decrypt("Wklv lv pv vhfuhw phvvdjh)", 3));
        System.out.println(decrypt("IY 7=6 oy znk hkyz irgyy", 6));
        System.out.println(decrypt("}om|o~} }om|o~} }om|o~}", 10));
        System.out.println(encrypt("This is my secret message", 3));
        System.out.println(encrypt("CS 170 is the best class", 6));


    }

    public static boolean isPalindrome(String text) {
        String reverse = "";
        text = text.toLowerCase();
        text = text.replace(" ", ""); //cant change a string, make new string

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != reverse.charAt(i)) {
                return false;
            }
        }
        return true;
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

            // Shift every character back by the shift value
            char shiftedChar = (char) (ch - shift);

            // Append the shifted character to the result
            decryptedText.append(shiftedChar);
        }

        return decryptedText.toString();
    }

    public static String guess_shift(String text) {
        StringBuilder result = new StringBuilder();

        // Try all shift values from 1 to 26
        for (int shift = 1; shift <= 26; shift++) {
            StringBuilder decryptedText = new StringBuilder();

            // Loop through each character in the text
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);

                // Shift every character back by the current shift value
                char shiftedChar = (char) (ch - shift);

                // Append the shifted character to the result
                decryptedText.append(shiftedChar);
            }

            // Append the shift value and decrypted text to the result
            result.append("Shift ").append(shift).append(": ").append(decryptedText.toString()).append("\n");
        }

        return result.toString();
    }
}
