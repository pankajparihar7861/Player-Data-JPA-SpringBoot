package com.cg.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.player.entity.Player;
import com.cg.player.exception.PlayerNotFoundException;
import com.cg.player.service.IPlayerService;

@CrossOrigin
@RestController
@RequestMapping("/api/player")
public class PlayerController {

	@Autowired
	IPlayerService service;

	@PostMapping("/add-Player")
	public Player addPlayer(@RequestBody Player player) {

		return service.addPlayer(player);

	}

	@PutMapping("/update-player/{jerseyNumber}")
	public Player updatePlayer(@PathVariable int jerseyNumber, @RequestBody Player player) throws PlayerNotFoundException {

//		return new ResponseEntity<Player>(service.updatePlayer(jerseyNumber, player), HttpStatus.ACCEPTED);

		return service.updatePlayer(jerseyNumber, player);

	}

	@DeleteMapping("/delete-player/{jerseyNumber}")
	public ResponseEntity<Player> deletePlayer(@PathVariable int jerseyNumber) throws PlayerNotFoundException {

		return new ResponseEntity<Player>(service.deletePlayer(jerseyNumber), HttpStatus.ACCEPTED);

	}

	@GetMapping("/show-by-jerseyNumber/{jerseyNumber}")
	public Player showPlayerByJerseyNumber(@PathVariable int jerseyNumber) throws PlayerNotFoundException {

		return service.showPlayerByJerseyNumber(jerseyNumber);
	}

	@GetMapping("show-all-players")
	public List<Player> showAllPlayers() {

		return service.showAllPlayers();
	}

	// extra

	@GetMapping("/show-by-playerName/{playerName}")
	public Player showPlayerByName(@PathVariable String playerName) throws PlayerNotFoundException {

		return service.showPlayerByName(playerName);
	}

	@GetMapping("/show-by-playerRuns/{playerRuns}")
	public List<Player> showPlayerByRuns(@PathVariable double playerRuns) throws PlayerNotFoundException {

		return service.showPlayerByRuns(playerRuns);
	}

	@GetMapping("/show-by-GreaterRuns/{playerRuns}")
	public List<Player> showPlayerByGreaterRuns(@PathVariable double playerRuns) throws PlayerNotFoundException {

		return service.showPlayerByGreaterRuns(playerRuns);
	}

	@GetMapping("/show-by-country/{playerCountry}")
	public List<Player> showPlayerByCountry(@PathVariable String playerCountry) throws PlayerNotFoundException {

		return service.showPlayerByCountry(playerCountry);
	}

	@GetMapping("/get-total-runs")
	public double totalRuns() {

		return service.totalRuns();
	}

}
