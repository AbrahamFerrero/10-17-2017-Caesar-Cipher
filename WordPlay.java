
/**
 * You will write a program to transform words from a file into another form, such as replacing vowels with an asterix..
 * 
 * @author (Abraham Ferrero) 
 * @version (16/10/2017)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        //This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. 
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < vowels.length(); i++){
            if (vowels.charAt(i)== ch){
                return true;
            }
        }
        return false;
    }
    
    public void testIsVowel(){
        char cap = 'e';
        System.out.println(isVowel(cap) + ", " + cap + " is a vowel");
        
        cap = 'f';
        System.out.println(isVowel(cap) + ", " + cap + " is not a vowel");
        
        cap = 'U';
        System.out.println(isVowel(cap) + ", " + cap + " is a vowel");
    }
    
    //This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch:
    public String replaceVowels(String phrase, char ch){
        //We will create a new String from our given phrase (Hello World) by using a StringBuilder:
        StringBuilder finalPhrase = new StringBuilder(phrase);
        //For each character in our phrase, check if there is any vowel:
        for (int i = 0; i < finalPhrase.length(); i++){
            char vowelTestChar = finalPhrase.charAt(i);
            //If there is a vowel, replace it with the character 'ch' given in the test method
            if (isVowel(vowelTestChar) == true){
                vowelTestChar = ch;
                finalPhrase.setCharAt(i, vowelTestChar);
            }
        }
        //return our brand new StringBuilder converting it to a String:
        return finalPhrase.toString();
    }
    
    public void testReplaceVowels(){
        String hey = "Hello World";
        char aznable = '*';
        //Expected result: "H*ll* W*rld"
        System.out.println(replaceVowels(hey, aznable));
        //Success!
    }
    
    /*This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
     * '*' if it is in an odd number location in the string or '+'  if it is in an even number location in the string:
     */
    public String emphasize(String phrase, char ch){
        /*int lol = 6;
        lol = lol % 2;
        System.out.println(lol);*/
        //We want to construct a new phrase fom the string given in our testEmphasize class:
        StringBuilder finalPhrase = new StringBuilder(phrase);
        //For each letter in our phrase, we will iterate our function:
        int count = -1; 
        String finalString = "";
        for (int i = 0; i < finalPhrase.length(); i++){
            count = count + 1;
            //Iterate through every letter in the phrase.
            char vowelTestChar = finalPhrase.charAt(i);
            //Convert our Stringbuilder into a String so we can manipulate it. 
            finalString = finalPhrase.toString();
            //(works)
            //Get the number of the letter we are iterating through to see if it is odd.
            int currentIndex = finalString.indexOf(vowelTestChar);
            //if currentIndex has the same letter, restarts the count. For this not to happen, I make an independent count:
            if (currentIndex < count){
                currentIndex = count;
            }
            //if the character is even and has an a or an A, change it for a '+' character.
            if (currentIndex % 2 != 0 && (vowelTestChar == ch || vowelTestChar == Character.toUpperCase(ch))){
                vowelTestChar = '+';
                finalPhrase.setCharAt(i, vowelTestChar);
                //for some reason it does not loop the last character, so we include another method for it:
                finalPhrase.setCharAt((finalString.length()-1),vowelTestChar);
            }
            //if it is odd, swap it with a '*' character.
            if (currentIndex % 2 == 0 && (vowelTestChar == ch || vowelTestChar == Character.toUpperCase(ch))){
                vowelTestChar = '*';
                finalPhrase.setCharAt(i, vowelTestChar);
                finalPhrase.setCharAt((finalString.length()-1),vowelTestChar);
            }
        }
        return finalString;
    }
    
    public void testEmphasize(){
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
    }
    
}
