package com.alicia;

import org.springframework.stereotype.Component;

@Component
public class WinnerResolutorService {

	
	public String checkWinner(String playerOne, String playerTwo) {
		String result = Constantes.WAITING_FOR_PLAYER;
		if (playerOne != null && !playerOne.isEmpty() && playerTwo != null && !playerTwo.isEmpty()) {
			if (playerOne.equalsIgnoreCase(playerTwo)) {
				result = Constantes.DRAW;
			} else {
				boolean playerOneWins = playerOne.equalsIgnoreCase(Constantes.ROCK)
						&& playerTwo.equalsIgnoreCase(Constantes.SCISSORS)
						|| playerOne.equalsIgnoreCase(Constantes.PAPER) && playerTwo.equalsIgnoreCase(Constantes.ROCK)
						|| playerOne.equalsIgnoreCase(Constantes.SCISSORS)
								&& playerTwo.equalsIgnoreCase(Constantes.PAPER);

				result = playerOneWins ? Constantes.PLAYER_ONE_WINS : Constantes.PLAYER_TWO_WINS;
			}
		}
		return result;
	}

}
