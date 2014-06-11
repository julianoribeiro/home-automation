package com.julianoribeiro.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class OlaMundoController {

	@RequestMapping(method = RequestMethod.GET, value="/ola")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String olaMundo() {
		return "eae mundão veio";
	}
}
