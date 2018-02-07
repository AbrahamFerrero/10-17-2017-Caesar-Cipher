import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
/**
 * You will start with the Caesar Cipher algorithm you learned about in the videos, and you will make some enhancements to it,
 * so that it works with all letters (both uppercase and lowercase) and to make it a little bit harder to decrypt. 
 * Write these methods in a CaesarCipher class you can use in the next lesson.
 * 
 * @author (Abraham Ferrero) 
 * @version (17/OCT/2017)
 */
public class CaesarCipher {
    /*Write the method encrypt that has two parameters, a String named input and an int named key. 
     * This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos. 
     * Assume that all the alphabetic characters are uppercase letters. For example, the call
     * encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23) should return the string “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
     */
    public String encrypt (String input, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower = shiftedAlphabet.toLowerCase();
        for (int i=0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                    c = shiftLower.charAt(idxLower);
                    sb.setCharAt(i, c);
                }
            }
            else{
                if (idx != -1){
                    c = shiftedAlphabet.charAt(idx);
                    sb.setCharAt(i, c);
                }
            }
        }
        return sb.toString();
    }
    
    public void testEncrypt(){
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 16));
        System.out.println(encrypt("FIRST Legion", 23));
        System.out.println(encrypt("First Legion", 17));
    }
    
    //Method to decrypt a message in a file:
    public void testCaesarMethod(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        //you will have to specify what key to use and modify int key:
        int key = 0;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    
}
