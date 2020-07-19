package com.alicia;

public class Statistics {

	private Integer roundNumber;
	private Integer playerOneTotal;
	private Integer playerTwoTotal;
	private Integer drawsTotal;

	public Statistics() {
		super();
		this.playerOneTotal = 0;
		this.playerTwoTotal = 0;
		this.drawsTotal = 0;
		this.roundNumber = 0;
	}

	public Integer getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(Integer roundNumber) {
		this.roundNumber = roundNumber;
	}

	public Integer getPlayerOneTotal() {
		return playerOneTotal;
	}

	public void setPlayerOneTotal(Integer playerOneTotal) {
		this.playerOneTotal = playerOneTotal;
	}

	public Integer getPlayerTwoTotal() {
		return playerTwoTotal;
	}

	public void setPlayerTwoTotal(Integer playerTwoTotal) {
		this.playerTwoTotal = playerTwoTotal;
	}

	public Integer getDrawsTotal() {
		return drawsTotal;
	}

	public void setDrawsTotal(Integer drawsTotal) {
		this.drawsTotal = drawsTotal;
	}

}
