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
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildShoppingList();
		buildCuteAnimals();
		buildTopics();
		buildQuestions();
	//	buildFollowups();
	}
	
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
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("FLOOFER");
	}
	
	private void buildTopics()
	{
		topics[0] = "Memes";
		topics[1] = "Science";
		topics[2] = "Physics";
		topics[3] = "Superheroes";
		topics[4] = "Music";
		topics[5] = "Math";
		topics[6] = "Sports";
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your favorite color?";
		questions[1] = "What is your favorite food?";
		questions[2] = "What is your favorite sport?";
		questions[3] = "Do you have a hobby?";
		questions[4] = "What is your favorite movie?";
		questions[5] = "What is your favorite book?";
		questions[6] = "What is your favorite place to vacation?";
		questions[7] = "What is your favorite outdoors activity?";
		questions[8] = "What is your favorite television show?";
		questions[9] = "How old are you?";
	}
	
	public String processConversation(String input)

	{
		String chatbotResponse = "";
		chatbotResponse+= "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2) 
		{
			validLength = true;
		}
	
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		boolean validQuit = false;
		
		if (exitString != "" && exitString != null && !exitString.equalsIgnoreCase("exit") && exitString.equalsIgnoreCase("quit"))
		{
			validQuit = true;
		}
		return validQuit;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
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
