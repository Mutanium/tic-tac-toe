package nl.phoyd;

public class Main {

    public static void main(String[] args) {
	    // welkomstbericht
        System.out.println("Welkom bij Boter Kaas en Eieren \n");

        // print board
        //string aanmaken
        String[] board = new String[9];
        //string vullen met getallen van 1 t/m 9
        for(int i=1; i<10; i++){
            board[i-1] = Integer.toString(i);
            //System.out.println(board[i]);
        }
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


        // speler doet een zet

        // winconditie

        // wissel van speler

        // keuzemenu

        // einde
    }
}
