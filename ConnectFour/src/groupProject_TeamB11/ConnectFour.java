package groupProject_TeamB11;

public class ConnectFour {
    private static boolean isWin = false;
    private static int[][] gameGrid = new int[6][7];

    public static void main(String[] args) {
    
        //initialize the array, set each element = -1
        for (int iRow = 0; iRow < 6; iRow ++){
            for (int iCol = 0; iCol < 7; iCol++){
                gameGrid[iRow][iCol] = -1;
            }                
        }
        
        /*
         test cases to check for win or not
         
        gameGrid[0][0] = 0;
        gameGrid[0][1] = 0;
        gameGrid[0][2] = 0;
        gameGrid[0][3] = 0;
       
        
        gameGrid[0][0] = 0;
        gameGrid[1][1] = 0;
        gameGrid[2][2] = 0;
        gameGrid[3][3] = 0;
        
        gameGrid[0][6] = 0;
        gameGrid[1][5] = 0;
        gameGrid[2][4] = 0;
        gameGrid[3][3] = 0;
         */
        
        gameGrid[1][0] = 0;
        gameGrid[2][1] = 0;
        gameGrid[3][2] = 0;
        gameGrid[4][3] = 0;
        if(calculateWin()==true){
            System.out.println("You win!");
        }
        else
        {
            System.out.println("Next turn");
        }
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

   
}