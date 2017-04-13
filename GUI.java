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
	public Authentication authentication;
	public LanguageSelect languageSelect;
	public Registration registration;
	public QuesAns quesAns;

	public GUI()
	{
		//Setting up the frame
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("CYPRESS");
		frame.setSize(560, 280);
		/**
		Prepare the resources
		*/

		profiles = new Profiles();
		authentication = new Authentication(profiles);
		languageSelect = new LanguageSelect();
		registration = new Registration(profiles);
		quesAns = new QuesAns();

		//No user is logged in
		usernum = -1;
		//There are 9 pages set up
		pages = new JPanel[9];
		for (int i = 0; i < pages.length; i++)
		{
			pages[i] = new JPanel();
		}
		buttons = new JButton[pages.length][4];
		for (int i = 0; i < pages.length; i++)
		{
			for (int j = 0; j < buttons[i].length; j++)
			{
				buttons[i][j] = new JButton();
			}
		}
		textBoxes = new JTextField[pages.length][7];
		for (int i = 0; i < pages.length; i++)
		{
			for (int j = 0; j < textBoxes[i].length; j++)
			{
				textBoxes[i][j] = new JTextField();
			}
		}
		radioButtons = new JRadioButton[pages.length][8];
		for (int i = 0; i < pages.length; i++)
		{
			for (int j = 0; j < radioButtons[i].length; j++)
			{
				radioButtons[i][j] = new JRadioButton();
			}
		}
		labels = new JLabel[pages.length][8];
		for (int i = 0; i < pages.length; i++)
		{
			for (int j = 0; j < labels[i].length; j++)
			{
				labels[i][j] = new JLabel();
			}
		}
		buttonGroups = new ButtonGroup[pages.length];
		for (int i = 0; i < pages.length; i++)
		{
			buttonGroups[i] = new ButtonGroup();
		}

		setFrontPage();

		setMainMenuPage();

		setRegistrationPage();

		setLoginPage();

		setReportPage();

		setChangeInfoPage();

		setFAQPage();

		setLogoutPage();

		//Set the page and start the program
		setPage(0);
	}

	/**
	Set up the SPLASH PAGE
	*/

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
				languageSelect.change("English");
				setPage(1);
			}
		});
		frontPageButtons.add(buttons[0][0]);
		buttons[0][1] = new JButton("French");
		buttons[0][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				languageSelect.change("French");
				setPage(1);
			}
		});
		frontPageButtons.add(buttons[0][1]);
		pages[0].add(frontPageButtons, BorderLayout.SOUTH);
	}

	/**
	Set up the MAIN MENU
	*/

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
		radioButtons[1][3] = new JRadioButton("Change Info");
		buttonGroups[1].add(radioButtons[1][3]);
		mainMenu.add(radioButtons[1][3]);
		radioButtons[1][4] = new JRadioButton("Vote");
		buttonGroups[1].add(radioButtons[1][4]);
		mainMenu.add(radioButtons[1][4]);
		radioButtons[1][5] = new JRadioButton("FAQ");
		buttonGroups[1].add(radioButtons[1][5]);
		mainMenu.add(radioButtons[1][5]);
		radioButtons[1][6] = new JRadioButton("Logout");
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
					buttonGroups[1].clearSelection();
				}
				if (radioButtons[1][1].isSelected())
				{
					setPage(3);
					buttonGroups[1].clearSelection();
				}
				if (radioButtons[1][2].isSelected())
				{
					setPage(4);
					buttonGroups[1].clearSelection();
				}
				if (radioButtons[1][3].isSelected())
				{
					setPage(5);
					buttonGroups[1].clearSelection();
				}
				if (radioButtons[1][5].isSelected())
				{
					setPage(7);
					buttonGroups[1].clearSelection();
				}
				if (radioButtons[1][6].isSelected())
				{
					setPage(8);
					buttonGroups[1].clearSelection();
				}
				if (usernum > -1)
				{
					labels[8][3].setText("User is logged in: " + profiles.getUser(usernum));
				}
				else
				{
					labels[8][3].setText("No user logged in");
				}
			}
		});
		mainMenuGo.add(buttons[1][0]);
		pages[1].add(mainMenuGo, BorderLayout.SOUTH);
	}

	/**
	Set up the REGISTRATION PAGE
	*/

	public void setRegistrationPage()
	{
		pages[2].setLayout(new BorderLayout(0,0));
		JPanel registrationScreen = new JPanel(new GridLayout(8,2,10,10));
		labels[2][0] = new JLabel("First name:");
		labels[2][1] = new JLabel("Last name:");
		labels[2][2] = new JLabel("Address:");
		labels[2][3] = new JLabel("Email Address:");
		labels[2][4] = new JLabel("Mother's Maiden Name:");
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
				labels[2][7].setText(registration.validate_user(textBoxes[2][5].getText(), textBoxes[2][6].getText(), textBoxes[2][4].getText()));
				if (profiles.answer_is_correct(textBoxes[2][5].getText(), textBoxes[2][4].getText()) > -1)
				{
					for (int i = 0; i < 7; i++)
					{
						if (textBoxes[2][i] != null)
						{
							textBoxes[2][i].setText("");
						}
					}
				}
			}
		});
		regBottomPanel.add(buttons[2][0]);
		buttons[2][1] = new JButton("Cancel");
		buttons[2][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for (int i = 0; i < 7; i++)
				{
					if (textBoxes[2][i] != null)
					{
						textBoxes[2][i].setText("");
					}
				}
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
				for (int i = 0; i < 7; i++)
				{
					if (textBoxes[2][i] != null)
					{
						textBoxes[2][i].setText("");
					}
				}
			}
		});
		regBottomPanel.add(buttons[2][2]);

		pages[2].add(regBottomPanel, BorderLayout.SOUTH);
	}

	/**
	Set up the LOGIN PAGE
	*/

	public void setLoginPage()
	{
		pages[3].setLayout(new BorderLayout(0,0));
		labels[3][0] = new JLabel("Welcome to CYPRESS, the City of Toronto's brand new Problem Reporting System.");
		pages[3].add(labels[3][0], BorderLayout.NORTH);
		JPanel loginPanel = new JPanel(new GridLayout(3,2,10,50));
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
				usernum = authentication.validate_user(textBoxes[3][0].getText(), textBoxes[3][1].getText());
				if (usernum == -1)
				{
					labels[3][3].setText("No user logged in");
				}
				else
				{
					labels[3][3].setText("User was successfully logged in");
					labels[2][7].setText("User is logged in: " + profiles.getUser(usernum));
					labels[5][3].setText("User is logged in: " + profiles.getUser(usernum));
					labels[8][3].setText("User is logged in: " + profiles.getUser(usernum));
					for (int i = 0; i < 7; i++)
					{
						if (textBoxes[3][i] != null)
						{
							textBoxes[3][i].setText("");
						}
					}
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
				for (int i = 0; i < 7; i++)
				{
					if (textBoxes[3][i] != null)
					{
						textBoxes[3][i].setText("");
					}
				}
			}
		});
		loginBottomPanel.add(buttons[3][1]);
		buttons[3][2] = new JButton("FAQ");
		buttons[3][2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(7);
				for (int i = 0; i < 7; i++)
				{
					if (textBoxes[3][i] != null)
					{
						textBoxes[3][i].setText("");
					}
				}
			}
		});
		loginBottomPanel.add(buttons[3][2]);
		pages[3].add(loginBottomPanel, BorderLayout.SOUTH);
	}

	/**
	Set up the REPORT PAGE
	*/

	public void setReportPage()
	{
		ReportManager reportManager = new ReportManager(); 
		pages[4].setLayout(new BorderLayout(0,0));

		JPanel addressPanel = new JPanel(new GridLayout(4,1,2,0));
		labels[4][0] = new JLabel("Address:");
		addressPanel.add(labels[4][0]);
		addressPanel.add(textBoxes[4][0]);
		pages[4].add(addressPanel, BorderLayout.NORTH);

		JPanel problemsPanel = new JPanel(new GridLayout(5,2,10,0));
		radioButtons[4][0] = new JRadioButton("Utility Failiures");
		radioButtons[4][1] = new JRadioButton("Tree Collapse");
		radioButtons[4][2] = new JRadioButton("Potholes");
		radioButtons[4][3] = new JRadioButton("Flooded Streets");
		radioButtons[4][4] = new JRadioButton("City Property Vandalism");
		radioButtons[4][5] = new JRadioButton("Mould and Spore Growth");
		radioButtons[4][6] = new JRadioButton("Eroded Streets");
		radioButtons[4][7] = new JRadioButton("Garbage or any Other Road Blocking Objects");
		for (int i = 0; i < 8; i++)
		{
			buttonGroups[4].add(radioButtons[4][i]);
			problemsPanel.add(radioButtons[4][i]);
		}
		labels[4][1] = new JLabel("No report submitted");
		problemsPanel.add(labels[4][1]);
		pages[4].add(problemsPanel, BorderLayout.CENTER);

		JPanel reportBottomPanel = new JPanel(new GridLayout(1,3,5,0));
		buttons[4][0] = new JButton("Report");
		buttons[4][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (reportManager.save_Report(textBoxes[4][0].getText(), getRadioButtonData()[4]))
				{
					buttonGroups[4].clearSelection();
					textBoxes[4][0].setText("");
					labels[4][1].setText("Report was successfully submitted");
				}
			}
		});
		reportBottomPanel.add(buttons[4][0]);
		buttons[4][1] = new JButton("Cancel");
		buttons[4][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				buttonGroups[4].clearSelection();
				setPage(1);
			}
		});
		reportBottomPanel.add(buttons[4][1]);
		buttons[4][2] = new JButton("FAQ");
		buttons[4][2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(7);
			}
		});
		reportBottomPanel.add(buttons[4][2]);
		pages[4].add(reportBottomPanel, BorderLayout.SOUTH);
	}

	/**
	Set up the CHANGE INFO PAGE
	*/

	public void setChangeInfoPage()
	{
		pages[5].setLayout(new BorderLayout(0,0));
		JPanel changeinfoScreen = new JPanel(new GridLayout(4,2,10,10));
		labels[5][0] = new JLabel("Username:");
		labels[5][1] = new JLabel("Mother's Maiden Name:");
		labels[5][2] = new JLabel("New Password:");
		textBoxes[5][2] = new JPasswordField();
		for (int i = 0; i < 3; i++)
		{
			changeinfoScreen.add(labels[5][i]);
			changeinfoScreen.add(textBoxes[5][i]);
		}
		labels[5][3] = new JLabel();
		if (usernum > -1)
		{
			labels[5][3].setText("User is logged in: " + profiles.getUser(usernum));
		}
		else
		{

			labels[5][3].setText("No user logged in");
		}
		changeinfoScreen.add(labels[5][3]);
		pages[5].add(changeinfoScreen, BorderLayout.CENTER);

		JPanel chgBottomPanel = new JPanel(new GridLayout(1,4,3,0));
		buttons[5][0] = new JButton("Change Password");
		buttons[5][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!profiles.change_pass(profiles.answer_is_correct(textBoxes[5][0].getText(), textBoxes[5][1].getText()), textBoxes[5][2].getText()))
				{
					labels[5][3].setText("Username and answer do not match. Please try again.");
				}
				else
				{
					labels[5][3].setText("User password was successfully updated.");
					for (int i = 0; i < 7; i++)
					{
						if (textBoxes[5][i] != null)
						{
							textBoxes[5][i].setText("");
						}
					}
				}
			}
		});
		chgBottomPanel.add(buttons[5][0]);
		buttons[5][1] = new JButton("Cancel");
		buttons[5][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for (int i = 0; i < 7; i++)
				{
					if (textBoxes[5][i] != null)
					{
						textBoxes[5][i].setText("");
					}
				}
				setPage(1);
			}
		});
		chgBottomPanel.add(buttons[5][1]);
		buttons[5][2] = new JButton("FAQ");
		buttons[5][2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(7);
				for (int i = 0; i < 7; i++)
				{
					if (textBoxes[5][i] != null)
					{
						textBoxes[5][i].setText("");
					}
				}
			}
		});
		chgBottomPanel.add(buttons[5][2]);

		pages[5].add(chgBottomPanel, BorderLayout.SOUTH);
	}

	/**
	Set up the FAQ PAGE
	*/

	public void setFAQPage()
	{
		pages[7].setLayout(new GridLayout(10, 1, 0, 0));
		String[][] faq = quesAns.retrieveFAQ();
		int skip = 0;
		for (int i = 0; i < faq[0].length; i++)
		{
			if (faq[0][i] != null)
			{
				labels[7][i+skip].setText(faq[0][i]);
				labels[7][i+skip].setFont(new Font("Arial", Font.BOLD, 15));
				labels[7][i+skip+1].setText(faq[1][i]);
				pages[7].add(labels[7][i+skip]);
				pages[7].add(labels[7][i+skip+1]);
				skip++;
			}
		}
		buttons[7][0] = new JButton("Back");
		buttons[7][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(1);
			}
		});
		pages[7].add(buttons[7][0]);
	}

	/**
	Set up the LOGOUT PAGE
	*/

	public void setLogoutPage()
	{
		pages[8].setLayout(new BorderLayout(0,0));
		labels[8][3] = new JLabel();
		if (usernum > -1)
		{
			labels[8][3].setText("User is logged in: " + profiles.getUser(usernum));
		}
		else
		{
			labels[8][3].setText("No user logged in");
		}
		pages[8].add(labels[8][3], BorderLayout.CENTER);

		JPanel logoutBottomPanel = new JPanel(new GridLayout(1,4,3,0));
		buttons[8][0] = new JButton("Logout");
		buttons[8][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (usernum > -1)
				{
					usernum = -1;
					labels[8][3].setText("User was successfully logged out");
					labels[3][3].setText("No user logged in");
					labels[2][7].setText("No user logged in");
				}
			}
		});
		logoutBottomPanel.add(buttons[8][0]);
		buttons[8][1] = new JButton("Cancel");
		buttons[8][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(1);
			}
		});
		logoutBottomPanel.add(buttons[8][1]);
		buttons[8][2] = new JButton("FAQ");
		buttons[8][2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPage(7);
				for (int i = 0; i < 7; i++)
				{
					if (textBoxes[8][i] != null)
					{
						textBoxes[8][i].setText("");
					}
				}
			}
		});
		logoutBottomPanel.add(buttons[8][2]);

		pages[8].add(logoutBottomPanel, BorderLayout.SOUTH);
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
		frame.setVisible(true);
	}
	public boolean[][] getRadioButtonData()
	{
		boolean[][] output = new boolean[pages.length][8];
		for (int i = 0; i < pages.length; i++)
		{
			for (int j = 0; j < output[i].length; j++)
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
	public String[][] getTextFieldData()
	{
		String[][] output = new String[pages.length][7];
		for (int i = 0; i < pages.length; i++)
		{
			for (int j = 0; j < output[i].length; j++)
			{
				output[i][j] = "";
				if (textBoxes[i][j] != null)
				{
					output[i][j] = textBoxes[i][j].getText();
				}
			}
		}
		return output;
	}
	public static void main(String[] args)
	{
		GUI gui = new GUI();
	}
}