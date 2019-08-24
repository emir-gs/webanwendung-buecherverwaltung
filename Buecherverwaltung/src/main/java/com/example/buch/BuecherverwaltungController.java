package com.example.buch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuecherverwaltungController {
	
	@Autowired
	private BuchService service;
	
	@Autowired
	private ApplicationContext context;
	

	@GetMapping(value= {"/","/start"})
	public String zeigeStartseite() {
		return "index";
	}
	
	@GetMapping(value="/buchListe")
	public String zeigeBuchListe(Model model) {
		List<Buch> buchListe = service.listAll();
		model.addAttribute("buchListe", buchListe);
		return "buchListe";
	}
	
	@GetMapping(value="/buchListeGeordnetPreis")
	public String ordneBuchListe(Model model) {
		List<Buch> buchListe = service.findAllByOrderByPreisAsc();
		model.addAttribute("buchListe", buchListe);
		return "buchListe";
	}
	
	@GetMapping(value="/buchFormular")
	public String zeigeBuchFormular(Model model) {
		Buch buch = new Buch();
		model.addAttribute("buch", buch);
		return "buchFormular";
	}
		
	@GetMapping(value="/bearbeiten/{id}")
	public ModelAndView buchBearbeiten(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("buchBearbeitung");
		Buch buch = service.get(id);
		mav.addObject("buch", buch);
		return mav;
	}
	
	@GetMapping(value="/loeschen/{id}")
	public String buchLoeschen(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/buchListe";
	}
	
	@GetMapping(value="/exit")
	public void exit() {
		 int exitCode = SpringApplication.exit(context, new ExitCodeGenerator() {
	            @Override
	            public int getExitCode() {
	                // no errors
	                return 0;
	            }
	        });
	        System.exit(exitCode);
	}
	
	@PostMapping(value="/speichern")
	public String speichereBuch(@ModelAttribute("buch") Buch buch) {
		service.save(buch);
		return "redirect:/buchListe";
	}
	
}
