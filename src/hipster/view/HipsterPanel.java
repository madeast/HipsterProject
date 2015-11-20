package hipster.view;

import javax.swing.*;

import hipster.controller.HipsterController;
import hipster.model.Book;
import java.awt.Color;
import java.awt.event.*;
//import hipster.model.Book;


public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		bookPageCountLabel = new JLabel("The page count");
		bookAuthorLabel = new JLabel("The author");
		bookPriceLabel = new JLabel("The price");
		bookSubjectLabel = new JLabel("The subject");
		bookTitleLabel = new JLabel("The title");
		changeBookButton = new JButton("Change books");
		phraseComboBox = new JComboBox<String>();
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(phraseComboBox);
		this.add(bookSubjectLabel);
		this.add(bookAuthorLabel);
		this.add(bookTitleLabel);
		this.add(bookPriceLabel);
		this.add(bookPageCountLabel);
		this.add(changeBookButton);
		
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 0, SpringLayout.WEST, bookSubjectLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, changeBookButton, 6, SpringLayout.SOUTH, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.WEST, changeBookButton, 0, SpringLayout.WEST, bookSubjectLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookTitleLabel, -2, SpringLayout.NORTH, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookAuthorLabel, 0, SpringLayout.WEST, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookAuthorLabel, -6, SpringLayout.NORTH, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookPageCountLabel, 0, SpringLayout.WEST, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookTitleLabel, 0, SpringLayout.WEST, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookSubjectLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookSubjectLabel, -6, SpringLayout.NORTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPriceLabel, 137, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPageCountLabel, 7, SpringLayout.SOUTH, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookPriceLabel, 4, SpringLayout.WEST, this);
	}
	
	private void changeColour()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		setBackground(new Color(red, green, blue));
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				changeColour();
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}
		});
		
		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeColour();
				Book [] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				if(startClick < maxClicks)
				{
					bookSubjectLabel.setText("Book subject: " + tempBooks[startClick].getSubject());
					bookAuthorLabel.setText("Book author: " + tempBooks[startClick].getAuthor());
					bookTitleLabel.setText("Book title: " + tempBooks[startClick].getTitle());
					bookPageCountLabel.setText("Book page count: " + tempBooks[startClick].getPageCount());
					bookPriceLabel.setText("Book price: " + tempBooks[startClick].getPrice());
					startClick++;
				}
				else
				{
					startClick = 0;
					bookSubjectLabel.setText("Book subject: ");
					bookAuthorLabel.setText("Book author: ");
					bookTitleLabel.setText("Book title: ");
					bookPageCountLabel.setText("Book pages: ");
					bookPriceLabel.setText("Book price: ");
				}
			}
		});
	}
	
	
}
