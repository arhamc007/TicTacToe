import java.util.Scanner;

class Main {
	  
	public static void main(String[] args) {
		
		//A 3x3 array that represents our tic tac toe board
		char[][] playingBoard = new char[3][3];
		
		//Initializing the board with empty positions 
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				playingBoard[i][j] = '-';
			}
		}
      
		//Explaining the Rules of Tic Tac Toe to the players
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome! Here are the rules for Tic Tac Toe:");
      System.out.println("Each player will get assigned a symbol and the player will need to make a sequence of 3 consecutive symbols");
      System.out.println("either straight or diagonally in order to win. Enter the row and column number to place you symbol on a position"); 
      System.out.println("--------------------------------------Let's Start!-----------------------------------------");
		System.out.print("Please enter your name, player 1 ");
		String p1 = in.nextLine();
		System.out.print("Please enter your name, player 2 ");
		String p2 = in.nextLine();

		boolean player1 = true;

		boolean endGame = false;
		while(!endGame) {

			displayBoard(playingBoard);

			if(player1) {
				System.out.println(p1 + "'s Turn assigned with (x):");
			} else {
				System.out.println(p2 + "'s Turn assigned with (o):");
			}

			char ch = '-';
			if(player1) {
				ch = 'x';
			} else {
				ch = 'o';
			}

			int column = 0;
         int row = 0;

			while(true) {
				
				//Asking the user to place the symbol on a desired position 
				System.out.print("Enter a row number (0, 1, or 2): ");
				row = in.nextInt();
				System.out.print("Enter a column number (0, 1, or 2): ");
				column = in.nextInt();

				//Chceking if desired position is within the bounds 
				if(row < 0 || column < 0 || row > 2 || column > 2) {
					System.out.println("Inavild Position! Please enter 0s, 1s or 2s only! Try again ");
				
				//Checking in case the position has been occupied already 
				} else if(playingBoard[row][column] != '-') {
					System.out.println("Oops! This position has been taken already! Please try again.");
				
				} else {
					break;
				}
			
			}

			//Setting the position to ch
			playingBoard[row][column] = ch;

			//Checking if anyone has won
			if(Winner(playingBoard) == 'x') {
				System.out.println("Congratulations " + p1 + " you have won!");
				endGame = true;
			} else if(Winner(playingBoard) == 'o') {
				System.out.println("Congratulations " + p2 + " you have won!");
				endGame = true;
			} else {

				//Checking if there is a tie
				if(Full(playingBoard)) {
					System.out.println("Close game! It's a tie ");
					endGame = true;
				} else {
					player1 = !player1;
				}

			}

		}

		displayBoard(playingBoard);

  }

	//Function to draw the tic tac toe board
	public static void displayBoard(char[][] playingBoard) {
		System.out.println("3 in a row! Here's the Board");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(playingBoard[i][j]);
			}
			System.out.println();
		}
	}

	//Fuction to check if someone has won
	public static char Winner(char[][] playingBoard) {
		
		//Row check
		for(int i = 0; i < 3; i++) {
			if(playingBoard[i][0] == playingBoard[i][1] && playingBoard[i][1] == playingBoard[i][2] && playingBoard[i][0] != '-') {
				return playingBoard[i][0];
			}
		}

		//Column check
		for(int j = 0; j < 3; j++) {
			if(playingBoard[0][j] == playingBoard[1][j] && playingBoard[1][j] == playingBoard[2][j] && playingBoard[0][j] != '-') {
				return playingBoard[0][j];
			}
		}

		//Diagonal chcek
		if(playingBoard[0][0] == playingBoard[1][1] && playingBoard[1][1] == playingBoard[2][2] && playingBoard[0][0] != '-') {
			return playingBoard[0][0];
		}
		if(playingBoard[2][0] == playingBoard[1][1] && playingBoard[1][1] ==  playingBoard[0][2] && playingBoard[2][0] != '-') {
			return playingBoard[2][0];
		}

		return ' ';

	}

	//Function to check if board is full
	public static boolean Full(char[][] playingBoard) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(playingBoard[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
}