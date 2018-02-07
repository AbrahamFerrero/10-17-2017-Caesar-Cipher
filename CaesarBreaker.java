import edu.duke.*;

/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker 
{
   int[] countLetters(String message) {
       //This method counts the number of occurences of every letter of the alphabet in a given sentence "message" 
       String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i=0; i < message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        //funciona
        return counts;
    }
    
   public int maxIndex(int[] vals){
        /*This method takes the number that each caracter occurs (freqs),compares them and returns the 
         * int which is the number of the character (the index of the character) most repeated. 
         */
        int maxDex = 0;
        for(int i=0; i < vals.length; i++){
            if (vals[i] > vals[maxDex]){
                maxDex = i;
            }
        }
        //funciona--------
        return maxDex;
     }
    
   public String decrypt(String encrypted, int key){
       //This method will return the code as it is if 'e' is the most used letter and it will encrypt it with e otherwise.
       CaesarCipher cc = new CaesarCipher();
       System.out.println("Encrypted = " + encrypted);
        //We call the method to count the occurrences of every letter in a sentence "encrypted"
        int[] freqs = countLetters(encrypted);
        //We take those encrypted counted chars and we get the index of the most repeated letter
        int maxDex = maxIndex(freqs);
        //We compare the index of the biggest value from 'e'
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted,26-dkey);
    }
    
   public void testDecrypt(){
        String message = "Qj deed ru yd jxu sedvuhudsu heec myjx oekh xqj ed veh q ikhfhyiu fqhjo. OUBB BEKT!";
        System.out.println(decrypt(message, 25));
         message = "oscar es un mierda asgalla";
        System.out.println(decrypt(message, 13));
       message = "me mete el pene de repente";
        System.out.println(decrypt(message, 6));
        message = "ma mata al pana da rapanta";
        System.out.println(decrypt(message, 7));
         message = "ma mata al pana da rapanta";
        System.out.println(decrypt(message, 17));
        message = "mo moto ol pono dorroponto";
    }
    
   public String halfOfString(String message, int start){
       StringBuilder newMessage = new StringBuilder();
       char validChar = ' ';
       for (int i=0; i < message.length(); i++){
           if (start % 2 == 0 && i%2 == 0){
               validChar = message.charAt(i);
               newMessage.append(validChar);
            }
           if (start % 2 != 0 && i%2 != 0){
               validChar = message.charAt(i);
               newMessage.append(validChar);
            }
        }
        String finalMessage = newMessage.toString();
       return newMessage.toString();
    }
   
   public void testhalfOfString(){
       String message = "Qbkm Zgis";
       int start = 1;
       String execute = halfOfString(message, start);
       System.out.println(execute);
       //it works perfectly
    }
    
   public String getKey(String s){
       String alph ="abcdefghijklmnopqrstuvwxyz";
       int[] freqs = countLetters(s);
       int max = 0;
       for(int i=0; i < freqs.length; i++){
            if (freqs[i] > freqs[max]){
                max = i;
            }
        }
       String maxToLetter = alph.substring(max, max+1);
       return maxToLetter;
    }
   
   public void testGetKey(){
        String toTest = "me cueste el tener de repente";
        String done = getKey(toTest);
        System.out.println(done);
   }
   
   public String decryptTwoKeys(String encrypted){
       String firstHalf = halfOfString(encrypted,0);
       String secondHalf = halfOfString(encrypted,1);
       //ok 
       String decrypt1 = decrypt(firstHalf,2);
       String decrypt2 = decrypt(secondHalf,20);
       String key1 = getKey(decrypt1);
       String key2 = getKey(decrypt2);
       System.out.println("decrypt1: " + decrypt1 + " and the key is: " + key1);
       System.out.println("decrypt2: " + decrypt2 + " and the key is: " + key2);
       StringBuilder sb = new StringBuilder();
       int a = 0;
       int b = 0;
       for (int i=0; i < decrypt1.length()+decrypt2.length(); i++){
           //If the char is at even position:
           if (i % 2 == 0){
                sb = sb.append(decrypt1.charAt(a));
                a = a+ 1;
                //System.out.println("a = " + a);
            }
           if (i % 2 != 0){
                sb = sb.append(decrypt2.charAt(b));
                b += 1;
                //System.out.println("b = " + b);
            }
        }
       return sb.toString();
    }
    
   public void testDecryptTwoKeys(){
       String test1 = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
       System.out.println(decryptTwoKeys(test1));
       System.out.println("the key is: " + getKey(test1));
   }
   
   public void DecryptAFile(){
       FileResource f = new FileResource();
       String execute = decryptTwoKeys(f.asString());
       System.out.println(execute);
        }
        
    }
    
