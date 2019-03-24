package guru.framework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.framework.petclinic.services.OwnerService;

@Controller
@RequestMapping("/owners") //Main sub-directory, any request mapping on method-level will be prefixed by that.
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
			this.ownerService = ownerService;
	}

	@RequestMapping(value={"", "/", "/index", "/index.html"}, method=RequestMethod.GET)
	public String listOwners(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
}
