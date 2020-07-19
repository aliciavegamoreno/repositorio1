package com.alicia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("game")
public class GameViewController {

	@Autowired
	GameService gameService;

	@RequestMapping("/stats")
	public String hallOfFame(Model modelo) {
		
		modelo.addAttribute("stats", gameService.getStatistics());
		return "view/statistics";
		
	}

	@RequestMapping("/play")
	public String play(Model modelo, HttpSession sesion) {
		
		// get from session
		@SuppressWarnings("unchecked")
		List<Round> game = (List<Round>) sesion.getAttribute("ROUNDLIST");
		if (game == null) {
			game = new ArrayList<Round>();
		}

		Round round = gameService.play();
		round.setRoundNumber(game.size() + 1);
		game.add(round);

		// store in session
		sesion.setAttribute("ROUNDLIST", game);
		modelo.addAttribute("roundList", game);

		return "view/game";
		
	}

	@RequestMapping("/reset")
	public String reset(Model modelo, HttpSession sesion) {
		
		List<Round> game = new ArrayList<Round>();
		sesion.setAttribute("ROUNDLIST", game);
		modelo.addAttribute("roundList", game);
		return "view/game";
		
	}

	@RequestMapping({ "/", "/view" })
	public String view(Model modelo, HttpSession sesion) {
		
		@SuppressWarnings("unchecked")
		List<Round> game = (List<Round>) sesion.getAttribute("ROUNDLIST");
		modelo.addAttribute("roundList", game);
		return "view/game";
		
	}
}
