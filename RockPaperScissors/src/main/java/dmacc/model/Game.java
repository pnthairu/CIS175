package dmacc.model;

import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {
	
	private String player1;
	private String computerPlayer;
	private String winner;
	int num = 0;
	
	public Game(String player1) {
		this.player1 = player1;
		this.setComputerPlayer();
		this.determineWinner();
	}
	
	private void determineWinner() {	
		String winner = "Paul";	
		String tie = "Its a tie";
		this.setWinner(winner);
		
		Random random = new Random();
        int input = random.nextInt(3)+1;
        if (input == 1)
        	computerPlayer = "Rock";
        else if(input == 2)
        	computerPlayer = "Paper";
        else
        	computerPlayer = "Scissors";
		
        if (player1.equals(computerPlayer))
        	
        	System.out.println("Game is Tie !!");
       
      // if playerMove is ROCK         
      else if (player1.equals("Rock"))
        System.out.println(computerPlayer.equals("Paper") ? "Computer Wins": "Player wins");   
      // if playerMove is PAPER
      else if (player1.equals("Paper"))
        System.out.println(computerPlayer.equals("Scissors") ? "Computer Wins": "Player wins");   
      // if playerMove is SCISSORS    
      else
        System.out.println(computerPlayer.equals("Rock") ? "Computer Wins": "Player wins");   
	} 
			    
	private void setComputerPlayer() {
		
		this.setComputerPlayer("James");
	}
}