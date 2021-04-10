package nl.phoyd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // welkomstbericht
        System.out.println("Welkom bij Boter Kaas en Eieren \n");

        //string (board) aanmaken
        String[] board = new String[9];

        //string vullen met getallen van 1 t/m 9
        for(int i=1; i<10; i++){
            board[i-1] = Integer.toString(i);
            //System.out.println(board[i]);  //board is nu nog een enkele string van negen getallen, zie methode board hierna
        }

        //methode board aanroepen
        printBoard(board);

        String currentPlayer = "x";

        boolean hasWon =false;

        //zonder winconditie zal spel oneindig loopen
        while (hasWon == false) {

            // geef speler de mogelijkheid om een symbool te zetten
            System.out.println("\n Voer een cijfer van 1 t/m 9 in om op het bord een " + currentPlayer + " te zetten");
            Scanner userInput = new Scanner(System.in);
            int selectedField = userInput.nextInt();
            //board[positie] = X
            board[selectedField - 1] = currentPlayer;

            //methode board aanroepen
            printBoard(board);

            hasWon = hasPlayerWon(board, currentPlayer);
            if (hasWon == true) {
                System.out.println("\nBeste " + currentPlayer + " Gefeliciteerd, je hebt gewonnen.");
                break;
            }

            //wissel van speler
            currentPlayer = switchPlayer(currentPlayer);
        }

        // opgelost met een if en break voor het wisselen van de speler
        //currentPlayer = switchPlayer(currentPlayer);
        //System.out.println("\nBeste " + currentPlayer + " Gefeliciteerd, je hebt gewonnen.");


        // keuzemenu

        // einde
    }
    //methodes formuleer je zo: public static outPutDataType methodeNaam(inputDataType inputDataTypeNaam)

    //methode om board te printen
    public static void printBoard(String[] board) {
        //toon het board
        for (int i=0; i< board.length; i++) {
            if ((i+1) % 3 ==0) {
                System.out.print(board[i]);
                //spatie voor 0 3 6
            } else if ((i+6)%3==0) {
                System.out.print(" "+ board[i] + " | ");

            } else {
                System.out.print(board[i] + " | ");
            }
            //geen lijn printen onder de getallen
            boolean isEndOfRow = (i+1) % 3 ==0;
            boolean isLastField = i==8;
            if (isEndOfRow && !isLastField) {
                System.out.println("\n---+---+---");
            }
        }

    }

    //methode om van speler te wisselen
    public static String switchPlayer(String currentPlayer) {
        if (currentPlayer == "x") {
            return "o";
        }
        else{
            return "x";
        }

    }

    //methode winconditie
    public static boolean hasPlayerWon (String[] board, String currentPlayer){
        //horizontaal winnen
        if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer) {
            return true;
        }
        if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer) {
            return true;
        }
        if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
        //verticaal winnen
        if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer) {
            return true;
        }
        if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer) {
            return true;
        }
        if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
        //diagonaal winnen
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
        if (board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer) {
            return true;
        }

        return false;
    }
}
