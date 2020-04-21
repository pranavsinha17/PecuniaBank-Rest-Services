package com.capgemini.pecuniabank.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.pecuniabank.entity.LoanRequest;
import com.capgemini.pecuniabank.service.LoanService;



@RestController
public class LoanController {
	
	@GetMapping("/")
	public ResponseEntity<String> hello()
	{
		return new ResponseEntity<String>("Hello",HttpStatus.OK);	
	}

}