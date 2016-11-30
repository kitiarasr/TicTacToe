package assignment5;

import java.util.Random;

// STUDENT NAME:  Kitiara Rivera
// FIU EMAIL: krive061@fiu.edu
// CLASS: COP 2210 – 2016
// ASSIGNMENT # [5]
// DATE: [11/28/2016]
//

public class Board
{
    public static final int X = 3;   //COL
    public static final int Y = 3;   //ROWS
    static char board[][];           //the board that contains information that is indexed
    static String displayBoard[][];  //the board that displays on window
    
    
    public char[][] getBoard(){ return board; }
    
      
    public Board()
    {  
        board = new char [Y][X];
        displayBoard = new String [Y+4][X+4]; //+4 is done to make space for borders when it prints.
        
          //initialize board
        
        for(int i = 0; i < Y; i++)
        {
            for(int j = 0; j < X; j++)
                board[i][j] = ' ';      
        }  
        
         //initilalize displayBoard
         
        for(int i = 0; i < Y+4; i++)
        {
            for(int j = 0; j < X+4; j++)
              displayBoard[i][j] += " ";  //initializes to empty slots 
        }


        for(int i = 1; i < Y+4; i +=2)
        {
            for(int j = 0; j < X+4; j +=2)
               displayBoard[i][j] = "|";   //sets up vertical lines
        }

        for(int i = 0; i < Y+4; i+=2)
        {
           for(int j = 0; j < X+4; j++)
              displayBoard[i][j] = "-";   //sets hotizontal lines
        }
   
    }
      
      public void resetBoard()       
      {
          
        for(int i = 1; i < Y+4; i+= 2)
        {   
             for(int j = 1; j< X+4; j+= 2)
                displayBoard[i][j] = " ";   
        } 
        
          for(int i = 0; i < Y; i++)
        {   
             for(int j = 0; j< X; j++)
                board[i][j] = ' ';   
        } 
    
          
      }
     public boolean randomizeFirstMove()
             
     {
            Random r= new Random();
            int turn = r.nextInt(2);

            if(turn == 1)
                return true;
            else
                return false;
     }
     
    public String printBoard()
    { 
        String print = "";
    
        //set values of board to displayBoard to show on window.
        for(int i = 1, k = 0; i < Y+4 && k < Y; i+= 2, k++)
        {   
             for(int j = 1, l = 0; j< X+4 && l < X; j+= 2, l++)
              displayBoard[i][j] = Character.toString(board[k][l]);    
        }
          
       //display board elements are added to string print variable to print in jpane command. 
        for(int i = 0; i < Y+4; i++)
        {
           for(int j = 0; j < X+4; j++)
                 print += " " + displayBoard[i][j];
           print += "\n";
        } 
        return print;
    }
    
    
    public boolean isEmptySlots()
    {
        
        for(int i = 0; i < Y; i++)
        {
           for(int j = 0; j < X; j++)
           {
                if(board[i][j] == ' ')
                    return true;
           }
        }
        
        return false;
        

        
    }
    
      public boolean playerWin(char board[][], char pawn)
                
        {
            //count counts up to three times consecutively to find a win.
            int count = 0;
            
            //CHECK FOR HORIZONTAL WIN
            
            for(int i = 0; i < 3; i++)
            {
                count = 0;
                
                for(int j = 0; j < 3; j++)
                {
                    if(board[i][j] == pawn)
                        count++;  
                }
                
                if(count == 3)
                    return true;
            }
            
           //CHECK FOR VERTICAL WIN
            
            count = 0;
           
            for(int j = 0; j < 3; j++)
            {
                count = 0;
                
                for(int i = 0; i < 3; i++)
                {
                    if(board[i][j] == pawn)
                        count++;  
                }
                
                if(count == 3)
                    return true;
            }
            
            count = 0;
            
            //CHECK FOR LEFT DIAGONAL WIN
            

                for(int i = 0, j = 0; i < 3 && j < 3; i++, j++)
                {
                    if(board[i][j] == pawn)
                        count++;  
                }
                
                if(count == 3)
                    return true;

                
                count = 0;
                
                //CHECK FOR RIGHT DIAGONAL WIN
                
               for(int i = 0, j = 2; i < 3 && j >= 0; i++, j--)
                {
                    if(board[i][j] == pawn)
                        count++;  
                }
                
                if(count == 3)
                    return true;

            return false;
        }
    
 
}

