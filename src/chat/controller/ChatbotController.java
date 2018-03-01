package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;

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
	private CTECTwitter myTwitter;
	
	/**
	 * Initializes data members.
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Noah Pulsipher");
		myTwitter = new CTECTwitter(this);
		//View components
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
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "That is a cute meme!\n";
		}
		if(chatbot.userNameChecker(text))
		{
			response += "Good username.\n";
		}
		if(chatbot.contentChecker(text))
		{
			response += "Thats some good content.\n";
		}
		if(chatbot.shoppingListChecker(text))
		{
			response += "I like to shop at Harmons\n";
		}
		if(chatbot.movieTitleChecker(text))
		{
			response = "Thats one of my favorites!\n";
		}
		if(chatbot.movieGenreChecker(text))
		{
			response = "My favorite kind of movie is comedy!\n";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response = "ad;fkjvnerhf\n";
		}
		
		return response;
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
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	
	public void search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
}
