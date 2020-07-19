package com.alicia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webapi")
public class GameRestController {

	@Autowired
	GameService gameService;
		
	@RequestMapping("/play")
	public Round play(Model modelo) {
		Round round = gameService.play();
		return round;
	}
	
}
