package com.cg.player.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.player.entity.Player;
import com.cg.player.exception.PlayerNotFoundException;

@Component
public interface IPlayerService {

	public Player addPlayer(Player player);

	public Player updatePlayer(int jerseyNumber, Player player) throws PlayerNotFoundException;

	public Player deletePlayer(int jerseyNumber) throws PlayerNotFoundException;

	public Player showPlayerByJerseyNumber(int jerseyNumber)  throws PlayerNotFoundException;

	public List<Player> showAllPlayers();
	
	// extra

	public Player showPlayerByName(String playerName) throws PlayerNotFoundException;

	public List<Player> showPlayerByRuns(double playerRuns) throws PlayerNotFoundException;

	public List<Player> showPlayerByCountry(String playerCountry) throws PlayerNotFoundException;

	public List<Player> showPlayerByGreaterRuns(double playerRuns) throws PlayerNotFoundException;
	
	public double totalRuns();

}
