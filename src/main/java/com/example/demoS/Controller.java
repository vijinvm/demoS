package com.example.demoS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping
public class Controller {
	@Autowired
	private PeopleRepository p;
	@GetMapping("/people")
	public Page<People>a1(@RequestParam int page,
			@RequestParam int size){
		return p.findAll(PageRequest.of(page, size));
	}
	@GetMapping("/sorting1")
	public List<People>a2(@RequestParam String sortBy){
		Sort sort =Sort.by(sortBy);
		return p.findAll(sort);
	}
	@GetMapping("/people/{id}")
	public People a3(@PathVariable int id) {
		return p.findById(id).orElse(null);
	}
	@PostMapping("/people")
	public People a4(@RequestBody People person) {
		return p.save(person);
	}
	@PutMapping("/people/{id}")
	public People a5(@PathVariable int id,@RequestBody People person) {
		return p.findById(id).map(e->{e.setFirstname(person.getFirstname());
		e.setLastname(person.getLastname());
		e.setBirthdate(person.getBirthdate());
		return p.save(e);
	})
				.orElse(null);
	}
	@DeleteMapping("/people/{id}")
	public void a6(@PathVariable int id) {
		p.deleteById(id);
	}
	@Autowired
	private BankRepository b;
	@GetMapping("/bank")
	public Page<Bank>b1(@RequestParam int page,
			@RequestParam int size){
		return b.findAll(PageRequest.of(page, size));
	}
	@GetMapping("/sorting2")
	public List<Bank>b2(@RequestParam String sortBy){
		Sort sort =Sort.by(sortBy);
		return b.findAll(sort);
	}
	@GetMapping("/bank/{id}")
	public Bank b3(@PathVariable int id) {
		return b.findById(id).orElse(null);
	}
	@PostMapping("/bank")
	public Bank b4(@RequestBody Bank bank) {
		return b.save(bank);
	}
	@PutMapping("/bank/{id}")
	public Bank b5(@PathVariable int id,@RequestBody Bank bank) {
		return b.findById(id).map(e->{e.setName(bank.getName());
		e.setPhonenumber(bank.getPhonenumber());
		return b.save(e);
	})
				.orElse(null);
	}
	@DeleteMapping("/bank/{id}")
	public void b6(@PathVariable int id) {
		b.deleteById(id);
	}
}
