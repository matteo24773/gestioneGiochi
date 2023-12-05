package gestioneGame.gestioneGame.controller;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import database.GamesDao;
@Controller
public class HomeController {
	
@GetMapping("/home")
	//@RequestMapping(path="/",method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("listaGiochi", GamesDao.getInstance().readAll());
		return "Home.html";
	}
	@PostMapping(path="/home/addGame")
	//@PostMapping("/home/addGame")
	public String addGame(@RequestParam HashMap<String, String> parametri) {
		GamesDao.getInstance().add(parametri);
	return "redirect:/home";
	}
}

