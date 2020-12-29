package questao01;

import java.util.Arrays;
import java.util.Random;

public class BilheteLoteria {
    private int[] ticketNumbers;
    private int numbersCounter = 0;

    Random rand = new Random();

    public BilheteLoteria(int ticketLength) {
        ticketNumbers = new int[ticketLength];
        for ( int x = 0; x < ticketLength; x++ ) {
            int sortedNumber;

            while(true) {
                sortedNumber = rand.nextInt(60) + 1;

                if ( !findInTicket(sortedNumber) ) {
                    ticketNumbers[numbersCounter++] = sortedNumber;
                    break;
                }
            }
        }
    }

    private boolean findInTicket(int target) {
        boolean hasTarget = false;

        for ( int x = 0; x < numbersCounter; x++) {
            if ( ticketNumbers[x] == target ) hasTarget = true;
        }

        return hasTarget;
    }

    public String toString() {
        Arrays.sort(ticketNumbers);

        return Arrays.toString(ticketNumbers);
    }

    public int qtdNumerosContidos( BilheteLoteria givenTicket ) {
        int counter = 0;

        for ( int x = 0; x < givenTicket.ticketNumbers.length; x++ ) {
            if ( findInTicket(givenTicket.ticketNumbers[x]) ) counter++;
        }

        return counter;
    }
}
