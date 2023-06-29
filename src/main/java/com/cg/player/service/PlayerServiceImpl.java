package com.cg.player.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.player.entity.Player;
import com.cg.player.exception.PlayerNotFoundException;
import com.cg.player.repository.IPlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	IPlayerRepository repository;

	public Player addPlayer(Player player) {

		return repository.save(player);
	}

	public Player updatePlayer(int jerseyNumber, Player player) throws PlayerNotFoundException {

		Player existPlayer = repository.findById(jerseyNumber).orElse(null);

		if (existPlayer == null) {

			throw new PlayerNotFoundException(" UPDATION ERROR Jersey Number " + jerseyNumber + " is not found in DataBase");

		}

		return repository.save(player);
	}

	public Player deletePlayer(int jerseyNumber) throws PlayerNotFoundException {

		Player existPlayer = repository.findById(jerseyNumber).orElse(null);

		if (existPlayer == null) {

			throw new PlayerNotFoundException("Player with jerseyNumber " + jerseyNumber + " is not found in DataBase");

		}

		repository.delete(existPlayer);

		return existPlayer;
	}

	public Player showPlayerByJerseyNumber(int jerseyNumber) throws PlayerNotFoundException {

		Player existPlayer = repository.findById(jerseyNumber).orElse(null);

		if (existPlayer == null) {

			throw new PlayerNotFoundException("Sorry No Player With Jersey Number " + jerseyNumber + " is found in DataBase");
		}

		return existPlayer;
	}

	public List<Player> showAllPlayers() {

		return repository.findAll();
	}

	// extra

	@Override
	public Player showPlayerByName(String playerName) throws PlayerNotFoundException {

		Player existPlayer = repository.findByPlayerName(playerName);

		if (existPlayer == null) {

			throw new PlayerNotFoundException("Sorry No Player With Name " + playerName + " is found in DataBase");
		}

		return existPlayer;

	}

	@Override
	public List<Player> showPlayerByRuns(double playerRuns) throws PlayerNotFoundException {

		List<Player> existPlayer = repository.findByPlayerRuns(playerRuns);

		if (existPlayer.isEmpty()) {

			throw new PlayerNotFoundException("Sorry No Player Have " + playerRuns + " runs in DataBase");
		}

		return existPlayer;
	}

	@Override
	public List<Player> showPlayerByCountry(String playerCountry) throws PlayerNotFoundException {

		List<Player> existPlayer = repository.findByPlayerCountry(playerCountry);

		if (existPlayer.isEmpty()) {

			throw new PlayerNotFoundException("Sorry No Player from " + playerCountry + " is found in DataBase");
		}

		return existPlayer;
	}

	@Override
	public List<Player> showPlayerByGreaterRuns(double playerRuns) throws PlayerNotFoundException {

		List<Player> existPlayer = repository.findByPlayerRunsGreaterThan(playerRuns);

		if (existPlayer.isEmpty()) {

			throw new PlayerNotFoundException("Sorry No Player have scored runs above " + playerRuns);
		}

		return existPlayer;
	}

	@Override
	public double totalRuns() {

		return repository.totalRuns();
	}

}
