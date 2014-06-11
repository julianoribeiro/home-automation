package com.julianoribeiro.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.julianoribeiro.model.Casa;

@Controller
public class CasaController {

	@RequestMapping(value="/casa")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Casa getCasa() {
		return new Casa(12, 20);
	}
	
}
