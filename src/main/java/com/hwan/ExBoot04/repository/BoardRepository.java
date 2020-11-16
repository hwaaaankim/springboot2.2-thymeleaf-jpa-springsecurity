package com.hwan.ExBoot04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hwan.ExBoot04.model.Board;

public interface BoardRepository extends JpaRepository<Board,Long>{

}
