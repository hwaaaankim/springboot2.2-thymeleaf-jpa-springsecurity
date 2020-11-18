package com.hwan.ExBoot04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwan.ExBoot04.model.Board;
import com.hwan.ExBoot04.model.User;
import com.hwan.ExBoot04.repository.BoardRepository;
import com.hwan.ExBoot04.repository.UserRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Board save(String username, Board board) {
		User user = userRepository.findByUsername(username);
		board.setUser(user);
		return boardRepository.save(board);
	}
}
