package com.julianoribeiro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.julianoribeiro.model.Casa;
import com.julianoribeiro.model.StatusSensor;

@Controller
public class CasaController {
	
	@Autowired
	private Casa minhaCasa;

	@RequestMapping(value="/casa")
	public @ResponseBody Casa getCasa() {
		return minhaCasa;
	}
	
	@RequestMapping(value="/casa/lampada/{status}")
	public @ResponseBody Casa setLampada(@PathVariable String status) {
		minhaCasa.setLampada(StatusSensor.valueOf(status));
		return minhaCasa;
	}
	
}
