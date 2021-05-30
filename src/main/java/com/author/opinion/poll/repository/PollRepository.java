package com.author.opinion.poll.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.author.opinion.poll.entity.PollDetails;

@Repository
@Transactional
public interface PollRepository extends JpaRepository<PollDetails, Long> {
	
	@Modifying
	@Query(value="UPDATE PollDetails poll set poll.vote = poll.vote + 1 WHERE poll.id = :id")
	public void updateVote(@Param("id") int id);

}
