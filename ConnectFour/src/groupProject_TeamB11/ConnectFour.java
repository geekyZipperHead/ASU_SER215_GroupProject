package groupProject_TeamB11;
  
public class ConnectFour { 
    private static boolean isWin = false; 
    private static int[][] gameGrid = new int[6][7]; 
    private final static int computerPlayer = 0, humanPlayer=1, emptySpace=-1; 
    public static void main(String[] args) { 
    
        //initialize the array, set each element = -1 
        for (int iRow = 0; iRow < 6; iRow ++){ 
            for (int iCol = 0; iCol < 7; iCol++){ 
                gameGrid[iRow][iCol] = emptySpace; 
            }                 
        } 
        
        if(calculateWin()==true){ 
            System.out.println("You win!"); 
        } 
        else 
        { 
            int cRow = 0, cCol=0; 
            int[] computerMove = new int[2]; 
            computerMove = computerAI(); 
            cRow = computerMove[0]; 
            cCol= computerMove[1]; 
            System.out.println("Row:" + cRow + "  Column: " + cCol); 
        } 
    } 
     private static boolean calculateDraw(){
    	int cntUserPieces=0;
    	
        for (int iRow = 0; iRow < 6; iRow ++){ 
            for (int iCol = 0; iCol < 7; iCol++){ 
                if(gameGrid[iRow][iCol]!= emptySpace){
                	cntUserPieces+=1;
                }
            }                 
        }  
        if(cntUserPieces==42){
        	isDraw=true;
        }
    	return isDraw;
    }   
    private static boolean calculateWin(){       
  
        // check for a horizontal win on the game board 
        for (int iRow=0; iRow<6; iRow++) { 
            for (int iCol=0; iCol<4; iCol++) { 
                if (gameGrid[iRow][iCol] != -1 && 
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
                if (gameGrid[iRow][iCol] != -1 && 
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
                if (gameGrid[iRow][iCol] != -1 && 
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
            if (gameGrid[iRow][iCol] != -1 && 
                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] && 
                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] && 
                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3]) { 
               isWin = true; 
                } 
            } 
        }     
          
        return isWin; 
    } 
  
    private static int[] computerAI(){       
  
        int[] iComputerMove = new int[2]; 
        
//This block will check for computer possible winning moves first 
//before trying to block the other.  Wins take priority 
        
        // check for a horizontal 3 in a row 
        //or a pattern of "x_xx" or "xx_x" 
        for (int iRow=0; iRow<6; iRow++) { 
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
                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3]) { 
                                  iComputerMove[0] = iRow+1; 
                                  iComputerMove[1] = iCol+1; 
                                  return iComputerMove; 
                    } 
                    
                    if (gameGrid[iRow][iCol] ==computerPlayer && 
                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
                    gameGrid[iRow+2][iCol+2] == emptySpace && 
                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3]) { 
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
        for (int iRow=0; iRow<6; iRow++) { 
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
		                    gameGrid[iRow+3][iCol+3]==emptySpace && gameGrid[iRow+4][iCol+3]!=emptySpace) { 
                                  iComputerMove[0] = iRow+3; 
                                  iComputerMove[1] = iCol+3; 
                                  return iComputerMove; 
                    }

                    if (gameGrid[iRow][iCol] ==humanPlayer && 
		                    gameGrid[iRow+1][iCol+1] == emptySpace && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] && 
		                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && gameGrid[iRow+2][iCol+1]!=emptySpace) { 
	                              iComputerMove[0] = iRow+1; 
	                              iComputerMove[1] = iCol+1; 
	                              return iComputerMove; 
                    }                   
                    
                    if (gameGrid[iRow][iCol] ==humanPlayer && 
                            gameGrid[iRow+1][iCol+1] == gameGrid[iRow+1][iCol+1] && 
                            gameGrid[iRow+2][iCol+2] == emptySpace && 
                            gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3] && gameGrid[iRow+3][iCol+2]!=emptySpace) { 
		                          iComputerMove[0] = iRow+2; 
		                          iComputerMove[1] = iCol+2; 
		                          return iComputerMove; 
                    }        
                } 

	            for (int iCol=6; iCol>2; iCol--) { 
	                if (gameGrid[iRow][iCol] ==humanPlayer && 
		                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] && 
		                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol-2] && 
		                gameGrid[iRow+3][iCol-3]==emptySpace && gameGrid[iRow+4][iCol-3]!=emptySpace) { 
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
                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3]) { 
                                  iComputerMove[0] = iRow+1; 
                                  iComputerMove[1] = iCol+1; 
                                  return iComputerMove; 
                    } 
                    
                    if (gameGrid[iRow][iCol] ==humanPlayer && 
                    gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] && 
                    gameGrid[iRow+2][iCol+2] == emptySpace && 
                    gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3]) { 
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
                    gameGrid[iRow-3][iCol+3]==emptySpace && gameGrid[iRow-2][iCol+3]!=emptySpace) { 
                   iComputerMove[0] = iRow-3; 
                   iComputerMove[1] = iCol+3; 
                   return iComputerMove; 
                }                           

                if (gameGrid[iRow][iCol] ==humanPlayer && 
                        gameGrid[iRow-1][iCol+1] ==emptySpace && 
                        gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] && 
                        gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3] && gameGrid[iRow][iCol+1]!=emptySpace) { 
                       iComputerMove[0] = iRow-1; 
                       iComputerMove[1] = iCol+1; 
                       return iComputerMove; 
                }
                
                if (gameGrid[iRow][iCol] ==humanPlayer && 
                        gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] && 
                        gameGrid[iRow-2][iCol+2] == emptySpace && 
                        gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3] && gameGrid[iRow-1][iCol+2]!=emptySpace) { 
                       iComputerMove[0] = iRow-2; 
                       iComputerMove[1] = iCol+2; 
                       return iComputerMove; 
                }                     
            } 
            
            for (int iCol=6; iCol>2; iCol--) { 
                if (gameGrid[iRow][iCol] ==humanPlayer && 
                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol-1] && 
                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol-2] && 
                gameGrid[iRow-3][iCol-3]==emptySpace && gameGrid[iRow-2][iCol-3]!=emptySpace) { 
                              iComputerMove[0] = iRow-3; 
                              iComputerMove[1] = iCol-3; 
                              return iComputerMove; 
                } 
                
                if (gameGrid[iRow][iCol] ==humanPlayer && 
                gameGrid[iRow-1][iCol-1]  == emptySpace && 
                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol-2] && 
                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol-3] && gameGrid[iRow][iCol-1]!=emptySpace) { 
                              iComputerMove[0] = iRow-1; 
                              iComputerMove[1] = iCol-1; 
                              return iComputerMove; 
                }                 
                
                if (gameGrid[iRow][iCol] ==humanPlayer && 
                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol-1] && 
                gameGrid[iRow-2][iCol-2] ==emptySpace && 
                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol-3] && gameGrid[iRow-1][iCol-2]!=emptySpace) { 
                              iComputerMove[0] = iRow-2; 
                              iComputerMove[1] = iCol-2; 
                              return iComputerMove; 
                }                    
            }   
        } 
        
        //If no blocking moves found, begin offensive checks 
        
        // check for a horizontal 2 in a row 
        for (int iRow=0; iRow<6; iRow++) { 
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
                    gameGrid[iRow+2][iCol+2]==emptySpace && gameGrid[iRow+3][iCol+2]!=emptySpace) { 
                                  iComputerMove[0] = iRow+2; 
                                  iComputerMove[1] = iCol+2; 
                                  return iComputerMove; 
                    } 
                } 

            for (int iCol=6; iCol>2; iCol--) { 
                if (gameGrid[iRow][iCol] ==computerPlayer && 
                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol-1] &&                 
                gameGrid[iRow+2][iCol-2]==emptySpace && gameGrid[iRow+3][iCol-2]!=emptySpace) { 
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
                    gameGrid[iRow+2][iCol+2]==emptySpace) { 
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
                    gameGrid[iRow-2][iCol+2]==emptySpace && gameGrid[iRow-1][iCol+2]!=emptySpace) { 
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
        for (int iRow=0; iRow<6; iRow++) { 
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
      
        
        //check for first empty slot to place a piece in bottom row 
        for (int iCol=0; iCol<7; iCol++) { 
            if (gameGrid[5][iCol] == emptySpace) {                     
               iComputerMove[0] = 5; 
               iComputerMove[1] = iCol; 
                return iComputerMove; 
            } 
        } 
  
        return iComputerMove; 
    } 
} 
