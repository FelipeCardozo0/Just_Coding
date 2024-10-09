/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a mala nada na lama"));

        System.out.println(encrypt("Botafogo", 3));
        System.out.println(decrypt("Erwdirjr", 3));

        System.out.println(encrypt("This is my secret message", 3));
        System.out.println(decrypt("Wklv lv pb vhfuhw phvvdjh" , 3)); // fixed shift

        // Determine the shift used and decrypt
        guess_shift("T ^_`Od NZX[`_P] ^NTPYNPL_ PXZ]d");
    }

    public static boolean isPalindrome(String text) {
        String reverse = "";
        text = text.toLowerCase();
        text = text.replace(" ",""); //cant change a string, make new string

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
                // Only shift alphabetic characters (handling both upper and lower case)
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
                } else {
                    // Non-alphabetic characters are added unchanged
                    encryptedText.append(ch);
                }
            } else {
                encryptedText.append(ch); // Retain spaces
            }
        }

        // Return the encrypted string
        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder decryptedText = new StringBuilder();

        // Loop through each character in the text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!Character.isWhitespace(ch)) {
                // Only shift alphabetic characters (handling both upper and lower case)
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
                } else {
                    // Non-alphabetic characters are added unchanged
                    decryptedText.append(ch);
                }
            } else {
                decryptedText.append(ch); // Retain spaces
            }
        }

        // Return the decrypted string
        return decryptedText.toString();
    }

    public static void guess_shift(String text) {
        // Try all shift values from 1 to 26
        for (int shift = 1; shift <= 26; shift++) {
            StringBuilder decryptedText = new StringBuilder();

            // Loop through each character in the text
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);

                if (!Character.isWhitespace(ch)) {
                    // Only shift alphabetic characters
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
                    } else {
                        // Non-alphabetic characters are added unchanged
                        decryptedText.append(ch);
                    }
                } else {
                    decryptedText.append(ch); // Retain spaces
                }
            }

            // Print the shift value and corresponding decrypted text
            System.out.println("Shift " + shift + ": " + decryptedText.toString());
        }
    }
}
