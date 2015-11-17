package hipster.view;

import javax.swing.*;
import hipster.controller.HipsterController;
import java.awt.Color;
import java.awt.event.*;
//import hipster.model.Book;


public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;
	
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		
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
		this.setBackground(Color.ORANGE);
		this.add(phraseComboBox);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				setBackground(new Color(red, green, blue));
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}
		});
	}
	
	
}
