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
		model.addAttribute("listaGiochi", GamesDao.readAll());
		return "Home.html";
	}
@PostMapping("/home/addGame")
	public String addGame(@RequestParam HashMap<String, String> parametri) {
		GamesDao.add(parametri);
	return "redirect:/home";
	}
}
