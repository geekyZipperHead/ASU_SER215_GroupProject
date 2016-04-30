package groupProject_TeamB11;

	public class ConnectFourBoard {
	    //creating array variable for the game board and game play variables
	    private static int[][] gameGrid;  
		private static boolean isWin = false;
	    private final static int computerPlayer = 2, humanPlayer=1, emptySpace=0;  
	    //keeping track of number of pieces played to easily determine a draw
	    private static int cellsNotUsed;
	    
	    public ConnectFourBoard() {
	        //initialize the array, set each element = 0 for empty space
	    	gameGrid = new int[6][7];	
	    	cellsNotUsed=0;
	    	isWin=false;
	        for (int iRow = 0; iRow < 6; iRow ++){ 
	            for (int iCol = 0; iCol < 7; iCol++){ 
	                gameGrid[iRow][iCol] = emptySpace; 
	                cellsNotUsed++;
	            }                 
	        } 
	        
	    }
	    //method to assign next player turn
	    public int nextTurn(int iCurUser) {
	    	iCurUser++;
	        if (iCurUser > 2) {
	            return 1;
	        }
	        return iCurUser;
	    }

	    //method to set the players current move to an element
	    public boolean setGameGrid(int row, int col, int curPlayer) {
	    	boolean bWin = false;
	    	gameGrid[row][col] = curPlayer;
	    	cellsNotUsed--;
	    	
	    	//don't do the win check if at least 8 pieces have been played
	    	if(42-cellsNotUsed>7){
	    		bWin=calculateWin();
	    	}
	    	return bWin;
	    }
	    //method to set the players current move to an element
	    public int[][] getGameGrid() {
	    	
	    	return gameGrid;
	    }
	    
	    //finds first space available within passed in column
	    public int findSpace(int col) {
	        int returnRow = -1;
	        for (int curRow = 0; curRow <6; curRow++) 
	        {
	            if (gameGrid[curRow][col] == 0) 
	            {
	            	returnRow = curRow;
	            }
	        }
	        return returnRow;
	    }

	    //method to check for a draw, just looks at counter variable from the setGameGrid method
	     public boolean calculateDraw(){
	         return cellsNotUsed == 0;
	     }   
	    
	     //method to check for a win on the game board
	    public boolean calculateWin(){    
	        // check for a horizontal win on the game board 
	        for (int iRow=0; iRow<6; iRow++) { 
	            for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] != emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3]) { 
	                              isWin = true; 
	                } 
	            } 
	        } 
	        // check for a vertical win on the game board 
	        for (int iRow=0; iRow<3; iRow++) { 
	            for (int iCol=0;iCol<7; iCol++) { 
	                if (gameGrid[iRow][iCol] != emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol]) { 
	                              isWin = true; 
	                } 
	            } 
	        } 
	        // check for a diagonal win (descending diagonal) 
	        for (int iRow=0; iRow<3; iRow++) { 
	            for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] != emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3]) { 
	                              isWin = true; 
	                } 
	            } 
	        } 
	        // check for a diagonal win (ascending diagonal) 
	        for (int iRow=3; iRow<6; iRow++) { 
	            for (int iCol=0; iCol<4; iCol++) { 
	            if (gameGrid[iRow][iCol] != emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3]) { 
	               isWin = true; 
	                } 
	            } 
	        }     
	          
	        return isWin; 
	    } 
	  
	    //method to put some logic behind computer based moves
	    //little buggy yet, working out kinks.
	    public int[] computerAI(){       
	  
	        int[] iComputerMove = new int[2]; 
	        
	//This code block will check for computer possible winning moves first 
	//before trying to block the other.  Wins take priority 
	        
	        // check for a horizontal 3 in a row 
	        //or a pattern of "x_xx" or "xx_x" 
	        for (int iRow=5; iRow>=5; iRow--) { 
	           for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
	                gameGrid[iRow][iCol+3] == emptySpace) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol+3; 
	                              return iComputerMove; 
	                } 

	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol+1] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3]) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol+1; 
	                              return iComputerMove; 
	                }               
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
	                gameGrid[iRow][iCol+2] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3]) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol+2; 
	                              return iComputerMove; 
	                }                 
	            } 
	           for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-2] && 
	                gameGrid[iRow][iCol-3] == emptySpace) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol-3; 
	                              return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol-1] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-3]) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol-1; 
	                              return iComputerMove; 
	                }               
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] && 
	                gameGrid[iRow][iCol-2] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-3]) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol-2; 
	                              return iComputerMove; 
	                }                 
	            }           
	        } 
	        for (int iRow=4; iRow>=0; iRow--) { 
		           for (int iCol=0; iCol<4; iCol++) { 
		                if (gameGrid[iRow][iCol] == computerPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
		                gameGrid[iRow][iCol+3] == emptySpace &&
		                gameGrid[iRow+1][iCol+3] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol+3; 
		                              return iComputerMove; 
		                } 

		                if (gameGrid[iRow][iCol] == computerPlayer && 
		                gameGrid[iRow][iCol+1] == emptySpace && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3] &&
		                gameGrid[iRow+1][iCol+1] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol+1; 
		                              return iComputerMove; 
		                }               
		                if (gameGrid[iRow][iCol] == computerPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
		                gameGrid[iRow][iCol+2] == emptySpace && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3] &&
				        gameGrid[iRow+1][iCol+2] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol+2; 
		                              return iComputerMove; 
		                }                 
		            } 
		           for (int iCol=6; iCol>2; iCol--) { 
		                if (gameGrid[iRow][iCol] == computerPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-2] && 
		                gameGrid[iRow][iCol-3] == emptySpace &&
				        gameGrid[iRow+1][iCol-3] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol-3; 
		                              return iComputerMove; 
		                } 
		                
		                if (gameGrid[iRow][iCol] == computerPlayer && 
		                gameGrid[iRow][iCol-1] == emptySpace && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-2] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-3] &&
						gameGrid[iRow+1][iCol-1] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol-1; 
		                              return iComputerMove; 
		                }               
		                if (gameGrid[iRow][iCol] == computerPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] && 
		                gameGrid[iRow][iCol-2] == emptySpace && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-3] &&
						gameGrid[iRow+1][iCol-2] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol-2; 
		                              return iComputerMove; 
		                }                 
		            }           
		        }
	        
	        
	        // check for a vertical 3 in a row 
	        for (int iRow=5; iRow>2; iRow--) { 
	            for (int iCol=0;iCol<7; iCol++) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol] && 
	                gameGrid[iRow-3][iCol]==emptySpace) { 
	                              iComputerMove[0] = iRow-3; 
	                              iComputerMove[1] = iCol; 
	                              return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow-1][iCol] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol]) { 
	                      iComputerMove[0] = iRow-1; 
	                      iComputerMove[1] = iCol; 
	                      return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol] && 
	                gameGrid[iRow-2][iCol] == emptySpace &&
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol]) { 
	                      iComputerMove[0] = iRow-2; 
	                      iComputerMove[1] = iCol; 
	                      return iComputerMove; 
	                }                 
	            }         
	        } 
	        
	        // check for a diagonal  3 in a row (descending diagonal) 
	        for (int iRow=0; iRow<3; iRow++) { 
	            if(iRow!=2){ 
	                for (int iCol=0; iCol<4; iCol++) { 
	                    if (gameGrid[iRow][iCol] ==computerPlayer && 
			                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
			                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
			                    gameGrid[iRow+3][iCol+3]==emptySpace && gameGrid[iRow+4][iCol+3]!=emptySpace) { 
	                                  iComputerMove[0] = iRow+3; 
	                                  iComputerMove[1] = iCol+3; 
	                                  return iComputerMove; 
	                    }

	                    if (gameGrid[iRow][iCol] ==computerPlayer && 
			                    gameGrid[iRow+1][iCol+1] == emptySpace && 
			                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
			                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && gameGrid[iRow+2][iCol+1]!=emptySpace) { 
		                              iComputerMove[0] = iRow+1; 
		                              iComputerMove[1] = iCol+1; 
		                              return iComputerMove; 
	                    }                   
	                    
	                    if (gameGrid[iRow][iCol] ==computerPlayer && 
	                            gameGrid[iRow+1][iCol+1] == gameGrid[iRow+1][iCol+1] && 
	                            gameGrid[iRow+2][iCol+2] == emptySpace && 
	                            gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && gameGrid[iRow+3][iCol+2]!=emptySpace) { 
			                          iComputerMove[0] = iRow+2; 
			                          iComputerMove[1] = iCol+2; 
			                          return iComputerMove; 
	                    }        
	                } 

	            for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
		                gameGrid[iRow+3][iCol-3]==emptySpace && gameGrid[iRow+4][iCol-3]!=emptySpace) { 
	                          iComputerMove[0] = iRow+3; 
	                          iComputerMove[1] = iCol-3; 
	                          return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                    gameGrid[iRow+1][iCol-1] == emptySpace && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol-3] && gameGrid[iRow+2][iCol-1]!=emptySpace) { 
	                          iComputerMove[0] = iRow+1; 
	                          iComputerMove[1] = iCol-1; 
	                          return iComputerMove; 
	                } 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	    	            gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
	                    gameGrid[iRow+2][iCol-2] == emptySpace && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol-3] && gameGrid[iRow+2][iCol-1]!=emptySpace) { 
	                          iComputerMove[0] = iRow+2; 
	                          iComputerMove[1] = iCol-2; 
	                          return iComputerMove; 
	                }                
	                
	            }                 
	            } 
	            else if (iRow==2){ 
	                for (int iCol=0; iCol<4; iCol++) { 
	                    if (gameGrid[iRow][iCol] ==computerPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
	                    gameGrid[iRow+3][iCol+3]==emptySpace) { 
	                                  iComputerMove[0] = iRow+3; 
	                                  iComputerMove[1] = iCol+3; 
	                                  return iComputerMove; 
	                    } 
	                    
	                    if (gameGrid[iRow][iCol] ==computerPlayer && 
	                    gameGrid[iRow+1][iCol+1] == emptySpace && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && 
	    	    	    gameGrid[iRow+2][iCol+1]!=emptySpace) { 
	                                  iComputerMove[0] = iRow+1; 
	                                  iComputerMove[1] = iCol+1; 
	                                  return iComputerMove; 
	                    } 
	                    
	                    if (gameGrid[iRow][iCol] ==computerPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
	                    gameGrid[iRow+2][iCol+2] == emptySpace && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && 
	    	    	    gameGrid[iRow+3][iCol+2]!=emptySpace) { 
	                                  iComputerMove[0] = iRow+2; 
	                                  iComputerMove[1] = iCol+2; 
	                                  return iComputerMove; 
	                    }                                         
	                }
	                
		            for (int iCol=6; iCol>2; iCol--) { 
		                if (gameGrid[iRow][iCol] ==computerPlayer && 
			                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
			                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
			                gameGrid[iRow+3][iCol-3]==emptySpace) { 
		                          iComputerMove[0] = iRow+3; 
		                          iComputerMove[1] = iCol-3; 
		                          return iComputerMove; 
		                } 
		                
		                if (gameGrid[iRow][iCol] ==computerPlayer && 
		                    gameGrid[iRow+1][iCol-1] == emptySpace && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol-3] && gameGrid[iRow+2][iCol-1]!=emptySpace) { 
		                          iComputerMove[0] = iRow+1; 
		                          iComputerMove[1] = iCol-1; 
		                          return iComputerMove; 
		                } 
		                if (gameGrid[iRow][iCol] ==computerPlayer && 
		    	            gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
		                    gameGrid[iRow+2][iCol-2] == emptySpace && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol-3] && gameGrid[iRow+2][iCol-1]!=emptySpace) { 
		                          iComputerMove[0] = iRow+2; 
		                          iComputerMove[1] = iCol-2; 
		                          return iComputerMove; 
		                }     
		            }        
	            } 
	        } 
	        
	        // check for a diagonal  3 in a row (ascending diagonal) 
	        for (int iRow=3; iRow<6; iRow++) { 
	            for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] && 
	                    gameGrid[iRow-3][iCol+3]==emptySpace && gameGrid[iRow-2][iCol+3]!=emptySpace) { 
	                   iComputerMove[0] = iRow-3; 
	                   iComputerMove[1] = iCol+3; 
	                   return iComputerMove; 
	                }                           

	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                        gameGrid[iRow-1][iCol+1] ==emptySpace && 
	                        gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] && 
	                        gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3] && gameGrid[iRow][iCol+1]!=emptySpace) { 
	                       iComputerMove[0] = iRow-1; 
	                       iComputerMove[1] = iCol+1; 
	                       return iComputerMove; 
	                }
	                
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                        gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] && 
	                        gameGrid[iRow-2][iCol+2] == emptySpace && 
	                        gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3] && gameGrid[iRow-1][iCol+2]!=emptySpace) { 
	                       iComputerMove[0] = iRow-2; 
	                       iComputerMove[1] = iCol+2; 
	                       return iComputerMove; 
	                }                     
	            } 
	            
	            for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol-1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol-2] && 
	                gameGrid[iRow-3][iCol-3]==emptySpace && gameGrid[iRow-2][iCol-3]!=emptySpace) { 
	                              iComputerMove[0] = iRow-3; 
	                              iComputerMove[1] = iCol-3; 
	                              return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                gameGrid[iRow-1][iCol-1]  == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol-2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol-3] && gameGrid[iRow][iCol-1]!=emptySpace) { 
	                              iComputerMove[0] = iRow-1; 
	                              iComputerMove[1] = iCol-1; 
	                              return iComputerMove; 
	                }                 
	                
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol-1] && 
	                gameGrid[iRow-2][iCol-2] ==emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol-3] && gameGrid[iRow-1][iCol-2]!=emptySpace) { 
	                              iComputerMove[0] = iRow-2; 
	                              iComputerMove[1] = iCol-2; 
	                              return iComputerMove; 
	                }                    
	            }   
	        } 
	        
	//This ends the cpu win check and begins to look at the human player 
	//possible moves to block 
	        // check for a horizontal 3 in a row 
	        //or a pattern of "x_xx" or "xx_x" 
	        for (int iRow=5; iRow>=5; iRow--) { 
	           for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] == humanPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
	                gameGrid[iRow][iCol+3] == emptySpace) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol+3; 
	                              return iComputerMove; 
	                } 

	                if (gameGrid[iRow][iCol] == humanPlayer && 
	                gameGrid[iRow][iCol+1] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3]) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol+1; 
	                              return iComputerMove; 
	                }               
	                if (gameGrid[iRow][iCol] == humanPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
	                gameGrid[iRow][iCol+2] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3]) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol+2; 
	                              return iComputerMove; 
	                }                 
	            } 
	           
	           for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] == humanPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-2] && 
	                gameGrid[iRow][iCol-3] == emptySpace) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol-3; 
	                              return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] == humanPlayer && 
	                gameGrid[iRow][iCol-1] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-3]) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol-1; 
	                              return iComputerMove; 
	                }               
	                if (gameGrid[iRow][iCol] == humanPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] && 
	                gameGrid[iRow][iCol-2] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-3]) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol-2; 
	                              return iComputerMove; 
	                }                 
	            }           
	        } 
	        for (int iRow=4; iRow>=0; iRow--) { 
		           for (int iCol=0; iCol<4; iCol++) { 
		                if (gameGrid[iRow][iCol] == humanPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
		                gameGrid[iRow][iCol+3] == emptySpace && 
				        gameGrid[iRow+1][iCol+3] != emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol+3; 
		                              return iComputerMove; 
		                } 

		                if (gameGrid[iRow][iCol] == humanPlayer && 
		                gameGrid[iRow][iCol+1] == emptySpace && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3] && 
						gameGrid[iRow+1][iCol+1] != emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol+1; 
		                              return iComputerMove; 
		                }               
		                if (gameGrid[iRow][iCol] == humanPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] && 
		                gameGrid[iRow][iCol+2] == emptySpace && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3] && 
						gameGrid[iRow+2][iCol+2] != emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol+2; 
		                              return iComputerMove; 
		                }                 
		            } 
		           
		           for (int iCol=6; iCol>2; iCol--) { 
		                if (gameGrid[iRow][iCol] == humanPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-2] && 
		                gameGrid[iRow][iCol-3] == emptySpace && 
						gameGrid[iRow+1][iCol-3] != emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol-3; 
		                              return iComputerMove; 
		                } 
		                
		                if (gameGrid[iRow][iCol] == humanPlayer && 
		                gameGrid[iRow][iCol-1] == emptySpace && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-2] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-3] && 
						gameGrid[iRow+1][iCol-1] != emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol-1; 
		                              return iComputerMove; 
		                }               
		                if (gameGrid[iRow][iCol] == humanPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] && 
		                gameGrid[iRow][iCol-2] == emptySpace && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-3] && 
						gameGrid[iRow+1][iCol-2] != emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol-2; 
		                              return iComputerMove; 
		                }                 
		            }           
		        } 	        
	        // check for a vertical 3 in a row 
	        for (int iRow=5; iRow>2; iRow--) { 
	            for (int iCol=0;iCol<7; iCol++) { 
	                if (gameGrid[iRow][iCol] ==humanPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol] && 
	                gameGrid[iRow-3][iCol]==emptySpace) { 
	                              iComputerMove[0] = iRow-3; 
	                              iComputerMove[1] = iCol; 
	                              return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] == humanPlayer && 
	                gameGrid[iRow-1][iCol] == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol]) { 
	                      iComputerMove[0] = iRow-1; 
	                      iComputerMove[1] = iCol; 
	                      return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] == humanPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol] && 
	                gameGrid[iRow-2][iCol] == emptySpace &&
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol]) { 
	                      iComputerMove[0] = iRow-2; 
	                      iComputerMove[1] = iCol; 
	                      return iComputerMove; 
	                }                 
	            }         
	        } 
	        
	        // check for a diagonal  3 in a row (descending diagonal) 
	        for (int iRow=0; iRow<3; iRow++) { 
	            if(iRow!=2){ 
	                for (int iCol=0; iCol<4; iCol++) { 
	                    if (gameGrid[iRow][iCol] ==humanPlayer && 
			                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
			                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
			                    gameGrid[iRow+3][iCol+3]==emptySpace && 
			                    gameGrid[iRow+4][iCol+3]!=emptySpace) { 
	                                  iComputerMove[0] = iRow+3; 
	                                  iComputerMove[1] = iCol+3; 
	                                  return iComputerMove; 
	                    }

	                    if (gameGrid[iRow][iCol] ==humanPlayer && 
			                    gameGrid[iRow+1][iCol+1] == emptySpace && 
			                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
			                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && 
			                    gameGrid[iRow+2][iCol+1]!=emptySpace) { 
		                              iComputerMove[0] = iRow+1; 
		                              iComputerMove[1] = iCol+1; 
		                              return iComputerMove; 
	                    }                   
	                    
	                    if (gameGrid[iRow][iCol] ==humanPlayer && 
	                            gameGrid[iRow+1][iCol+1] == gameGrid[iRow+1][iCol+1] && 
	                            gameGrid[iRow+2][iCol+2] == emptySpace && 
	                            gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && 
	                            gameGrid[iRow+3][iCol+2]!=emptySpace) { 
			                          iComputerMove[0] = iRow+2; 
			                          iComputerMove[1] = iCol+2; 
			                          return iComputerMove; 
	                    }        
	                } 

		            for (int iCol=6; iCol>2; iCol--) { 
		                if (gameGrid[iRow][iCol] ==humanPlayer && 
			                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
			                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
			                gameGrid[iRow+3][iCol-3]==emptySpace && 
			                gameGrid[iRow+4][iCol-3]!=emptySpace) { 
		                          iComputerMove[0] = iRow+3; 
		                          iComputerMove[1] = iCol-3; 
		                          return iComputerMove; 
		                } 
		                
		                if (gameGrid[iRow][iCol] ==humanPlayer && 
		                    gameGrid[iRow+1][iCol-1] == emptySpace && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol-3] && 
		                    gameGrid[iRow+2][iCol-1]!=emptySpace) { 
		                          iComputerMove[0] = iRow+1; 
		                          iComputerMove[1] = iCol-1; 
		                          return iComputerMove; 
		                } 
		                if (gameGrid[iRow][iCol] ==humanPlayer && 
		    	            gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
		                    gameGrid[iRow+2][iCol-2] == emptySpace && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol-3] && 
		                    gameGrid[iRow+2][iCol-1]!=emptySpace) { 
		                          iComputerMove[0] = iRow+2; 
		                          iComputerMove[1] = iCol-2; 
		                          return iComputerMove; 
		                }     
		            }                 
	            } 
	            else if (iRow==2){ 
	                for (int iCol=0; iCol<4; iCol++) { 
	                    if (gameGrid[iRow][iCol] ==humanPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
	                    gameGrid[iRow+3][iCol+3]==emptySpace) { 
	                                  iComputerMove[0] = iRow+3; 
	                                  iComputerMove[1] = iCol+3; 
	                                  return iComputerMove; 
	                    } 
	                    
	                    if (gameGrid[iRow][iCol] ==humanPlayer && 
	                    gameGrid[iRow+1][iCol+1] == emptySpace && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && 
	    			    gameGrid[iRow+2][iCol+1]!=emptySpace) { 
	                                  iComputerMove[0] = iRow+1; 
	                                  iComputerMove[1] = iCol+1; 
	                                  return iComputerMove; 
	                    } 
	                    
	                    if (gameGrid[iRow][iCol] ==humanPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
	                    gameGrid[iRow+2][iCol+2] == emptySpace && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && 
	    	    	    gameGrid[iRow+3][iCol+2]!=emptySpace) { 
	                                  iComputerMove[0] = iRow+2; 
	                                  iComputerMove[1] = iCol+2; 
	                                  return iComputerMove; 
	                    }                  
	                }
	             
		            for (int iCol=6; iCol>2; iCol--) { 
		                if (gameGrid[iRow][iCol] ==humanPlayer && 
			                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
			                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
			                gameGrid[iRow+3][iCol-3]==emptySpace) { 
		                          iComputerMove[0] = iRow+3; 
		                          iComputerMove[1] = iCol-3; 
		                          return iComputerMove; 
		                } 
		                
		                if (gameGrid[iRow][iCol] ==humanPlayer && 
		                    gameGrid[iRow+1][iCol-1] == emptySpace && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol-3] && gameGrid[iRow+2][iCol-1]!=emptySpace) { 
		                          iComputerMove[0] = iRow+1; 
		                          iComputerMove[1] = iCol-1; 
		                          return iComputerMove; 
		                } 
		                if (gameGrid[iRow][iCol] ==humanPlayer && 
		    	            gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
		                    gameGrid[iRow+2][iCol-2] == emptySpace && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol-3] && gameGrid[iRow+2][iCol-1]!=emptySpace) { 
		                          iComputerMove[0] = iRow+2; 
		                          iComputerMove[1] = iCol-2; 
		                          return iComputerMove; 
		                }     
		            }  
		            
	            } 
	        } 
	        
	        // check for a diagonal  3 in a row (ascending diagonal) 
	        for (int iRow=3; iRow<6; iRow++) { 
	            for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] ==humanPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] && 
	                    gameGrid[iRow-3][iCol+3]==emptySpace && 
	                    gameGrid[iRow-2][iCol+3]!=emptySpace) { 
	                   iComputerMove[0] = iRow-3; 
	                   iComputerMove[1] = iCol+3; 
	                   return iComputerMove; 
	                }                           

	                if (gameGrid[iRow][iCol] ==humanPlayer && 
	                        gameGrid[iRow-1][iCol+1] ==emptySpace && 
	                        gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] && 
	                        gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3] && 
	                        gameGrid[iRow][iCol+1]!=emptySpace) { 
	                       iComputerMove[0] = iRow-1; 
	                       iComputerMove[1] = iCol+1; 
	                       return iComputerMove; 
	                }
	                
	                if (gameGrid[iRow][iCol] ==humanPlayer && 
	                        gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] && 
	                        gameGrid[iRow-2][iCol+2] == emptySpace && 
	                        gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3] && 
	                        gameGrid[iRow-1][iCol+2]!=emptySpace) { 
	                       iComputerMove[0] = iRow-2; 
	                       iComputerMove[1] = iCol+2; 
	                       return iComputerMove; 
	                }                     
	            } 
	            
	            for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] ==humanPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol-1] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol-2] && 
	                gameGrid[iRow-3][iCol-3]==emptySpace && 
	                gameGrid[iRow-2][iCol-3]!=emptySpace) { 
	                              iComputerMove[0] = iRow-3; 
	                              iComputerMove[1] = iCol-3; 
	                              return iComputerMove; 
	                } 
	                
	                if (gameGrid[iRow][iCol] ==humanPlayer && 
	                gameGrid[iRow-1][iCol-1]  == emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol-2] && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol-3] &&
	                gameGrid[iRow][iCol-1]!=emptySpace) { 
	                              iComputerMove[0] = iRow-1; 
	                              iComputerMove[1] = iCol-1; 
	                              return iComputerMove; 
	                }                 
	                
	                if (gameGrid[iRow][iCol] ==humanPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol-1] && 
	                gameGrid[iRow-2][iCol-2] ==emptySpace && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol-3] && 
	                gameGrid[iRow-1][iCol-2]!=emptySpace) { 
	                              iComputerMove[0] = iRow-2; 
	                              iComputerMove[1] = iCol-2; 
	                              return iComputerMove; 
	                }                    
	            }   
	        } 
	        
	        //If no blocking moves found, begin offensive checks 
	        
	        // check for a horizontal 2 in a row 
	        for (int iRow=5; iRow>=5; iRow--) { 
	           for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] &&                 
	                gameGrid[iRow][iCol+2] == emptySpace) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol+2; 
	                              return iComputerMove; 
	                } 
	            } 
	           for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] == computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] &&                 
	                gameGrid[iRow][iCol-2] == emptySpace) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol-2; 
	                              return iComputerMove; 
	                } 
	            }           
	        } 
	
	        for (int iRow=4; iRow>=0; iRow--) { 
		           for (int iCol=0; iCol<4; iCol++) { 
		                if (gameGrid[iRow][iCol] == computerPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] &&                 
		                gameGrid[iRow][iCol+2] == emptySpace &&
				        gameGrid[iRow+1][iCol+2] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol+2; 
		                              return iComputerMove; 
		                } 
		            } 
		           for (int iCol=6; iCol>2; iCol--) { 
		                if (gameGrid[iRow][iCol] == computerPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow][iCol-1] &&                 
		                gameGrid[iRow][iCol-2] == emptySpace &&
						gameGrid[iRow+1][iCol-2] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol-2; 
		                              return iComputerMove; 
		                } 
		            }           
		        } 	        
	        
	        // check for a vertical 2 in a row 
	        for (int iRow=5; iRow>2; iRow--) { 
	            for (int iCol=0;iCol<7; iCol++) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol] && 
	                gameGrid[iRow-2][iCol] ==emptySpace) { 
	                              iComputerMove[0] = iRow-2; 
	                              iComputerMove[1] = iCol; 
	                              return iComputerMove; 
	                } 
	            }         
	        } 
	        
	        // check for a diagonal  2 in a row (descending diagonal) 
	        for (int iRow=0; iRow<3; iRow++) { 
	            if(iRow!=2){ 
	            for (int iCol=0; iCol<4; iCol++) { 
	                    if (gameGrid[iRow][iCol] ==computerPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] &&                     
	                    gameGrid[iRow+2][iCol+2]==emptySpace && 
	                    gameGrid[iRow+3][iCol+2]!=emptySpace) { 
	                                  iComputerMove[0] = iRow+2; 
	                                  iComputerMove[1] = iCol+2; 
	                                  return iComputerMove; 
	                    } 
	                } 

	            for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] &&                 
	                gameGrid[iRow+2][iCol-2]==emptySpace && 
	                gameGrid[iRow+3][iCol-2]!=emptySpace) { 
	                              iComputerMove[0] = iRow+2; 
	                              iComputerMove[1] = iCol-2; 
	                              return iComputerMove; 
	                } 
	            }                 
	            } 
	            else if (iRow==2){ 
	                for (int iCol=0; iCol<4; iCol++) { 
	                    if (gameGrid[iRow][iCol] ==computerPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] &&                     
	                    gameGrid[iRow+2][iCol+2]==emptySpace && 
	    	    	    gameGrid[iRow+3][iCol+2]!=emptySpace) { 
	                                  iComputerMove[0] = iRow+2; 
	                                  iComputerMove[1] = iCol+2; 
	                                  return iComputerMove; 
	                    } 
	                } 
	            } 
	        } 
	        
	        // check for a diagonal  2 in a row (ascending diagonal) 
	        for (int iRow=3; iRow<6; iRow++) { 
	            for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                    gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] &&                     
	                    gameGrid[iRow-2][iCol+2]==emptySpace && 
	                    gameGrid[iRow-1][iCol+2]!=emptySpace) { 
	                   iComputerMove[0] = iRow-2; 
	                   iComputerMove[1] = iCol+2; 
	                   return iComputerMove; 
	                }                                     
	            } 
	            
	            for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer && 
	                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol-1] && 
	                gameGrid[iRow-2][iCol-2]==emptySpace && gameGrid[iRow-1][iCol-2]!=emptySpace) { 
	                              iComputerMove[0] = iRow-2; 
	                              iComputerMove[1] = iCol-2; 
	                              return iComputerMove; 
	                } 
	            }   
	        }         

	        // check for a horizontal 1 in a row 
	        for (int iRow=5; iRow>=5; iRow--) { 
	           for (int iCol=0; iCol<4; iCol++) { 
	                if (gameGrid[iRow][iCol] == computerPlayer &&                 
	                gameGrid[iRow][iCol+1] == emptySpace) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol+1; 
	                              return iComputerMove; 
	                } 
	            } 
	           for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] == computerPlayer &&                 
	                gameGrid[iRow][iCol-1] == emptySpace) {                           
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol-1; 
	                              return iComputerMove; 
	                } 
	            }           
	        } 
	        for (int iRow=4; iRow>=0; iRow--) { 
		           for (int iCol=0; iCol<4; iCol++) { 
		                if (gameGrid[iRow][iCol] == computerPlayer &&                 
		                gameGrid[iRow][iCol+1] == emptySpace &&
						gameGrid[iRow+1][iCol+1] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol+1; 
		                              return iComputerMove; 
		                } 
		            } 
		           for (int iCol=6; iCol>2; iCol--) { 
		                if (gameGrid[iRow][iCol] == computerPlayer &&                 
		                gameGrid[iRow][iCol-1] == emptySpace &&
						gameGrid[iRow+1][iCol-1] !=emptySpace) {                           
		                              iComputerMove[0] = iRow; 
		                              iComputerMove[1] = iCol-1; 
		                              return iComputerMove; 
		                } 
		            }           
		        } 	        
	        // check for a vertical 1 in a row (need to check vertical because a 
	        // a single row could be full and no horizontal moves available 
	        for (int iRow=5; iRow>2; iRow--) { 
	            for (int iCol=0;iCol<7; iCol++) { 
	                if (gameGrid[iRow][iCol] ==computerPlayer &&                 
	                gameGrid[iRow-1][iCol] ==emptySpace) { 
	                              iComputerMove[0] = iRow-1; 
	                              iComputerMove[1] = iCol; 
	                              return iComputerMove; 
	                } 
	            }         
	        } 
	      
	        
	        for (int iRow=5; iRow>=0; iRow--) { 
	            for (int iCol=0;iCol<7; iCol++) { 
	                if (gameGrid[iRow][iCol] == emptySpace){
	                              iComputerMove[0] = iRow; 
	                              iComputerMove[1] = iCol; 
	                              return iComputerMove; 
	                } 
	            }         
	        } 
	  
	        return iComputerMove; 
	    }
	}	
	

