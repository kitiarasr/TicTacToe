package assignment5;

import javax.swing.JOptionPane;


// STUDENT NAME:  Kitiara Rivera
// FIU EMAIL: krive061@fiu.edu
// CLASS: COP 2210 – 2016
// ASSIGNMENT # [5]
// DATE: [11/28/2016]
//

public class User 
{
    char pawn;
    
    public User() { pawn = 'X';}  //pawn of user

    public char getPawn() { return pawn;}
    
    //minus one because user won't put 0 for row or column. So i fix that here.
    public void userMove(char board[][], int y, int x) { board[y-1][x-1] = pawn;}  

    
    public boolean validateInput(int y, int x, char board[][])
    {
        if(x < 1 || x > 3 || y < 1 || y > 3)  //constrants of board
        {
            JOptionPane.showMessageDialog(null,"\nPut a number between 1-3\n");
            return false;
        }
        else if(board[y-1][x-1] != ' ') //check if user's chosen values refer to an empty slot
        {
             JOptionPane.showMessageDialog(null,"\nThis slot is already taken.\n");
             return false;
        }
               
        return true;
        
    }
 
}
