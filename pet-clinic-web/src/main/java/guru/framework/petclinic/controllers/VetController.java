package guru.framework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.framework.petclinic.services.VetService;

@Controller
@RequestMapping("/vets") //Main sub-directory, any request mapping on method-level will be prefixed by that.
public class VetController {
	
	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping(value={"", "/", "/index", "/index.html"}, method=RequestMethod.GET)
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
