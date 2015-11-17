package hipster.model;

public class Hipster
{
	private String name;
	private String[] hipsterPhrases;

	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		setupArray();
		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That's to mainstream!";
		hipsterPhrases[1] = "I don't want sound like a hipster, but vinyl has a better sound then CD.";
		hipsterPhrases[2] = "Those hot chips sucked, that corner store store doesn't sell anything good.";
		hipsterPhrases[3] = "I was into coding before it was cool.";
	}
	
	private void setupBooks()
	{
		
	}
	
	public Hipster(String name)
	{
		
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPhrases(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}
}
