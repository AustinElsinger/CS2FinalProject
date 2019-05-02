package application;

import java.util.Random;

/****************************************************************************************************
 * @author Andrew Beidel
 * @author Austin Elsinger
 * 
 * @version 1.0
 * @since 2 May 2019
 * 
 *     |-| CHANGELOG |-|
 * N/A
 ****************************************************************************************************/
public class RandomWord
{
	private static final String[] WORD_BANK = {"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXPORTS", "EXTENDS", "FALSE", "FINAL", "FINALLY", "FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "MODULE", "NATIVE", "NEW", "NULL", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "REQUIRES", "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", "TRUE", "TRY", "VAR", "VOID", "VOLATILE", "WHILE"};
	private String word;
	
	/********************************************************************************
	 * This method is a constructor for a RandomWord object.
	 ********************************************************************************/
	public RandomWord()
	{
		Random random = new Random();
		
		//sets word to a random word in WORD_BANK
		word = WORD_BANK[random.nextInt(WORD_BANK.length)];
	}
	
	/********************************************************************************
	 * This method gets the randomly generated word.
	 * 
	 * @return The randomly generated word.
	 ********************************************************************************/
	public String getWord()
	{
		return word;
	}
}
