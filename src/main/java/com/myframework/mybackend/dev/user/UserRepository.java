package com.myframework.mybackend.dev.user;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	ArrayList<UserEntity> findAll(); // 전체 조회
}
