package co.simplon.portail.message.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.portail.message.model.User;
import co.simplon.portail.message.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;	
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok().body(userService.getAll());
	}
	
	@CrossOrigin
	@GetMapping("id/{id}") 
	public ResponseEntity<?> getOneById(@PathVariable(value="id") long id) {
		return ResponseEntity.ok().body(userService.getOneById(id));
	}
	
	@CrossOrigin
	@PostMapping("/check")
	public ResponseEntity<?> checkLogin(@RequestBody User user) { 		
		User userInDb = userService.getOneByMatricule(user.getMatricule());
		if (user.getPassword().equals(userInDb.getPassword())) {
	    return ResponseEntity.ok().body(userInDb);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Matricule / Mot de passe incorect");
		}
	}   

	@CrossOrigin
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody User user) { 
	    return ResponseEntity.ok().body(userService.create(user));
	}   
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value ="id") long id, @Valid @RequestBody User userForm) {
		User userToUpdate = userService.getOneById(id);
		userToUpdate.setFunction(userForm.getFunction());
		userToUpdate.setMatricule(userForm.getMatricule());
		userToUpdate.setLastname(userForm.getLastname());
		userToUpdate.setPassword(userForm.getPassword());
		userToUpdate.setPhone(userForm.getPhone());
		userToUpdate.setFirstname(userForm.getFirstname());
		return ResponseEntity.ok().body(userService.update(userToUpdate));
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		User userToDelete = userService.getOneById(id);
		userService.delete(userToDelete);
		return ResponseEntity.ok().build();
	}
}
