package groupProject_TeamB11;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectFourGUI {

	//creating the GUI component variables
    private JFrame frame;
    private JLabel[][] gameSpaces;
    private JButton[] btnColSelect;
 
    //setting game play variables and declarations
    private int numCols = 7;
    private int numRows = 6;
    private int currentPlayer = 1;
    private int[] computerMove = new int[2];    
    private boolean isWin = false;
    private boolean isDraw = false;
    private boolean exitApp = false;
    private boolean newGame = false;
    //creating the image variables to be displayed with appropriate actions
    private ImageIcon emptySpace, humanPlayer, cpuPlayer;

    //creating the game board 
    ConnectFourBoard gameBoard = new ConnectFourBoard();

    public ConnectFourGUI() {
    	//assigning the images to the imageIcon variables from the images resource folder
        emptySpace = new ImageIcon(getClass().getResource("/images/connectFour_empty.png"));
        humanPlayer = new ImageIcon(getClass().getResource("/images/connectFour_red.png"));
        cpuPlayer = new ImageIcon(getClass().getResource("/images/connectFour_black.png"));
        
        //assigning the button color to be a light green, meaning it's a playable column        
    	Color btnColor = new Color(138, 255,165);

        frame = new JFrame("Connect Four - Team B11");
        JPanel panel = (JPanel) frame.getContentPane();
        //creating the panel window, allowing an extra row in the grid layout for the button controls
        panel.setLayout(new GridLayout(numCols, numRows + 1));

        //creating the label array
        gameSpaces = new JLabel[numRows][numCols];
        //creating the button control array
        btnColSelect = new JButton[numCols];

        //This loop does a lot of work.  First it will create a new button in the 
        //designated position.  Then it will add a listener to the button to perform
        //an action once the user clicks on a button.
        for (int i = 0; i < numCols; i++) {
            btnColSelect[i] = new JButton();
            btnColSelect[i].setLayout(new BorderLayout());
            JLabel label1 = new JLabel("DROP");
            JLabel label2 = new JLabel("Column: " + (i+1));

            btnColSelect[i].setActionCommand("" + i);
            btnColSelect[i].addActionListener(
                    new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                           
                        	int selectCol = Integer.parseInt(e.getActionCommand());
                        	//This will call the connectFourBoard class and try to find an available space in the
                        	//column the user wants to play a piece.
                            int returnRow = gameBoard.findSpace(selectCol);
                            if (returnRow != -1) 
                            {
                                if (currentPlayer ==1) 
                                {
                                    //sets the image icon to the corresponding game piece for the human player
                                    gameSpaces[returnRow][selectCol].setIcon(humanPlayer);
                                    
                                    //repaints the GUI immediately instead of waiting until the action event is over.  
                                    //wanted to spawn off a new thread to do the graphics repaint piece but had trouble so this 
                                    //was a workaround that seems to work without issues so far.                                    
                                    gameSpaces[returnRow][selectCol].paintImmediately(gameSpaces[returnRow][selectCol].getVisibleRect());
                                }
                                                                    
                                if (gameBoard.setGameGrid(returnRow,selectCol,currentPlayer)) 
                                {
                                	isWin = true;
                                } 
                                else if (gameBoard.calculateDraw()) 
                                {
                                	isDraw = true;
                                } 
                                else 
                                {
                                	//setting window title to next player turn and also disabling the column button if the column is full
                                    currentPlayer = gameBoard.nextTurn(currentPlayer);
                                    frame.setTitle("Connect Four - Team B11 - (Player " + currentPlayer + "'s Turn!)");
                                    if(gameBoard.findSpace(selectCol)==-1){
                                    	btnColSelect[selectCol].setEnabled(false);
                                    	btnColSelect[selectCol].setBackground(Color.LIGHT_GRAY);
                                    }
                                }

                            } 
                            else 
                            {
                                JOptionPane.showMessageDialog(null, "Try Again", "No Available Spaces!", JOptionPane.INFORMATION_MESSAGE);
                            }
                            
                            //this is the cpu move section
                            if (currentPlayer==2) {
                            	if(gameBoard.calculateDraw()==false){      
                            		
                            		try {
                            				// pauses the main thread for 400ms so the computer pauses before making it's play 
                            			   Thread.sleep(400L);                                  			 
                            			}
                            		catch (Exception e1) {} 
                            			 
                            		//fires off the logic within the ConnectFourBoard class to calculate a smart move for 
                            		//the computer to make.  
                                	computerMove = gameBoard.computerAI();       
                                	returnRow = computerMove[0];     
                                	//reusing the column variable from the player 1 section since it's within a local scope
                                	selectCol = computerMove[1];
                                	
                                	//setting the cpu image for the selected grid location 
                                    gameSpaces[returnRow][selectCol].setIcon(cpuPlayer);
                                
                                   
                                    if (gameBoard.setGameGrid(returnRow,selectCol,currentPlayer)) {
                                    	isWin = true;
                                    } else if (gameBoard.calculateDraw()) {
                                    	isDraw = true;
                                    } else {
                                    	//setting the window title to current players turn and disabling column button if full                                    	
                                        currentPlayer = gameBoard.nextTurn(currentPlayer);
                                        frame.setTitle("Connect Four - Team B11 - (Player " + currentPlayer + "'s Turn!)");
                                        if(gameBoard.findSpace(selectCol)==-1){
                                        	btnColSelect[selectCol].setEnabled(false);
                                        	btnColSelect[selectCol].setBackground(Color.LIGHT_GRAY);
                                        }
                                    }
                            	}
                            }
                            }
                        
                    });
            
            //setting the button and label text and font color properties
            btnColSelect[i].setBackground(btnColor);
            label1.setText("DROP");
            label2.setText("Column: " + (i+1));
            label1.setForeground(Color.BLACK);            
            label2.setForeground(Color.BLACK);                       
            btnColSelect[i].add(BorderLayout.NORTH,label1);
            btnColSelect[i].add(BorderLayout.SOUTH,label2);
            panel.add(btnColSelect[i]);
        }
      
        //loop to add the labels to the grid panel with the empty space image assigned
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
            	
                gameSpaces[row][column] = new JLabel(emptySpace);
                gameSpaces[row][column].setHorizontalAlignment(SwingConstants.CENTER);
                gameSpaces[row][column].setBorder(new LineBorder(Color.LIGHT_GRAY));
                panel.add( gameSpaces[row][column]);        
            }
        }

        //assigning the jframe properties and making the window not sizable
        frame.setContentPane(panel);
        frame.setSize(650, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    public void displayWin() 
    {
    	String sWin = "";
    	if(currentPlayer==1)
    	{
    		sWin = "Congratulations!  Player " + currentPlayer + " Wins!";

        }
        else if(currentPlayer==2)
        {
        	sWin = "Sorry, the Computer Wins This Time!";
        }
        int newGameMsgBox = JOptionPane.showConfirmDialog(frame,"Want to try again?",sWin,JOptionPane.YES_NO_OPTION);        
        if (newGameMsgBox < 1) 
        {
        	frame.dispose();           
        	newGame = true;
        } 
        else 
        {
            frame.dispose();
            exitApp = true;
        }
    }

    public void displayDraw() {
        String draw = "This game is a draw!";
        int newGameMsgBox = JOptionPane.showConfirmDialog(frame,"Want to play a new game?",draw,JOptionPane.YES_NO_OPTION);
        if (newGameMsgBox < 1) 
        {
            frame.dispose();
            newGame = true;
        } 
        else 
        {
            frame.dispose();
            exitApp = true;
        }
    }
    public boolean getNewGame() {
        return newGame;
    }
    public boolean getHasWon() {
        return isWin;
    }

    public boolean getHasDraw() {
        return isDraw;
    }

    public boolean getExit() {
        return exitApp;
    }


}
