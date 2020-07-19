package com.alicia;

public class Round {

	private String playerOne;
	private String playerTwo;
	private String resultOfGame;
	private int roundNumber;

	public Round(String playerOne, String playerTwo, String resultOfGame, int roundNumber) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.resultOfGame = resultOfGame;
		this.roundNumber = roundNumber;
	}

	public Round() {
		super();
	}

	public String getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(String playerOne) {
		this.playerOne = playerOne;
	}

	public String getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(String playerTwo) {
		this.playerTwo = playerTwo;
	}

	public String getResultOfGame() {
		return resultOfGame;
	}

	public void setResultOfGame(String resultOfGame) {
		this.resultOfGame = resultOfGame;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

}
