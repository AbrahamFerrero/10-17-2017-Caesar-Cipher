------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Caesar Breaker
PURPOSE OF PROJECT:
VERSION or DATE: 20/10/2017
AUTHORS: Abraham Ferrero
USER INSTRUCTIONS:
Assignment 2: Caesar Cipher Two Keys Decrypt

You should start by writing the decryption method explained in the lesson that decrypts a message that was encrypted with one key, using statistical letter frequencies of English text.
 Then you will add code to be able to decrypt a message that was encrypted with two keys, 
using ideas from the single key decryption method and the encryption with two keys method from the program you wrote in the last lesson.

Idea for two keys decrypt method. Recall that in using two keys, key1 and key2, key1 was used to encrypt every other character, starting with the first,
 of the String, and key2 was used to encrypt every other character, starting with the second. In order to decrypt the encrypted String,
 it may be easier to split the String into two Strings, one String of all the letters encrypted with key1 and one String of all the letters encrypted with key2.
 Then use the algorithm from the lesson to determine the key for each String, and then use those keys and the two key encryption method to decrypt the original encrypted message.

For example, if the encrypted message was “Qbkm Zgis”, then you would split this String into two Strings: “Qk gs”,
 representing the characters in the odd number positions and “bmZi” representing the characters in the even number positions.
 Then you would get the key for each half String and use the two key encryption method to find the message. Note this example is so small it likely won’t find the keys,
 but it illustrates how to take the Strings apart.

A sample file to test your program that is small with lots of e’s is called wordsLotsOfEs.txt and shown here:

Just a test string with lots of eeeeeeeeeeeeeeeees

And the same file encrypted using keys 23 and 2 is called wordsLotsOfEsEncrypted.txt and is shown here:

Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu

Specifically, you should do the following.

Complete the decryption method shown in the lesson by creating a CaesarBreaker class with the methods countLetters, maxIndex, and decrypt. 
Recall that the decrypt method creates a CaesarCipher object in order to use the encrypt method you wrote for the last lesson.
 Make sure that your CaesarCipher class is in the same folder as CaesarBreaker! You may want to use the following code as part of your decrypt method.


CaesarCipher cc = new CaesarCipher();
String message = cc.encrypt(encrypted, 26 - key);
Write a testDecrypt method in the CaesarBreaker class that prints the decrypted message, and make sure it works for encrypted messages that were encrypted with one key.
Write the method halfOfString in the CaesarBreaker class that has two parameters, a String parameter named message and an int parameter named start.
 This method should return a new String that is every other character from message starting with the start position. 
 For example, the call halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”. 
 Be sure to test this method with a small example.
Write the method getKey in the CaesarBreaker class that has one parameter, a String s. 
This method should call countLetters to get an array of the letter frequencies in String s and then use maxIndex to calculate the index of the largest letter frequency,
 which is the location of the encrypted letter ‘e’, which leads to the key, which is returned.
Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter,
 a String parameter named encrypted that represents a String that was encrypted with the two key algorithm discussed in the previous lesson. 
 This method attempts to determine the two keys used to encrypt the message, prints the two keys, and then returns the decrypted String with those two keys.
 More specifically, this method should:
 
- Calculate a String of every other character starting with the first character of the encrypted String by calling halfOfString.

- Calculate a String of every other character starting with the second character of the encrypted String.

- Then calculate the key used to encrypt each half String.

- You should print the two keys found.

- Calculate and return the decrypted String using the encryptTwoKeys method from your CaesarCipher class, again making sure it is in the same folder as your CaesarBreaker class.

Link to FAQ page for this course: http://www.dukelearntoprogram.com/course3/faq.php