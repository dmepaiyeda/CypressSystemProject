//Code by Jared Rand
//Ryerson University
//500683609

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JComponent ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseEvent ;
import javax.swing.JButton ;
import javax.swing.JLabel ;
import javax.swing.JPanel ;
import javax.swing.JTextField ;
import javax.swing.JFrame ;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.Toolkit ;
import java.util.concurrent.TimeUnit ;
import java.awt.Color ;
import javax.swing.Timer ;
import java.util.Random ;
import java.awt.Font;
import javax.swing.JPasswordField;

enum pageNames
{
	MAINSCREEN(0),
	LOGIN(1),
	PORTAL(2),
	REGISTRATION(3),
	REPORTING(4);

	private int value;
	pageNames(int value)
	{
		this.value = value;
	}
	int getValue()
	{
		return this.value;
	}
}

enum languageEnum
{
	ENGLISH(0),
	FRENCH(1);

	private int value;
	languageEnum(int value)
	{
		this.value = value;
	}
	int getValue()
	{
		return this.value;
	}
}

public class GUI
{
	public JFrame frame;
	int pageNum;
	public boolean is_logged_in;
	public int usernum;
	public JPanel[] pages;
	public JButton[][] buttons;
	public JTextField[][] textBoxes;
	public JRadioButton[][] radioButtons;
	public JLabel[][] labels;
	public ButtonGroup[] buttonGroups;
	public Profiles profiles;

	public GUI()
	{
		//Setting up the frame
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("CYPRESS");
		/**
		Prepare the resources
		*/

		profiles = new Profiles();

		//No user is logged in
		usernum = -1;
		//There are 9 pages set up
		pages = new JPanel[9];
		for (int i = 0; i < 9; i++)
		{
			pages[i] = new JPanel();
		}
		buttons = new JButton[5][4];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				buttons[i][j] = new JButton();
			}
		}
		textBoxes = new JTextField[5][7];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				textBoxes[i][j] = new JTextField();
			}
		}
		radioButtons = new JRadioButton[5][7];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				radioButtons[i][j] = new JRadioButton();
			}
		}
		labels = new JLabel[5][8];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				labels[i][j] = new JLabel();
			}
		}
		buttonGroups = new ButtonGroup[5];
		for (int i = 0; i < 5; i++)
		{
			buttonGroups[i] = new ButtonGroup();
		}

		/**
		Setting up the front page (LANGUAGE SELECTION)
		*/
		setFrontPage();

		/**
		Set up the second page (MAIN MENU)
		*/
		setMainMenuPage();

		/**
		Setting up the third page (REGISTRATION)
		*/
		setRegistrationPage();

		/**
		Setting up the fourth page (LOGIN)
		*/
		setLoginPage();

		//Set the page and start the program
		setPage(0);
	}

	public void setFrontPage()
	{
		pages[0].setLayout(new BorderLayout(0, 0));
		labels[0][0] = new JLabel("CYPRESS");
		labels[0][0].setFont(new Font("Arial", Font.BOLD, 50));
		labels[0][0].setHorizontalAlignment(SwingConstants.CENTER);
		pages[0].add(labels[0][0], BorderLayout.NORTH);
		labels[0][1] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/City_of_Toronto_Logo.png"));
		labels[0][1].setHorizontalAlignment(SwingConstants.CENTER);
		pages[0].add(labels[0][1], BorderLayout.CENTER);
		JPanel frontPageButtons = new JPanel();
		buttons[0][0] = new JButton("English");
		buttons[0][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(1);
			}
		});
		frontPageButtons.add(buttons[0][0]);
		buttons[0][1] = new JButton("French");
		buttons[0][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(1);
			}
		});
		frontPageButtons.add(buttons[0][1]);
		pages[0].add(frontPageButtons, BorderLayout.SOUTH);
	}

	public void setMainMenuPage()
	{
		pages[1].setLayout(new BorderLayout(0,0));
		JPanel mainMenu = new JPanel(new GridLayout(7,1,0,0));

		radioButtons[1][0] = new JRadioButton("Register");
		buttonGroups[1].add(radioButtons[1][0]);
		mainMenu.add(radioButtons[1][0]);
		radioButtons[1][1] = new JRadioButton("Login");
		buttonGroups[1].add(radioButtons[1][1]);
		mainMenu.add(radioButtons[1][1]);
		radioButtons[1][2] = new JRadioButton("Report a Problem");
		buttonGroups[1].add(radioButtons[1][2]);
		mainMenu.add(radioButtons[1][2]);
		radioButtons[1][3] = new JRadioButton("Suggestion");
		buttonGroups[1].add(radioButtons[1][3]);
		mainMenu.add(radioButtons[1][3]);
		radioButtons[1][4] = new JRadioButton("Vote");
		buttonGroups[1].add(radioButtons[1][4]);
		mainMenu.add(radioButtons[1][4]);
		radioButtons[1][5] = new JRadioButton("FAQ");
		buttonGroups[1].add(radioButtons[1][5]);
		mainMenu.add(radioButtons[1][5]);
		radioButtons[1][6] = new JRadioButton("Contact Us");
		buttonGroups[1].add(radioButtons[1][6]);
		mainMenu.add(radioButtons[1][6]);

		JPanel cityStuff = new JPanel(new BorderLayout(0,0));
		labels[1][0] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/Toronto-Shutterstock.png"));
		labels[1][0].setHorizontalAlignment(SwingConstants.CENTER);
		cityStuff.add(labels[1][0], BorderLayout.WEST);
		labels[1][1] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/Annex_houses.png"));
		labels[1][1].setHorizontalAlignment(SwingConstants.CENTER);
		cityStuff.add(labels[1][1], BorderLayout.EAST);
		labels[1][0] = new JLabel("Keeping Our City Streets Clean and Safe...");
		labels[1][0].setHorizontalAlignment(SwingConstants.CENTER);
		cityStuff.add(labels[1][0], BorderLayout.SOUTH);

		pages[1].add(mainMenu, BorderLayout.WEST);
		pages[1].add(cityStuff, BorderLayout.EAST);

		JPanel mainMenuGo = new JPanel();
		buttons[1][0] = new JButton("GO");
		buttons[1][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (radioButtons[1][0].isSelected())
				{
					setPage(2);
				}
				if (radioButtons[1][1].isSelected())
				{
					setPage(3);
				}
				if (radioButtons[1][2].isSelected())
				{
					setPage(4);
				}
			}
		});
		mainMenuGo.add(buttons[1][0]);
		pages[1].add(mainMenuGo, BorderLayout.SOUTH);
	}

	public void setRegistrationPage()
	{
		pages[2].setLayout(new BorderLayout(0,0));
		JPanel registrationScreen = new JPanel(new GridLayout(8,2,10,10));
		labels[2][0] = new JLabel("First name:");
		labels[2][1] = new JLabel("Last name:");
		labels[2][2] = new JLabel("Address:");
		labels[2][3] = new JLabel("Phone number:");
		labels[2][4] = new JLabel("Email Address:");
		labels[2][5] = new JLabel("Username:");
		labels[2][6] = new JLabel("Password:");
		textBoxes[2][6] = new JPasswordField();
		for (int i = 0; i < 7; i++)
		{
			registrationScreen.add(labels[2][i]);
			registrationScreen.add(textBoxes[2][i]);
		}
		labels[2][7] = new JLabel();
		if (usernum > -1)
		{
			labels[2][7].setText("User is logged in: " + profiles.getUser(usernum));
		}
		else
		{

			labels[2][7].setText("No user logged in");
		}
		registrationScreen.add(labels[2][7]);
		pages[2].add(registrationScreen, BorderLayout.CENTER);

		JPanel regBottomPanel = new JPanel(new GridLayout(1,3,3,0));
		buttons[2][0] = new JButton("Register");
		buttons[2][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!profiles.try_validate_user(textBoxes[2][5].getText(), textBoxes[2][6].getText()))
				{
					labels[2][7].setText("Username could not be registered. Please try a different username.");
				}
				else
				{
					labels[2][7].setText("User profile was successfully created.");
				}
			}
		});
		regBottomPanel.add(buttons[2][0]);
		buttons[2][1] = new JButton("Cancel");
		buttons[2][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(1);
			}
		});
		regBottomPanel.add(buttons[2][1]);
		buttons[2][2] = new JButton("FAQ");
		buttons[2][2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(7);
			}
		});
		regBottomPanel.add(buttons[2][2]);

		pages[2].add(regBottomPanel, BorderLayout.SOUTH);
	}

	public void setLoginPage()
	{
		pages[3].setLayout(new BorderLayout(0,0));
		labels[3][0] = new JLabel("Welcome to CYPRESS, the City of Toronto's brand new Problem Reporting System.");
		pages[3].add(labels[3][0], BorderLayout.NORTH);
		JPanel loginPanel = new JPanel(new GridLayout(3,2,10,10));
		labels[3][1] = new JLabel("Username:");
		labels[3][2] = new JLabel("Password:");
		textBoxes[3][1] = new JPasswordField();
		for (int i = 0; i < 2; i++)
		{
			loginPanel.add(labels[3][i+1]);
			loginPanel.add(textBoxes[3][i]);
		}
		labels[3][3] = new JLabel("No user logged in");
		loginPanel.add(labels[3][3]);
		pages[3].add(loginPanel, BorderLayout.CENTER);

		JPanel loginBottomPanel = new JPanel(new GridLayout(1,3,5,0));
		buttons[3][0] = new JButton("Login");
		buttons[3][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				usernum = profiles.validate_user(textBoxes[3][0].getText(), textBoxes[3][1].getText());
				if (usernum == -1)
				{
					labels[3][3].setText("No user logged in");
				}
				else
				{
					labels[3][3].setText("User was successfully logged in");
				}
			}
		});
		loginBottomPanel.add(buttons[3][0]);
		buttons[3][1] = new JButton("Cancel");
		buttons[3][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(1);
			}
		});
		loginBottomPanel.add(buttons[3][1]);
		buttons[3][2] = new JButton("FAQ");
		buttons[3][2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(7);
			}
		});
		loginBottomPanel.add(buttons[3][2]);
		pages[3].add(loginBottomPanel, BorderLayout.SOUTH);
	}

	public void setReportPage()
	{
		/**
		TO DO TOMORROW
		*/
	}

	public int getPage()
	{
		return pageNum;
	}
	public void setPage(int pageNum)
	{
		this.pageNum = pageNum;
		renderPage();
	}
	public void renderPage()
	{
		frame.getContentPane().removeAll();
		frame.add(pages[pageNum], BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
		frame.pack();
		frame.setVisible(true);
	}
	public boolean[][] getRadioButtonData()
	{
		boolean[][] output = new boolean[5][7];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				output[i][j] = false;
				if (radioButtons[i][j] != null)
				{
					output[i][j] = radioButtons[i][j].isSelected();
				}
			}
		}
		return output;
	}
	/*public String[][] getTextFieldData()
	{
		
	}*/
	public static void main(String[] args)
	{
		GUI gui = new GUI();
	}
}