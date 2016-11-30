/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.Random;
import javax.swing.JOptionPane;


// STUDENT NAME:  Kitiara Rivera
// FIU EMAIL: krive061@fiu.edu
// CLASS: COP 2210 – 2016
// ASSIGNMENT # [5]
// DATE: [11/28/2016]
//

/**
 *
 * @author kitiararivera
 */

public class Assignment5 
{

    /**
     *
     * @param args
     */
    public static void main(String[] args) 
    {

        int y = 0;
        int x = 0;
        
        String printBoard = "";
        String name = "";
        String response = "";
        String printWinner = "";
        String[] gameOutcome = {"You win", "Opponent wins", "Draw"};
        
        boolean firstRound;
        boolean gameOver;
        boolean userFirstTurn;
        boolean opponentWin;
        boolean playerWin;
       
        Board game = new Board();
        User user1 = new User();
        Opponent opponent1 = new Opponent();
        gameOver = false;

        while (!gameOver)
        {
            firstRound = true;
            opponentWin = false;
            playerWin = false;
            name = JOptionPane.showInputDialog(null, "\nWelcome to the TicTacToe game! What is your name?");

            //determine who goes first on first round
            userFirstTurn = game.randomizeFirstMove();
            
            printBoard = game.printBoard(); 
              
            //while there are still empty slots, opponent hasnt won and player hasnt won
            while ((game.isEmptySlots()) && (!opponentWin) && (!playerWin)) 
            { 
                //if user goes first OR this is not the first round
                if (userFirstTurn == true || firstRound == false)
                {
                    do
                    {
                        //Collect row and column values from user.
                        y = Integer.parseInt(JOptionPane.showInputDialog(null, printBoard + "Your turn, " + name + "! What row?\n"));
                        x = Integer.parseInt(JOptionPane.showInputDialog(null, printBoard + "\nWhat column?\n"));
                   //Validate input. If it is not within the constrictions, it will loop again to ask for values.
                    }while(!user1.validateInput(y, x, game.getBoard()));
                    
                    //move user
                    user1.userMove(game.getBoard(), y, x);
                    
                    //check if player won. Set playerWin boolean to appropiate value.
                    playerWin = game.playerWin(game.getBoard(), user1.getPawn());
                    
                    printBoard = game.printBoard(); //refresh board
 
                }
                
                //dont give opponent turn if player already won or if there are no empty slots
                if(!playerWin && game.isEmptySlots())
                {
                    
                    JOptionPane.showMessageDialog(null, printBoard + "Opponents turn!!");

                    //move opponent
                    opponent1.opponentMove(game.getBoard());

                    //check if opponent won. Set opponentWin to appropiate value.
                    opponentWin = game.playerWin(game.getBoard(), opponent1.getPawn());
                    
                    printBoard = game.printBoard(); //refresh board
                }
               
                //flip booleans to terminate special first move conditions
                if (firstRound) 
                    firstRound = false;
                
                if(userFirstTurn)
                    userFirstTurn = false;
 
            }
  
            //to print out appropiate message for who won or draw.
            //All code below executes when either someone wins or a draw occurs.
            if(playerWin)
               printWinner = gameOutcome[0];
        
            else if(opponentWin) 
               printWinner = gameOutcome[1];
        
            else if (!game.isEmptySlots())
               printWinner = gameOutcome[2];
            
            
            do
            {
                response = JOptionPane.showInputDialog(null, printBoard + "Gameover! " + printWinner + "! Would you like to play again? Press y or n\n");
                response= response.toUpperCase();
          
                if(response.equals("N"))
                  gameOver = true;
             
            }while(!response.equals("N") && !response.equals("Y"));
            
            game.resetBoard(); //reset board 
        
        }
    
    }
    
}
