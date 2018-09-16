package EYInterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LongestWordAndlength {
	protected int maxLength = 0;
	protected String maxWord = "";
	protected String errorMSG="";
	String str;
	int startIndexOfWord = 0;

	public void userInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(System.out, true);
		p.println("Enter string");
		str = br.readLine();
	}

	public void longestWordFromUser(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ' ') {
				String word = str.substring(startIndexOfWord, i);
				if (word.length() > maxLength) {
					maxLength = word.length();
				}
				startIndexOfWord = i + 1;
			}
		}
		String word = str.substring(startIndexOfWord, str.length());
		if (word.length() >= maxLength) {
			maxLength = word.length();
			maxWord = word;
		}

		if (maxLength == 0) {
			errorMSG="Please enter valid sentence";
			System.out.println(errorMSG);
		} else {
			System.out.println("The length of the longest word is " + maxLength);
			System.out.println("The longest word is " + maxWord);
		}

	}

}
