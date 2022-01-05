package br.com.teradynebrasil.securityapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teradynebrasil.securityapi.entities.Category;
import br.com.teradynebrasil.securityapi.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/lista")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public ResponseEntity<List<Category>> findAll() {
		
		List<Category> list = categoryService.findAll();

		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = categoryService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
