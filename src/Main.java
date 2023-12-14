import java.util.*;

public class Main { 
    static int[] rowOne = new int[3]; 
    static int[] rowTwo = new int[3]; 
    static int[] rowThree = new int[3];

    static int playerOnePawn = 0;
    static int playerTwoPawn = 0;

    static int rowChoice;
    static int spotChoice;

    static boolean isFull = false;

    static int winner = 0;

    public static void main(String[] args) {
        choosePawns();
        gameLoop();
    }
    public static void showBoard() {
        System.out.println(Arrays.toString(rowOne));
        System.out.println(Arrays.toString(rowTwo));
        System.out.println(Arrays.toString(rowThree));
    }
    public static void choosePawns() {
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("Player 1 Choose a number as a pawn between 1-9: ");
            playerOnePawn = scanner.nextInt();
            if(playerOnePawn > 9 || playerOnePawn < 1) {
                System.out.println("Pawn/Number out of range! ");
            }
            else break;
        }
        while(true) {
            System.out.println("Player 2 Choose a number as a pawn between 1-9: ");
            playerTwoPawn = scanner.nextInt();
            if(playerTwoPawn==playerOnePawn) {
                System.out.println("Choose a different pawn/number! ");
            }
            else if(playerTwoPawn > 9 || playerTwoPawn < 1) {
                System.out.println("Pawn/Number out of range! ");
            }
            else break;
        }   
        System.out.println("Player 1 is: " + playerOnePawn);
        System.out.println("Player 2 is: " + playerTwoPawn);
    }
    public static void gameLoop() {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            //player 1 turn
            showBoard();
            System.out.println("PLAYER 1 TURN");
            
            while(true) {
                System.out.println("Choose a ROW: ");
                rowChoice = scanner.nextInt();
                System.out.println("Choose a Spot (1, 2, 3): ");
                spotChoice = scanner.nextInt();
                fillBoard(1, rowChoice, spotChoice);
                checkWinner(1);
                if(isFull==false){break;}
            }
            if(winner != 0){
                break;
            }
            //player 2 turn
            showBoard();
            System.out.println("PLAYER 2 TURN");

            while(true) {
                System.out.println("Choose a ROW: ");
                rowChoice = scanner.nextInt();
                System.out.println("Choose a Spot (1, 2, 3): ");
                spotChoice = scanner.nextInt();
                fillBoard(2, rowChoice, spotChoice);
                checkWinner(2);
                if(isFull==false){break;}
            }
            if(winner != 0){
                break;
            }
        }
        showBoard();
        if(winner==playerOnePawn){
            System.out.print("Game over! The winner is Player One. Congratulations");
        }
        else if(winner==playerTwoPawn){
            System.out.print("Game over! The winner is Player Two. Congratulations");
        }
        else {
            System.out.print("Game over! No one won, skill issue. Try again next time!");
        }
    }

    public static void fillBoard(int playerTurn, int rowNumber, int spotToFill) {
        //to flip the spot choices into actual array positions
        switch(spotToFill) {
                case 1:
                    spotToFill = 0;
                    break;
                case 2:
                    spotToFill = 1;
                    break;
                case 3:
                    spotToFill = 2;
                    break;
            }
        // insertion of player pawns into positions
        switch(rowNumber) {
            case 1:
                switch(playerTurn) {
                    case 1:
                        if(rowOne[spotToFill] == playerOnePawn || rowOne[spotToFill] == playerTwoPawn) {
                            System.out.println("Spot or Row is Full! ");
                            isFull = true;
                        }
                        else {
                            rowOne[spotToFill] = playerOnePawn; 
                            isFull = false; 
                            break;
                        }
                    case 2:
                        if(rowOne[spotToFill] == playerOnePawn || rowOne[spotToFill] == playerTwoPawn) {
                            System.out.println("Spot or Row is Full! ");
                            isFull = true;
                        }
                        else {
                            rowOne[spotToFill] = playerTwoPawn; 
                            isFull = false; 
                            break;
                        }
                }
                break;
            case 2:
                switch(playerTurn) {
                    case 1:
                        if(rowTwo[spotToFill] == playerOnePawn || rowTwo[spotToFill] == playerTwoPawn) {
                            System.out.println("Spot or Row is Full! ");
                            isFull = true;
                        }
                        else {
                            rowTwo[spotToFill] = playerOnePawn; 
                            isFull = false; 
                            break;
                        }
                    case 2:
                        if(rowTwo[spotToFill] == playerOnePawn || rowTwo[spotToFill] == playerTwoPawn) {
                            System.out.println("Spot or Row is Full! ");
                            isFull = true;
                        }
                        else {
                            rowTwo[spotToFill] = playerTwoPawn; 
                            isFull = false; 
                            break;
                        }
                }
                break;
            case 3:
                switch(playerTurn) {
                    case 1: 
                        if(rowThree[spotToFill] == playerOnePawn || rowThree[spotToFill] == playerTwoPawn) {
                            System.out.println("Spot or Row is Full! ");
                            isFull = true;
                        }
                        else {
                            rowThree[spotToFill] = playerOnePawn; 
                            isFull = false; 
                            break;
                        }
                    case 2: 
                        if(rowThree[spotToFill] == playerOnePawn || rowThree[spotToFill] == playerTwoPawn) {
                            System.out.println("Spot or Row is Full! ");
                            isFull = true;
                        }
                        else {rowThree[spotToFill] = playerTwoPawn; 
                            isFull = false; 
                            break;
                        }
                }
                break;
            default:
                System.out.println("I have no fucking clue what you just did");
                break;
        }
    }

    public static void checkWinner(int player){
        // rows for player 1
        switch(player) {
            case 1:
                if(rowOne[0] == playerOnePawn && rowOne[1] == playerOnePawn && rowOne[2] == playerOnePawn) {
                    winner = playerOnePawn;
                    break;
                } 
                else if(rowTwo[0] == playerOnePawn && rowTwo[1] == playerOnePawn && rowTwo[2] == playerOnePawn){
                    winner = playerOnePawn;
                    break;
                }
                else if(rowThree[0] == playerOnePawn && rowThree[1] == playerOnePawn && rowThree[2] == playerOnePawn) {
                    winner = playerOnePawn;
                    break;
                } // horizontal for player 1
                else if(rowOne[0] == playerOnePawn && rowTwo[0] == playerOnePawn && rowThree[0] == playerOnePawn) {
                    winner = playerOnePawn;
                    break;
                }
                else if(rowOne[1] == playerOnePawn && rowTwo[1] == playerOnePawn && rowThree[1] == playerOnePawn) {
                    winner = playerOnePawn;
                    break;
                }
                else if(rowOne[2] == playerOnePawn && rowTwo[2] == playerOnePawn && rowThree[2] == playerOnePawn) {
                    winner = playerOnePawn;
                    break;
                } // Diagonal for player 1
                else if(rowOne[0] == playerOnePawn && rowTwo[1] == playerOnePawn && rowThree[2] == playerOnePawn) {
                    winner = playerOnePawn;
                    break;
                }
                else if(rowOne[2] == playerOnePawn && rowTwo[1] == playerOnePawn && rowThree[0] == playerOnePawn) {
                    winner = playerOnePawn;
                    break;
                }
                // in case no one wins 1
                else if(rowOne[0]!=0 && rowOne[1]!=0 && rowOne[2]!=0 && rowTwo[0]!=0 && rowTwo[1]!=0 && rowTwo[2]!=0 && rowThree[0]!=0 && rowThree[1]!=0 && rowThree[2]!=0) {
                    winner = 100;
                    break;
                }
            case 2:
                if(rowOne[0] == playerTwoPawn && rowOne[1] == playerTwoPawn && rowOne[2] == playerTwoPawn) {
                    winner = playerTwoPawn;
                    break;
                } 
                else if(rowTwo[0] == playerTwoPawn && rowTwo[1] == playerTwoPawn && rowTwo[2] == playerTwoPawn){
                    winner = playerTwoPawn;
                    break;
                }
                else if(rowThree[0] == playerTwoPawn && rowThree[1] == playerTwoPawn && rowThree[2] == playerTwoPawn) {
                    winner = playerTwoPawn;
                    break;
                } // horizontal for player 2
                else if(rowOne[0] == playerTwoPawn && rowTwo[0] == playerTwoPawn && rowThree[0] == playerTwoPawn) {
                    winner = playerTwoPawn;
                    break;
                }
                else if(rowOne[1] == playerTwoPawn && rowTwo[1] == playerTwoPawn && rowThree[1] == playerTwoPawn) {
                    winner = playerTwoPawn;
                    break;
                }
                else if(rowOne[2] == playerTwoPawn && rowTwo[2] == playerTwoPawn && rowThree[2] == playerTwoPawn) {
                    winner = playerTwoPawn;
                    break;
                } // Diagonal for player 2
                else if(rowOne[0] == playerTwoPawn && rowTwo[1] == playerTwoPawn && rowThree[2] == playerTwoPawn) {
                    winner = playerTwoPawn;
                    break;
                }
                else if(rowOne[2] == playerTwoPawn && rowTwo[1] == playerTwoPawn && rowThree[0] == playerTwoPawn) {
                    winner = playerTwoPawn;
                    break;
                }
                // in case no one wins 2
                else if(rowOne[0]!=0 && rowOne[1]!=0 && rowOne[2]!=0 && rowTwo[0]!=0 && rowTwo[1]!=0 && rowTwo[2]!=0 && rowThree[0]!=0 && rowThree[1]!=0 && rowThree[2]!=0) {
                    winner = 100;
                    break;
                }
        }
    }   
}
