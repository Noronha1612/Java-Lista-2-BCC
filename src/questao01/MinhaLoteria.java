package questao01;

import java.util.ArrayList;

public class MinhaLoteria {
    public static void main(String[] args) {
        final BilheteLoteria bilhetePremiado = new BilheteLoteria(6);

        for ( int ticketLength = 6; ticketLength <= 15; ticketLength++ ) {
            ArrayList<BilheteLoteria> bilhetes = new ArrayList<>();
            BilheteLoteria bilheteSorteado;
            int counterQuadra = 0;
            int counterQuina = 0;
            int counterGames = 0;

            while(true) {
                bilheteSorteado = new BilheteLoteria(ticketLength);

                int hits = bilhetePremiado.qtdNumerosContidos(bilheteSorteado);

                counterGames++;

                if ( hits == 4 ) counterQuadra++;
                else if ( hits == 5 ) counterQuina++;
                else if ( hits == 6 ) break;
            }

            bilhetes.add(bilheteSorteado);

            System.out.printf("Jogos de %d números: você apostou %d vezes para ganhar na megasena. Dentre esses jogos, você acertou %d quadras e %d quinas\n", ticketLength, counterGames, counterQuadra, counterQuina);
        }
    }
}
