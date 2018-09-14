package com.noice.xxxx.gameengine.POJO;

import java.util.List;

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
	private List <Unite> unites;
	private List <Joueur> joueurs;
	private List <Case> cases;
}
