
package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	/**
	 * Assigns the data members a type and builds methods
	 * @param username
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String [10];
		this.username = username;
		this.content = "Words go here";
		this.intro = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildShoppingList();
		buildCuteAnimals();
		buildTopics();
      	buildQuestions();
		buildFollowups();
	}
	
	/**
	 * Array that holds the verbs that the chatbot has towards certain topics.
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}

//	private void buildMovieList()
//	{
//		movieList.add("Spiderman");
//		movieList.add("Hidden Figures");
//		movieList.add("Intersteller");
//		movieList.add("The Emoji Movie");
//		movieList.add("The Lego Batman Movie");
//		movieList.add("The White Helmets");
//	}
	
	/**
	 * Adds things into the shopping list array list.
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("fruits");
		shoppingList.add("candy");
		shoppingList.add("shampoo");
		shoppingList.add("conditioner");
		shoppingList.add("milk");
		shoppingList.add("chips");
		shoppingList.add("salsa");
		shoppingList.add("cheese");
	}
	
	/**
	 * Adds things into the cute animal array list.
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("floofer");
	}
	
	/**
	 * Adds things into the topics array so that chatbot can talk about them.
	 */
	private void buildTopics()
	{
		topics[0] = "Memes";
		topics[1] = "Movies";
		topics[2] = "Games";
		topics[3] = "Dogs";
		topics[4] = "Music";
		topics[5] = "Cars";
		topics[6] = "Sports";
	}
	
	/**
	 * Adds questions into the questons array so that chatbot can ask them.
	 */
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What is your favorite food?";
		questions[2] = "What is your favorite color?";
		questions[3] = "What do you like to do in your free time?";
		questions[4] = "What is your favorite movie?";
		questions[5] = "What is your favorite book?";
		questions[6] = "What is your favorite place to vacation?";
		questions[7] = "What is your favorite outdoors activity?";
		questions[8] = "What is your favorite television show?";
		questions[9] = "What is your favorite song?";
	}
	
	private void buildFollowups()
	{
		followUps[0] = "\nI like dogs.";
		followUps[1] = "\nI like watching movies.";
		followUps[2] = "\nComedy T.V. shows are the best.";
		followUps[3] = "\nMy favorite book is the bible.";
		followUps[4] = "\nDo you have a moment to talk about our Lord and Savior Jesus Christ?";
	}
	
	/**
	 * Builds a response based on the users input and the created chatbot response.
	 * @param Takes users input as a String.
	 * @return Returns the user input and a response built by buildChatbotResponse.
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime= LocalTime.now();
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * It builds a random response based on verbs, topics and questions.
	 * @return The random sentence built by the arrays that are already defined.
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * shoppingList.size());
			response += "\n" + shoppingList.get(random) + " is yummy!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
				response += followUps[4] + "\n";
				response += followUps[3] + "\n";
				break;
		}
		 
		return response;
	}
	
	/**
	 * Checks to make sure the user response is greater than two and that there actually is a response.
	 * @param input
	 * @return true if valid input.
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2) 
		{
			validLength = true;
		}
	
		return validLength;
	}
	
	/**
	 * Makes sure that the tags have proper documentation.
	 * @param input
	 * @return true if valid input.
	 */
	public boolean htmlTagChecker(String input)
	{
		boolean validTag = false;
//		boolean length = true;
//		int len = input.length();
//		int one = input.indexOf("<") + 1;
//		int two = input.indexOf(">");
//		int three = input.indexOf("<" + "/") + 2;
//		String temp = input;
//		temp = temp.replaceFirst(">", " ");
//		int four = temp.indexOf(">");
//		if(len > 3)
//		{
//			length = false;
//		}
//		if(length && three > one && four > two && input.toLowerCase().substring(one, two).contains(input.toLowerCase().substring(three,four)))
//		{
//			validTag = true;
//		}
//		if(length && input.substring(one, two).equalsIgnoreCase("p") || length && input.substring(one, two).equalsIgnoreCase("br"))
//		{
//			validTag = true;
//		}
//		
//		String a = "";
//		if(length) 
//		{
//			a = input.toLowerCase().substring(one, two);
//		}
//		if(input == null || !input.contains("<"))
//		{
//			return validTag;
//		}
//		if(a.contains("a href"))
//		{
//			if(!a.contains("a href") && !a.contains("a href a"))
//			{
//				validTag = false;
//			}
//		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">");
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		//Check bad tags
		if(input.contains("<>") || input.indexOf("< >") > -1)
		{
			validTag = false; 
		}
		//Check singleton
		if(input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
		{
			validTag = true;
		}
		//Check others
		else if(firstClose > firstOpen)
		{
			//Others
			tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
			
			if(tagText.contains("A HREF"))
			{
				if(!tagText.contains("A HREF =") || !tagText.contains("A HREF="))
				{
					validTag = true;
				}
			}
		}
		
		
			return validTag;
	}
	
	/**
	 * Makes sure that the users name has proper use of "@".
	 * @param input
	 * @return true if input is valid.
	 */
	public boolean userNameChecker(String input)
	{
		boolean validUser = false;
		
		if (input != "" && input != null && input.indexOf("@") <= 0 && input.indexOf("@") >= 0 && !input.contains("@" + "@"))
		{
			validUser = true;
		}
		return validUser;
	}
	
	/**
	 * 
	 * @param contentCheck
	 * @return
	 */
	public boolean contentChecker(String contentCheck)
	{
		boolean validContent = false;
		
		if(contentCheck.contains(content))
		{
			validContent = true;
		}
		return validContent;
	}
	
	/**
	 * Makes sure that cute animal memes has good memes and not bad ones.
	 * @param input
	 * @return true if input is valid.
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean validMeme = false;
		
		if (!input.equals("pepe") && input.equals("pupper") || input.equals("otter") || input.equals("kittie"))
		{
			validMeme = true;
		}
		return validMeme;
	}
	
	/**
	 * Checks to make sure the shopping list is long enough.
	 * @param shoppingItem
	 * @return true if input is valid.
	 */
	public boolean shoppingListChecker(String shoppingItem) //Checks shopping items to make sure it contains/doesn't contain certain things.
	{
		boolean validList = false;
		
		for (int index = 0; index < 11; index ++)
		{
			if(shoppingItem.contains(shoppingList.get(index)))
			{
				validList = true;
			}
		}
		return validList;
	}
	
	public String toString()
	{
		String descriptionString = "";
		return descriptionString;
	}
	
	/**
	 * Makes sure that the movie titles are good.
	 * @param title
	 * @return true if input is valid.
	 */
	public boolean movieTitleChecker(String title)
	{
		boolean validTitle = false;
		
		if(!title.equals("") && title.equals("Spiderman") || title.equals("Hidden Figures"))
		{
			validTitle = true;
		}
		
		return validTitle;
	}
	
	/**
	 * Makes sure that a genre is included in the movie array.
	 * @param genre
	 * @return true if input is valid.
	 */
	public boolean movieGenreChecker(String genre)
	{
		boolean validGenre = false;
		
		if(!genre.equals("") && genre.equals("Documentary") || genre.equals("Thriller"))
		{
			validGenre = true;
		}
		return validGenre;
	}
	
	/**
	 * If the users response is exit or quit.
	 * @param exitString
	 * @return true if input is valid.
	 */
	public boolean quitChecker(String exitString)
	{
		boolean validQuit = false;
		
		if (exitString != "" && exitString != null && !exitString.equalsIgnoreCase("exit") && exitString.equalsIgnoreCase("quit"))
		{
			validQuit = true;
		}
		return validQuit;
	}
	
	/**
	 * Makes sure that the keyboard isn't being spammed.
	 * @param sample
	 * @return true if input is valid.
	 */
	public boolean keyboardMashChecker(String sample)
	{
		boolean validKeyboard = false;
		
		if (sample.contains("sdf") || sample.contains("SDF") || sample.contains("dfg") || sample.contains("cvb") || sample.contains(",./") || sample.contains("kjh") || sample.contains("DFG") || sample.contains("CVB") || sample.contains("KJH"))
		{
			validKeyboard = true;
		}
		else if (sample.contains("S.D.F.") || sample.contains("derf"))
		{
			validKeyboard = false;
		}
		return validKeyboard;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
