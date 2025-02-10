package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
	
	
	
}
