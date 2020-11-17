package com.hwan.ExBoot04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hwan.ExBoot04.model.Board;
import com.hwan.ExBoot04.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
class BoardApiController {
	@Autowired
	private BoardRepository repository;

	@GetMapping("/boards")
	List<Board> all(@RequestParam(required = false, defaultValue="") String title, 
			@RequestParam(required = false, defaultValue="") String content) {
		if(StringUtils.isEmpty(title)&&StringUtils.isEmpty(content)) {
			return repository.findAll();
		}else {
			return repository.findByTitleOrContent(title, content);
		}
		
	}

	@PostMapping("/boards")
	Board newBoard(@RequestBody Board newBoard) {
		log.info("save Controller 접근");
		return repository.save(newBoard);
	}

	@GetMapping("/boards/{id}")
	Board one(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}

	@PutMapping("/boards/{id}")
	Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {

		return repository.findById(id).map(Board -> {
			Board.setTitle(newBoard.getTitle());
			Board.setContent(newBoard.getContent());
			return repository.save(Board);
		}).orElseGet(() -> {
			newBoard.setId(id);
			return repository.save(newBoard);
		});
	}

	@DeleteMapping("/boards/{id}")
	void deleteBoard(@PathVariable Long id) {
		repository.deleteById(id);
	}
}