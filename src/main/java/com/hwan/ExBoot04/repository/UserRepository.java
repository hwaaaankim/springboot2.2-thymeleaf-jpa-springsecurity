package com.hwan.ExBoot04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hwan.ExBoot04.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
