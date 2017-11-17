package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;

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
	
	/**
	 * Starts the conversation.
	 */
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
}
