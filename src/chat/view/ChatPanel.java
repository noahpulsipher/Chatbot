package chat.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
	
	/**
	 * 
	 * @param appController
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check");
		searchButton = new JButton("search", new ImageIcon(getClass().getResource("/chat/view/images/searchIcon.png")));
		saveButton = new JButton("save", new ImageIcon(getClass().getResource("/chat/view/images/saveIcon.png")));
		loadButton = new JButton("load", new ImageIcon(getClass().getResource("/chat/view/images/loadIcon.png")));
		tweetButton = new JButton("tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweetIcon.png")));
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		infoLabel = new JLabel("Type to chat with the chatbot");
		appLayout = new SpringLayout();
		chatScrollPane = new JScrollPane();

		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * Defines the Panel.
	 */
	private void setupPanel()
	{
		this.setBackground(new Color(0, 204, 204));
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(checkerButton);
		this.add(infoLabel);
		this.add(searchButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(tweetButton);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}
	
	/**
	 * Where all the putContraints are put to keep track of them.
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 25, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -6, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 13, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -6, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, -18, SpringLayout.WEST, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 124, SpringLayout.EAST, loadButton);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -6, SpringLayout.NORTH, infoLabel);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 52, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -197, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 6, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -2, SpringLayout.NORTH, infoLabel);
	}
	
	/**
	 * Listens for a click and then completes a task when activated.
	 */
	private void setupListeners()
	{
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			
			}
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String usernameToSearch = inputField.getText();
				
				chatArea.setText(appController.search(usernameToSearch));
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
			}
		});
	}
}
