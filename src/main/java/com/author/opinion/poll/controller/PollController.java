package com.author.opinion.poll.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.author.opinion.poll.entity.PollDetails;
import com.author.opinion.poll.service.PollService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/author/poll")
public class PollController {
	
	@Autowired
	private PollService pollService;
	
	@PutMapping("/vote")
	public ResponseEntity updateVote(@RequestBody PollDetails pollDetails) {
		pollService.updateVote(pollDetails.getId());
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/populateData")
	public ResponseEntity populateData(@RequestBody Object dummy) {
		pollService.populateData();
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/result")
	public Map<Integer,BigDecimal> getResult(){
		Map<Integer,BigDecimal> percentageMap = pollService.getResult();
		
		return percentageMap;
		}
	

}
