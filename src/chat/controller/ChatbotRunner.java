package chat.controller;

import chat.view.PopupDisplay;

/**
 * Runs the project so there is a controller
 * @author npul1355
 */
public class ChatbotRunner 
{
	public static void main (String [] args)
	{
		ChatbotController app = new ChatbotController();
		app.start();
	}
}
