package com.cg.player.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	private int playerJerseyNumber;
	private String playerName;
	private double playerRuns;
	private String playerCountry;

	public Player() {
		super();
	}

	public Player(int playerJerseyNumber, String playerName, double playerRuns, String playerCountry) {
		super();
		this.playerJerseyNumber = playerJerseyNumber;
		this.playerName = playerName;
		this.playerRuns = playerRuns;
		this.playerCountry = playerCountry;
	}

	public int getPlayerJerseyNumber() {
		return playerJerseyNumber;
	}

	public void setPlayerJerseyNumber(int playerJerseyNumber) {
		this.playerJerseyNumber = playerJerseyNumber;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public double getPlayerRuns() {
		return playerRuns;
	}

	public void setPlayerRuns(double playerRuns) {
		this.playerRuns = playerRuns;
	}

	public String getPlayerCountry() {
		return playerCountry;
	}

	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}

	@Override
	public String toString() {
		return "Player [playerJerseyNumber=" + playerJerseyNumber + ", playerName=" + playerName + ", playerRuns="
				+ playerRuns + ", playerCountry=" + playerCountry + "]";
	}

	

}
