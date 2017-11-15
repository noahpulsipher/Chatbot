package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPane;
	
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPane = new ChatPanel(appController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(600, 600);
		this.setTitle("Chatting with the chatbot");
		this.setContentPane(appPane);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void setupPanel()
	{
		
	}
	
	

}
