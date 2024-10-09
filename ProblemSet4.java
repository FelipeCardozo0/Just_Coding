/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a mala nada na lama"));


        System.out.println(encrypt("Botafogo", 3));
        System.out.println(decrypt("Erwdirjr", 3)); /////////wrong

        System.out.println(encrypt("This is my secret message", 3));
        System.out.println(decrypt("Neze tvskveqqmrk mw ws qygl jyr" , 4));

        // determine the shift used and decrypt “T ^_`Od NZX[`_P] ^NTPYNPL_ PXZ]d”


    }
    public static boolean isPalindrome(String text) {
        String reverse = "";
        text = text.toLowerCase();
        text = text.replace(" ",""); //cant change a string, make new string

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
            System.out.println(reverse);
        }

        for (int i = 0; i< text.length(); i++) {
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

            // Shift the character by the shift value
            char shiftedChar = (char) (ch + shift);

            // Append the shifted character to the result
            encryptedText.append(shiftedChar);
        }

        // Return the encrypted string
        return encryptedText.toString();
    }
    public static String decrypt(String text, int shift) {
        StringBuilder decryptedText = new StringBuilder();

        // Loop through each character in the text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Shift the character back by the shift value
            char shiftedChar = (char) (ch - shift);

            // Append the shifted character to the result
            decryptedText.append(shiftedChar);
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

                // Shift the character back by the shift value
                char shiftedChar = (char) (ch - shift);

                // Append the shifted character to the result
                decryptedText.append(shiftedChar);
            }

            // Print the shift value and corresponding decrypted text
            System.out.println("Shift " + shift + ": " + decryptedText.toString());
        }
    }

}
