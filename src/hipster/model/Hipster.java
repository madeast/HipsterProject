package hipster.model;

import hipster.model.Book;

public class Hipster
{
	private String name;
	private String[] hipsterPhrases;
	private Book [] hipsterBooks;

	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
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
		Book firstBook, secondBook, thirdBook;
		firstBook = new Book();
		firstBook.setAuthor("Rick Riordan");
		firstBook.setTitle("The Lightning Thief");
		firstBook.setSubject("Fiction");
		firstBook.setPageCount(205);
		firstBook.setPrice(24.99);
		
		secondBook = new Book();
		secondBook.setAuthor("Brandon Sanderson");
		secondBook.setTitle("MistBorn");
		secondBook.setSubject("Fantasy");
		secondBook.setPageCount(515);
		secondBook.setPrice(19.99);
		
		thirdBook = new Book(645, "Emily King", "The White Tiger", "Fantasy", 29.99);
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
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
