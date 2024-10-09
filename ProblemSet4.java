/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a mala nada na lama"));

        System.out.println(encrypt("Botafogo", 3));
        System.out.println(decrypt("Erwdirjr", 3));

        System.out.println(encrypt("This is my secret message", 3));
        System.out.println(decrypt("Neze tvskveqqmrk mw ws qygl jyr" , 4));

        System.out.println(decrypt("Wklv lv p| vhfuhw phvvdjh, 3)" , 3));
        System.out.println(decrypt("decrypt(IY 7=6 oy znk hkyz irgyy", 6));
        System.out.println(decrypt("}om|o~} }om|o~} }om|o~}", 10));
        System.out.println(decrypt("CS 170 is the best class", 6));

        System.out.println(decrypt("Neze tvskveqqmrk mw ws qygl jyr", 4));

        guess_shift("T ^_`Od NZX[`_P] ^NTPYNP L_ PXZ]d");

    }

    public static boolean isPalindrome(String text){
        String reverse ="";
        text=text.toLowerCase();
        text =text.replace(" ","");
        for (int i =text.length() - 1; i>= 0; i--){
            reverse += text.charAt(i);
        }

        for (int i = 0; i <text.length(); i++){
            if (text.charAt(i) !=reverse.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static String encrypt(String text, int shift){
        StringBuilder encryptedText = new StringBuilder();

        for (int i =0; i<text.length(); i++){
            char currentChar =text.charAt(i);

            if (Character.isWhitespace(currentChar)){
                encryptedText.append(currentChar);
            } else {
                char shiftedChar=(char) (currentChar +shift);
                encryptedText.append(shiftedChar);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text,int shift){
        StringBuilder decryptedText=new StringBuilder();

        for (int i =0; i<text.length();i++){
            char currentChar = text.charAt(i);

            if (Character.isWhitespace(currentChar)){
                decryptedText.append(currentChar);
            } else {
                char shiftedChar = (char) (currentChar - shift);
                decryptedText.append(shiftedChar);
            }
        }

        return decryptedText.toString();
    }

    public static void guess_shift(String text){
        for (int shift = 1; shift <= 26; shift++){
            StringBuilder decryptedText = new StringBuilder();

            for(int i=0; i<text.length(); i++){
                char currentChar = text.charAt(i);

                if(Character.isWhitespace(currentChar)){
                    decryptedText.append(currentChar);
                }
                else{
                    char shiftedChar=(char)(currentChar -shift);
                    decryptedText.append(shiftedChar);
                }
            }

            System.out.println("shift "+shift+ ": " + decryptedText.toString());
        }
    }
}
