package com.example.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	DeveloperRepository developerRepository;
	@Autowired
	SkillRepository skillRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Skill java = new Skill("Java","Java language skill");
		Skill python = new Skill("python","python language skill");
		Skill javascript = new Skill("javascript","javascript language skill");
		
		skillRepository.save(java);
		skillRepository.save(python);
		skillRepository.save(javascript);
		
		List<Developer> developerslist = new LinkedList<Developer>();
		developerslist.add(new Developer("Ram","Kumar","ram@gmail.com",Arrays.asList(new Skill[] {java,javascript})));
		developerslist.add(new Developer("Raj","Kumar","raj@gmail.com",Arrays.asList(new Skill[] {python,javascript})));
		developerslist.add(new Developer("sundhar","raj","sundhar@gmail.com",Arrays.asList(new Skill[] {java,python})));
		developerRepository.save(developerslist);
	}
}
