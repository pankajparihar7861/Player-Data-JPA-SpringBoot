package com.cg.player.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.player.entity.Player;

@Repository
@Transactional
public interface IPlayerRepository extends JpaRepository<Player, Integer> {

	public Player findByPlayerName(String playerName);

	public List<Player> findByPlayerRuns(double playerRuns);

	public List<Player> findByPlayerCountry(String playerCountry);

	public List<Player> findByPlayerRunsGreaterThan(double playerRuns);
	
	@Query("SELECT sum(p.playerRuns) FROM Player p")
	public double totalRuns();

}
