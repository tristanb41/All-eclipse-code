import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGui extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TITLE="Tic Tac Toe";
	private static final int WIDTH=450;
	private static final int HEIGHT=600;
	
	private Container content;
	private JLabel result;
	private JButton[] cells;
	private JButton exitButton;
	private JButton initButton;
	private CellButtonHandler[] cellHandlers;
	private ExitButtonHandler exitHandler;
	private InitButtonHandler initHandler;
	
	private boolean noughts;
	private boolean gameOver;
	
	public TicTacToeGui()
	{
		//Necessary initialization code
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Get content pane
		content=getContentPane();
		content.setBackground(Color.blue.darker());
		
		//Set layout
		content.setLayout(new GridLayout(4,3));

		//Create cells and handlers
		cells=new JButton[9];
		cellHandlers=new CellButtonHandler[9];
		for(int i=0; i<9; i++)
		{
			char ch=(char)('0'+i+1);
			cells[i]=new JButton(""+ch);
			cellHandlers[i]=new CellButtonHandler();
			cells[i].addActionListener(cellHandlers[i]);
		}
		
		//Create init and exit buttons and handlers
		exitButton=new JButton("EXIT");
		exitHandler=new ExitButtonHandler();
		exitButton.addActionListener(exitHandler);
		initButton=new JButton("CLEAR");
		initHandler=new InitButtonHandler();
		initButton.addActionListener(initHandler);
		
		//Create result label
		result=new JLabel("Noughts", SwingConstants.CENTER);
		result.setForeground(Color.white);
						
		//Add elements to the grid content pane
		for(int i=0; i<9; i++)
		{
			content.add(cells[i]);
		}
		content.add(initButton);
		content.add(result);
		content.add(exitButton);
		
		//Initialize
		init();
	}
	
	public void init()
	{
		//Initialize booleans
		noughts=true;
		gameOver=false;
		
		//Initialize text in buttons
		for(int i=0; i<9; i++)
		{
			char ch=(char)('0'+i+1);
			cells[i].setText(""+ch);
		}
		
		//Initialize result label
		result.setText("Noughts");
		
		setVisible(true);
	}
	
	public boolean checkWinner()
	{
		if(cells[0].getText().equals(cells[1].getText()) && cells[1].getText().equals(cells[2].getText()))
		{
			return true;
		}
		else if(cells[3].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[5].getText()))
		{
			return true;
		}
		else if(cells[6].getText().equals(cells[7].getText()) && cells[7].getText().equals(cells[8].getText()))
		{
			return true;
		}
		else if(cells[0].getText().equals(cells[3].getText()) && cells[3].getText().equals(cells[6].getText()))
		{
			return true;
		}
		else if(cells[1].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[7].getText()))
		{
			return true;
		}
		else if(cells[2].getText().equals(cells[5].getText()) && cells[5].getText().equals(cells[8].getText()))
		{
			return true;
		}
		else if(cells[0].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[8].getText()))
		{
			return true;
		}
		else if(cells[2].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[6].getText()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		//Create TicTacToe object
		TicTacToeGui gui=new TicTacToeGui();
		
	}
	
	private class CellButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//If game over, ignore
			if(gameOver)
			{
				return;
			}
			
			//Get button pressed
			JButton pressed=(JButton)(e.getSource());
			
			//Get text of button
			String text=pressed.getText();
			
			//If noughts or crosses, ignore
			if(text.equals("O") || text.equals("X"))
			{
				return;
			}
			
			//Add nought or cross
			if(noughts)
			{
				pressed.setText("O");
			}
			else
			{
				pressed.setText("X");
			}
			
			//Check winner
			if(checkWinner())
			{
				//End of game
				gameOver=true;
				
				//Display winner message
				if(noughts)
				{
					result.setText("Noughts win!!");
				}
				else
				{
					result.setText("Crosses win!");
				}
			}
			else
			{
				//Change player
				noughts=!noughts;

				//Display player message
				if(noughts)
				{
					result.setText("Noughts");
				}
				else
				{
					result.setText("Crosses");
				}
			}
		}
	}
	
	private class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	private class InitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			init();
		}
	}
}