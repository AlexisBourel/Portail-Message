package co.simplon.portail.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.portail.message.service.MockService;

@CrossOrigin
@RestController
@RequestMapping("/mockdata")
public class MockController {

	@Autowired
	MockService mockService;
	
	@GetMapping
	public void getAll() {
		System.out.println("mockController called");
		mockService.populateDbWithMockedData();
		System.out.println("mockcontroller done");
	}
	
	
	

}
