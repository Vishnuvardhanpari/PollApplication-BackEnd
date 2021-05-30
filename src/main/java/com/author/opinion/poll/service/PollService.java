package com.author.opinion.poll.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.opinion.poll.entity.PollDetails;
import com.author.opinion.poll.repository.PollRepository;

@Service
public class PollService {
	
	@Autowired
	private PollRepository pollRepository;

	public void updateVote(int id) {
		pollRepository.updateVote(id);
	}
	
	public void populateData() {
		List<PollDetails> dataList = pollRepository.findAll();
		if(dataList.size() == 0) {
			List<PollDetails> candidatesList = new ArrayList<PollDetails>();
			Collections.addAll(candidatesList, new PollDetails(1,"Miguel",0L),new PollDetails(2,"Charles",0L),new PollDetails(3,"Tolkien",0L),new PollDetails(4,"Antoine",0L));
			pollRepository.saveAll(candidatesList);
		}
	}

	public Map<Integer,BigDecimal> getResult() {
		List<PollDetails> candidatesList = pollRepository.findAll();
		
		AtomicLong totalVote = new AtomicLong();
		candidatesList.stream().forEach(action -> {
			totalVote.getAndAdd(action.getVote()); 
		});
		
		Map<Integer,BigDecimal> percentageMap = new HashMap<Integer,BigDecimal>();
		
		System.out.println("TotalVote" + totalVote);
		candidatesList.stream().forEach(action -> {
			BigDecimal candidatePercentage = BigDecimal.valueOf(action.getVote()*100).divide(BigDecimal.valueOf(totalVote.get()),1, RoundingMode.HALF_UP);
			percentageMap.put(action.getId(), candidatePercentage);
		});
		
		
		return percentageMap;
		
	}
	
	
}
