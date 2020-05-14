package com.us.restproducer.document;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adam.
 */
@RestController
@RequestMapping("/documents")
class DocumentController {

	private DocumentRepository repository;

	DocumentController(DocumentRepository repository) {
		this.repository = repository;
	}

	@GetMapping(path = "/{id}")
	Document findById(@PathVariable Long id) {
		return repository.findById(id);
	}
}
