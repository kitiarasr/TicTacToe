/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.Random;

// STUDENT NAME:  Kitiara Rivera
// FIU EMAIL: krive061@fiu.edu
// CLASS: COP 2210 – 2016
// ASSIGNMENT # [5]
// DATE: [11/28/2016]
//

public class Opponent 
{ 
    char pawn;
    
    public Opponent() {pawn = 'O';}
   
    public char getPawn(){ return pawn;}
    
    
    public void opponentMove(char board[][])
    {
        //randomize movements of opponent under constrictions and check if the value corresponds to an element in
        //board that is empty, or ' '
        int x =0;
        int y = 0;
        do
        {
            Random r= new Random();
         
            x = r.nextInt(3);
            y =  r.nextInt(3);
             
        }while(board[y][x] != ' ');
         
         //set pawn to location on board.
         board[y][x] = pawn;

    }
   
}
