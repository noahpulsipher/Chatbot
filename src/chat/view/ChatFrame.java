package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPane;
	
	/**
	 * Initializes the data members.
	 * @param appController
	 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPane = new ChatPanel(appController);
		setupFrame();
	}
	
	/**
	 * Sets the frame to a certain size.
	 */
	private void setupFrame()
	{
		this.setSize(600, 600);
		this.setTitle("Chatting with the chatbot");
		this.setContentPane(appPane);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/**
	 * Sets up the JPanel.
	 */
	private void setupPanel()
	{
		
	}
	
	public ChatbotController getAppController()
	{
		return appController;
	}
}
