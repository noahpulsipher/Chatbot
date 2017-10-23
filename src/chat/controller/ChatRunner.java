package chat.controller;

import chat.view.PopupDisplay;

public class ChatRunner 
{
	public static void main (String [] args)
	{
		PopupDisplay test = new PopupDisplay();
		test.displayText("words go here");
		test.getResponse("ask a question");
	}
}
