package nl.phoyd;

import java.util.Scanner;

public class  Main {

    public static void main(String[] args) {
	    // welkomstbericht
        System.out.println("Welkom bij Boter Kaas en Eieren \n");

        //string (board) aanmaken
        Field[] board = new Field[9];

        //string vullen met getallen van 1 t/m 9
        for(int i=1; i<10; i++){
            board[i-1] = new Field(Integer.toString(i));
            //System.out.println(board[i]);  //board is nu nog een enkele string van negen getallen, zie methode board hierna
            //intussen omgezet naar fields
        }

        //methode board aanroepen om board te printen
        printBoard(board);

        //Player aanmaken door de constructor aan te roepen uit de class Player
        //met de parameters name cq "kruisje" en token cq "x"
        Player playerA = new Player("kruisje","x");
        Player playerB = new Player("Rondje","o");

        Game game = new Game(playerA, playerB);


        //Player currentPlayer = playerA; //deze zit nu in het game object

        boolean hasWon = false;

        //zonder winconditie zal spel oneindig loopen
        while (hasWon == false) {

            // geef speler de mogelijkheid om een symbool te zetten
            System.out.println("\n Voer een cijfer van 1 t/m 9 in om op het bord een " + game.getCurrentPlayer().getName() + " te zetten");
            Scanner userInput = new Scanner(System.in);
            int selectedField = userInput.nextInt();
            //board[positie] = X

            String  currentPlayerToken = game.getCurrentPlayer().getToken();

            board[selectedField - 1].setToken(currentPlayerToken);

            //methode board aanroepen
            printBoard(board);

            hasWon = game.hasPlayerWon(board);

            if(hasWon) {
                game.getCurrentPlayer().setScore(1);
            }
            //van speler wisselen
            game.switchPlayer();
        }
        System.out.println("\n");
        System.out.println("Speler " + playerA.getName() + " heeft een score van " + playerA.getScore());
        System.out.println("Speler " + playerB.getName() + " heeft een score van " + playerB.getScore());

        // opgelost met een if en break voor het wisselen van de speler
        //currentPlayer = switchPlayer(currentPlayer);
        //System.out.println("\nBeste " + currentPlayer + " Gefeliciteerd, je hebt gewonnen.");


        // keuzemenu

        // einde
    }
    //methodes formuleer je zo: public static outPutDataType methodeNaam(inputDataType inputDataTypeNaam)

    //methode om board te printen
    public static void printBoard(Field[] board) {
        //toon het board
        for (int i=0; i< board.length; i++) {
            if ((i+1) % 3 ==0) {
                System.out.print(board[i].getToken());
                //spatie voor 0 3 6
            } else if ((i+6)%3==0) {
                System.out.print(" "+ board[i].getToken() + " | ");

            } else {
                System.out.print(board[i].getToken() + " | ");
            }
            //geen lijn printen onder de getallen
            boolean isEndOfRow = (i+1) % 3 ==0;
            boolean isLastField = i==8;
            if (isEndOfRow && !isLastField) {
                System.out.println("\n---+---+---");
            }
        }

    }

}
