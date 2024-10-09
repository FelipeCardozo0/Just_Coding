/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a mala nada na lama"));

        System.out.println(encrypt("Botafogo", 3));
        System.out.println(decrypt("Erwdirjr", 3));

        System.out.println(encrypt("This is my secret message", 3));
        System.out.println(decrypt("Wklv lv pb vhfuhw phvvdjh", 3));

        System.out.println(decrypt("Wklv lv p| vhfuhw phvvdjh, 3)", 3));
        System.out.println(decrypt("decrypt(IY 7=6 oy znk hkyz irgyy", 6));
        System.out.println(decrypt("}om|o~} }om|o~} }om|o~}", 10));
        System.out.println(decrypt("CS 170 is the best class", 6));

        System.out.println(decrypt("Neze tvskveqqmrk mw ws qygl jyr", 4));

        System.out.println(guess_shift("T ^_`Od NZX[`_P] ^NTPYNPL_ PXZ]d"));
    }
    public static boolean isPalindrome(String text) {
        String reverse = "";
        text = text.toLowerCase();
        text = text.replace(" ","");
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != reverse.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        // Loop through each character in the text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!Character.isWhitespace(ch)) {
                // Shift alphabetic characters (handling both upper and lower case)
                if (Character.isLetter(ch)) {
                    if (Character.isUpperCase(ch)) {
                        // Wrap around uppercase letters
                        char shiftedChar = (char) ((ch - 'A' + shift) % 26 + 'A');
                        encryptedText.append(shiftedChar);
                    } else {
                        // Wrap around lowercase letters
                        char shiftedChar = (char) ((ch - 'a' + shift) % 26 + 'a');
                        encryptedText.append(shiftedChar);
                    }
                } else if (Character.isDigit(ch)) {
                    // Shift numeric characters (wrap around '0' to '9')
                    char shiftedChar = (char) ((ch - '0' + shift) % 10 + '0');
                    encryptedText.append(shiftedChar);
                } else {
                    // Non-alphabetic, non-numeric characters are added unchanged
                    encryptedText.append(ch);
                }
            } else {
                encryptedText.append(ch); // Retain spaces
            }
        }

        return encryptedText.toString();
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

    public static String guess_shift(String text) {
        StringBuilder result = new StringBuilder();

        // Try all shift values from 1 to 26
        for (int shift = 1; shift <= 26; shift++) {
            StringBuilder decryptedText = new StringBuilder();

            // Loop through each character in the text
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);

                if (!Character.isWhitespace(ch)) {
                    // Shift alphabetic characters
                    if (Character.isLetter(ch)) {
                        if (Character.isUpperCase(ch)) {
                            char shiftedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                            decryptedText.append(shiftedChar);
                        } else {
                            char shiftedChar = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                            decryptedText.append(shiftedChar);
                        }
                    } else if (Character.isDigit(ch)) {
                        // Shift numeric characters
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

            // Append the shift value and decrypted text to the result
            result.append("Shift ").append(shift).append(": ").append(decryptedText.toString()).append("\n");
        }

        return result.toString();
    }
}
