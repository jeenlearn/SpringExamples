package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

//@Controller
@RestController
public class AlienController 
{
	@Autowired
	AlienRepo repo;
	
	
	@RequestMapping("/")
	public String home() 
	{
		System.out.println("you are here");
		return "home.jsp";
	}
	//@RequestMapping("/addAlien")
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		
		//return "home.jsp";
		return alien;
	}
	
	@PutMapping(path="/alien",consumes={"application/json"})
	public Alien saveorUpdateAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		
		//return "home.jsp";
		return alien;
	}
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a= repo.getById(aid);
		repo.delete(a);
		return "deleted";
		
	}
//	//@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		//Optional<Alien> alien = repo.findById(aid);
//		Alien alien = repo.findById(aid).orElse(new Alien());
////		System.out.println(repo.findByTech("java"));
////		System.out.println(repo.findByAidGreaterThan(101));
////		System.out.println(repo.findByTechSorted("java"));
//		mv.addObject(alien);
//		return mv;
//	}
	//@RequestMapping(path="/aliens", produces= {"application/xml"})  // this will restrict the data to be xml only and not give json
	//@RequestMapping(path="/aliens")
	@GetMapping(path="/aliens")
	//@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
		
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable int aid) {
		return repo.findById(aid);
		
	}

}
