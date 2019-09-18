package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DevelopersController {
	@Autowired
	DeveloperRepository developerRepository;
	@Autowired
	SkillRepository skillRepository;
	@RequestMapping("/developer/{id}")
	public String Developer(@PathVariable long id,Model model) {
		model.addAttribute("developer",developerRepository.findAll());
		model.addAttribute("skills", skillRepository.findAll());
		return "developer";
		
	}
	@RequestMapping(value="/developers", method=RequestMethod.GET)
	public String developerList(Model model) {
		model.addAttribute("developers", developerRepository.findAll());
		return "developers";
		
	}
	@RequestMapping(value="/develoers",method = RequestMethod.POST)
	public String developersAdd(@RequestParam String email,@RequestParam String firstName,@RequestParam String lastName,Model model ) {
        Developer newDeveloper = new Developer();
        newDeveloper.setFirstName(firstName);
        newDeveloper.setLastName(lastName);
        newDeveloper.setEmail(email);
        developerRepository.save(newDeveloper);
        model.addAttribute("developer",newDeveloper);
        model.addAttribute("skills",skillRepository.findAll());
        return "redirect: /developer/" +newDeveloper.getId();
		
	}
	@RequestMapping(value="/developer/{id}/skills",method = RequestMethod.POST)
	public String developersSkill() {
		
	}

}
