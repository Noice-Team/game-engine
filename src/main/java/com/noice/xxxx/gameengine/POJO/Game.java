package com.noice.xxxx.gameengine.POJO;

import java.util.List;
import java.util.Set;

import com.noice.xxxx.gameengine.Engine.IGameEngine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * represente une partie
 * @author alban
 *
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Game {
	private Set <Unite> unites;
	private List <Joueur> joueurs;
	private List <Case> cases;
	private IGameEngine gameEngine;	
}