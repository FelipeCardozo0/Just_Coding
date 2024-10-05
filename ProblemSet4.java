/* This code is my own work. It was written without consulting code written by
other students or code from online resources. Felipe Cardozo */

public class ProblemSet4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("dad"));
        System.out.println(isPalindrome("a mala nada na lama"));
        System.out.println(isPalindrome("9910101010199"));
        System.out.println(isPalindrome("9910101010199"));  // Shouldnt work fix that
        System.out.println(isPalindrome("990101099"));
        System.out.println(isPalindrome("botafogo"));


        System.out.println(encrypt);
/*
        System.out.println(decrypt);

        System.out.println(guess_shift);

         */

    }
    // if A differ from a and should write code to fix tha, eg Dad != dad
    public static boolean isPalindrome(String text) {
        String reverse = "";
        text = text.toLowerCase();
        text = text.replace(" ",""); //cant change a string, make new string

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
            System.out.print(reverse);
        }
        System.out.println();

        for (int i = 0; i< text.length(); i++) {
            if (text.charAt(i) != reverse.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public encrypt(String text, int shift){
/*
    }
    public decrypt(String text, int shift){

    }
    public guess_shift(String text){

    }


 */
}
