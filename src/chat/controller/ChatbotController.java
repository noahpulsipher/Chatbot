package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;

/**
 * Manages the Chatbot application including the Model and Frame of the View package.
 * @author Noah Pulsipher
 * @version 21.11.17 Added Frame 1.3  
 */
public class ChatbotController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	/**
	 * Initializes data members.
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Noah Pulsipher");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * Creates a popup with a outline for what the chatbot will say.
	 * @param chat
	 * @return
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = ""; //Assigns a valid value to a variable that will be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input); 
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	/**
	 * Starts the conversation.
	 */
	public void start()
	{
		display.displayText("Welcome to Chatbot");
	}
}
