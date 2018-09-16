package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import EYInterview.LongestWordAndlength;
import annotation.Author;
import annotation.AuthorName;
import annotation.Priority;
import annotation.TestCaseNotes;
import listeners.TestListener;

@Test
@Listeners(TestListener.class)
public class LongestWord extends LongestWordAndlength {
	
	@Test(groups= {"regression","smoke","positive"})
	@Author(name = AuthorName.SRIKANTH)
	@TestCaseNotes(id="EY0001",title="to check the length of the highest word in the sentence",expectedResult="Longest word Srikanth and length is 8",priority=Priority.HIGH)
	public void longestWord() {
		LongestWordAndlength lw = new LongestWordAndlength();
		lw.longestWordFromUser("My name is Srikanth");
		Assert.assertEquals(maxLength, 8);
		Assert.assertEquals(maxWord,"Srikanth");	
	}
	
	@Test(groups= {"regression","negative"})
	@Author(name = AuthorName.SRIKANTH)
	@TestCaseNotes(id="EY0002",title="to check the length of the highest word in the sentence when space is passed",expectedResult="Should throw the error message with invalid sentence",priority=Priority.HIGH)
	public void longestWordWithSpaceAsSentence() {
		LongestWordAndlength lw = new LongestWordAndlength();
		lw.longestWordFromUser("       ");
		Assert.assertEquals(errorMSG,"Please enter valid sentence");	
	}
	
	
	@Test(groups= {"regression","psoitive"})
	@Author(name = AuthorName.SRIKANTH)
	@TestCaseNotes(id="EY0003",title="to check the length of the highest word in the sentence",expectedResult="Longest word will the last longest word in the sentecnce and length is 8",priority=Priority.MEDIUM)
	public void WithDulicateSameLongestlengthWord() {
		LongestWordAndlength lw = new LongestWordAndlength();
		lw.longestWordFromUser("My name is Srikanth1 Srikanth2");
		Assert.assertEquals(maxLength, 9);
		Assert.assertEquals(maxWord,"Srikanth2");
	}
	
	@Test(groups= {"regression","smoke","negative"})
	@Author(name = AuthorName.SRIKANTH)
	@TestCaseNotes(id="EY0004",title="to check the length of the highest word when there is no sentence from user",expectedResult="Should throw the validation error",priority=Priority.LOW)
	public void longestWordWithoutSpaceAsSentecne() {
		LongestWordAndlength lw = new LongestWordAndlength();
		lw.longestWordFromUser("");
		Assert.assertEquals(errorMSG,"Please enter valid sentence");	
	}
	
	@Test(groups= {"regression","negative"})
	@Author(name = AuthorName.SRIKANTH)
	@TestCaseNotes(id="EY0005",title="to check the length of the highest word when there is , beside sentence",expectedResult="Should count comma in the highest length word",priority=Priority.LOW)
	public void longestWordWithCommaInTheSentecne() {
		LongestWordAndlength lw = new LongestWordAndlength();
		lw.longestWordFromUser("My name is srikanth, srikanth");
		Assert.assertEquals(maxLength, 8);
		Assert.assertEquals(maxWord,"Srikanth,");	
	}
	
	@Test(groups= {"regression","negative"})
	@Author(name = AuthorName.SRIKANTH)
	@TestCaseNotes(id="EY0006",title="to check the length of the highest word when there is , beside sentence",expectedResult="Should count comma in the highest length word",priority=Priority.LOW)
	public void longestWordWithSpecialCharactersInTheSentecne() {
		LongestWordAndlength lw = new LongestWordAndlength();
		lw.longestWordFromUser("My name is srikanth  sr!k@nth");
		Assert.assertEquals(maxLength, 8);
		Assert.assertEquals(maxWord,"sr!k@nth");	
	}

}
