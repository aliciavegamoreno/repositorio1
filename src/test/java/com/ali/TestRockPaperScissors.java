package com.ali;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alicia.Constantes;
import com.alicia.GameService;
import com.alicia.ProyectoRestApplication;
import com.alicia.WinnerResolutorService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProyectoRestApplication.class)
public class TestRockPaperScissors {

	@Autowired
	GameService gameService;
	
	@Autowired
	WinnerResolutorService winnerResolutor;
	
	@Test
	public void TestGameDraw() {
		
		String resolution = winnerResolutor.checkWinner(Constantes.ROCK, Constantes.ROCK);
		assertEquals(Constantes.DRAW, resolution);
		
		String resolution2 = winnerResolutor.checkWinner(Constantes.PAPER, Constantes.PAPER);
		assertEquals(Constantes.DRAW, resolution2);
		
		String resolution3 = winnerResolutor.checkWinner(Constantes.SCISSORS, Constantes.SCISSORS);
		assertEquals(Constantes.DRAW, resolution3);
		
	}
	
	@Test
	public void TestGamePlayerOneWins() {
		
		String resolution = winnerResolutor.checkWinner(Constantes.ROCK, Constantes.SCISSORS);
		assertEquals(Constantes.PLAYER_ONE_WINS, resolution);
		
		String resolution2 = winnerResolutor.checkWinner(Constantes.PAPER, Constantes.ROCK);
		assertEquals(Constantes.PLAYER_ONE_WINS, resolution2);
		
		String resolution3 = winnerResolutor.checkWinner(Constantes.SCISSORS, Constantes.PAPER);
		assertEquals(Constantes.PLAYER_ONE_WINS, resolution3);
		
	}
	
	@Test
	public void TestGamePlayerTwoWins() {
		
		String resolution = winnerResolutor.checkWinner(Constantes.ROCK, Constantes.PAPER);
		assertEquals(Constantes.PLAYER_TWO_WINS, resolution);
		
		String resolution2 = winnerResolutor.checkWinner(Constantes.PAPER, Constantes.SCISSORS);
		assertEquals(Constantes.PLAYER_TWO_WINS, resolution2);
		
		String resolution3 = winnerResolutor.checkWinner(Constantes.SCISSORS, Constantes.ROCK);
		assertEquals(Constantes.PLAYER_TWO_WINS, resolution3);
		
	}
	
	@Test
	public void TestStats() {
		assertEquals(gameService.getStatistics().getDrawsTotal(),0);
		assertEquals(gameService.getStatistics().getRoundNumber(),0);
		assertEquals(gameService.getStatistics().getPlayerOneTotal(),0);
		assertEquals(gameService.getStatistics().getPlayerTwoTotal(),0);
	
		gameService.play();
		gameService.play();
		
		assertEquals(gameService.getStatistics().getRoundNumber(), (gameService.getStatistics().getPlayerOneTotal()+gameService.getStatistics().getPlayerTwoTotal()+gameService.getStatistics().getDrawsTotal()));
	}

}
