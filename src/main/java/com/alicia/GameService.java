package com.alicia;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

	@Autowired
	WinnerResolutorService winnerResolutor;
	
	public Round play() {

		Round round = new Round();
		int index = ThreadLocalRandom.current().nextInt(0, Constantes.item.length);
		round.setPlayerOne(Constantes.item[index]);
		round.setPlayerTwo(Constantes.ROCK);

		String resolution = winnerResolutor.checkWinner(round.getPlayerOne(), round.getPlayerTwo());
		
		round.setResultOfGame(resolution);

		//updateStats();
		
		return round;
	}
	
	
}
