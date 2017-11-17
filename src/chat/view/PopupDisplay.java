package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay 
{
	private ImageIcon icon;
	private String windowTitle;
	
	/**
	 * Sets an image for the chatbot.
	 */
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("chat.view.images/template guy.png"));
		windowTitle = "Chatbot says";
	}
	
	/**
	 * Displays the messages.
	 * @param message
	 */
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	/**
	 * Provides a outline for the answer.
	 * @param question
	 * @return The answer of what is put in.
	 */
	public String collectResponse(String question)
	{
		String answer = "";
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		return answer;
	}
}
