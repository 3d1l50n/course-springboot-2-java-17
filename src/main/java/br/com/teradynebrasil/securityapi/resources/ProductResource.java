package br.com.teradynebrasil.securityapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teradynebrasil.securityapi.entities.Product;
import br.com.teradynebrasil.securityapi.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/lista")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Product>> findAll() {

		List<Product> list = productService.findAll();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = productService.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
