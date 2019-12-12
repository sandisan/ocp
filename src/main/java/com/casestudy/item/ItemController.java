package com.casestudy.item;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping(value="/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	@GetMapping(value="/item/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Item getItemsById(@PathVariable("name") String name){
		
		Optional<Item> item = itemRepository.findByName(name);
		System.out.println(item);
		if (item.isPresent()) {
			return item.get();
		}
		return new Item();
	}
}