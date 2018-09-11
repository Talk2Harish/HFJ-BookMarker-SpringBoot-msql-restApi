package com.hfj.bookmarker.controller;

import com.hfj.bookmarker.exception.ResourceNotFoundException;
import com.hfj.bookmarker.model.Bookmarker;
import com.hfj.bookmarker.repository.BookmarkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author HFJ
 *
 */
@RestController
@RequestMapping("/api")
public class BookmarkerController {

	@Autowired
	BookmarkerRepository bookmarkerRepository;

	@GetMapping("/bookmarkers")
	public List<Bookmarker> getAllBookmarkers() {
		return bookmarkerRepository.findAll();
	}

	@PostMapping("/bookmarker")
	public Bookmarker createBookmarker(@Valid @RequestBody Bookmarker bookmarker) {
		return bookmarkerRepository.save(bookmarker);
	}

	@GetMapping("/bookmarker/{id}")
	public Bookmarker getBookmarkerById(@PathVariable(value = "id") Long bookmarkerId) {
		return bookmarkerRepository.findById(bookmarkerId)
				.orElseThrow(() -> new ResourceNotFoundException("bookmarker", "id", bookmarkerId));
	}

	@PutMapping("/bookmarkers/{id}")
	public Bookmarker updateBookmarker(@PathVariable(value = "id") Long bookmarkerId,
			@Valid @RequestBody Bookmarker bookmarkerDetails) {

		Bookmarker bookmarker = bookmarkerRepository.findById(bookmarkerId)
				.orElseThrow(() -> new ResourceNotFoundException("bookmarker", "id", bookmarkerId));

		bookmarker.setTitle(bookmarkerDetails.getTitle());
		bookmarker.setContent(bookmarkerDetails.getContent());

		Bookmarker updatedBookmarker = bookmarkerRepository.save(bookmarker);
		return updatedBookmarker;
	}

	@DeleteMapping("/bookmarkers/{id}")
	public ResponseEntity<?> deleteBookmarker(@PathVariable(value = "id") Long bookmarkerId) {
		Bookmarker bookmarker = bookmarkerRepository.findById(bookmarkerId)
				.orElseThrow(() -> new ResourceNotFoundException("bookmarker", "id", bookmarkerId));

		bookmarkerRepository.delete(bookmarker);

		return ResponseEntity.ok().build();
	}
}
