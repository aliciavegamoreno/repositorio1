package com.alicia;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

	@Autowired
	WinnerResolutorService winnerResolutor;

	Statistics stats = new Statistics();

	public Statistics getStatistics() {
		return stats;
	}

	public Round play() {

		Round round = setPlay();
		
		updateStats(round.getResultOfGame());

		return round;
	}

	private void updateStats(String resolution) {
		
		if (Constantes.DRAW.equalsIgnoreCase(resolution)) {
			stats.setDrawsTotal(stats.getDrawsTotal() + 1);
		} else if (Constantes.PLAYER_ONE_WINS.equalsIgnoreCase(resolution)) {
			stats.setPlayerOneTotal(stats.getPlayerOneTotal() + 1);
		} else {
			stats.setPlayerTwoTotal(stats.getPlayerTwoTotal() + 1);
		}
		
		stats.setRoundNumber(stats.getRoundNumber() + 1);

	}

	private Round setPlay() {
		
		Round round = new Round();
		int index = ThreadLocalRandom.current().nextInt(0, Constantes.item.length);
		round.setPlayerOne(Constantes.item[index]);
		round.setPlayerTwo(Constantes.ROCK);

		String resolution = winnerResolutor.checkWinner(round.getPlayerOne(), round.getPlayerTwo());

		round.setResultOfGame(resolution);
		
		return round;
	}
}
