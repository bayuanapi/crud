package com.demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.model.request.DocumentRequest;
import com.demo.crud.model.request.JwtRequest;
import com.demo.crud.model.response.BaseResponse;
import com.demo.crud.service.AuthService;
import com.demo.crud.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@Autowired
	private AuthService authService;

	@PostMapping("/api")
	public BaseResponse addDocument(@RequestBody DocumentRequest request) {
		return demoService.createDocument(request);
	}

	@GetMapping("/api")
	public BaseResponse getDocument(@RequestParam("id") String id) {
		return demoService.findDocument(id);
	}

	@DeleteMapping("/api/{id}")
	public BaseResponse deleteDoc(@PathVariable("id") String id) {
		return demoService.deleteDoc(id);
	}

	@PutMapping("/api")
	public BaseResponse editDocument(@RequestBody DocumentRequest request) {
		return demoService.editDocument(request);
	}

	@GetMapping("/api/list-data")
	public BaseResponse getAllDocument() {
		return demoService.findAllDocument();
	}
	
	@PostMapping(value = "/auth")
	public BaseResponse createAuthenticationToken(@RequestBody JwtRequest request) throws Exception {
		return authService.auth(request);
	}


}
