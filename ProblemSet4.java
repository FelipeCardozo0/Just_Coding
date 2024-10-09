/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a mala nada na lama"));

        System.out.println(encrypt("Botafogo", 3));
        System.out.println(decrypt("Erwdirjr", 3));

        System.out.println(encrypt("This is my secret message", 3));
        System.out.println(decrypt("Wklv lv pb vhfuhw phvvdjh" , 3));

        System.out.println(decrypt("Wklv lv p| vhfuhw phvvdjh, 3)" , 3));
        System.out.println(decrypt("decrypt(IY 7=6 oy znk hkyz irgyy", 6));
        System.out.println(decrypt("}om|o~} }om|o~} }om|o~}", 10));
        System.out.println(decrypt("CS 170 is the best class", 6));

        System.out.println(decrypt("Neze tvskveqqmrk mw ws qygl jyr", 4));

        System.out.println(guess_shift("T ^_`Od NZX[`_P] ^NTPYNPL_ PXZ]d"));
        System.out.println(decrypt("T ^_`Od NZX[`_P] ^NTPYNPL_ PXZ]d", 4));

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

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!Character.isWhitespace(ch)) {
                if (Character.isLetter(ch)) {
                    if (Character.isUpperCase(ch)) {
                        char shiftedChar = (char) ((ch - 'A' + shift) % 26 + 'A');
                        encryptedText.append(shiftedChar);



                    } else {

                        char shiftedChar = (char) ((ch - 'a' + shift) % 26 + 'a');
                        encryptedText.append(shiftedChar);
                    }
                } else {
                    encryptedText.append(ch);
                }
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!Character.isWhitespace(ch)) {
                if (Character.isLetter(ch)) {
                    if (Character.isUpperCase(ch)) {

                        char shiftedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                        decryptedText.append(shiftedChar);
                    } else {
                        char shiftedChar = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                        decryptedText.append(shiftedChar);
                    }
                } else {
                    decryptedText.append(ch);
                }
            } else {
                decryptedText.append(ch);             }
        }

        return decryptedText.toString();
    }

    public static String guess_shift(String text) {
        StringBuilder result = new StringBuilder();

        for (int shift = 1; shift <= 26; shift++) {
            StringBuilder decryptedText = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);

                if (!Character.isWhitespace(ch)) {
                    if (Character.isLetter(ch)) {
                        if (Character.isUpperCase(ch)) {
                            char shiftedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                            decryptedText.append(shiftedChar);
                        } else {
                            char shiftedChar = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                            decryptedText.append(shiftedChar);
                        }
                    } else {
                        decryptedText.append(ch);
                    }
                } else {
                    decryptedText.append(ch);
                }
            }
            result.append("Shift ").append(shift).append(": ").append(decryptedText.toString()).append("\n");
        }

        return result.toString();
    }

}
