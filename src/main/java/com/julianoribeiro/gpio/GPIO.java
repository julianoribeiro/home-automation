package com.julianoribeiro.gpio;

/*
 * Java Embedded Raspberry Pi GPIO Input app
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.julianoribeiro.model.StatusSensor;

public class GPIO {

	static final String GPIO_IN = "in";
	static final String GPIO_OUT = "out";

	static String canalLed = "25";
	private FileWriter unexportFile;
	private FileWriter exportFile;
	
	private StringBuffer retorno;

	public String acionarLampada(StatusSensor status) {		
		
		retorno = new StringBuffer();
		
		retorno.append("*** Configurada a saída na porta GPIO" + canalLed + " ***/n");
		this.configuraSaida(canalLed);
		try {
			retorno.append("*** Enviando " + status.toString() + " para porta GPIO" + canalLed + " ***/n");
			new FileWriter("/sys/class/gpio/gpio" + canalLed + "/value").write(status.getCode());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		retorno.append("*** Executado sem exceções ***/n");
		
		return retorno.toString();
	}
	
	public void configuraSaida(String gpioChannel) {
		// Open file handles to GPIO port unexport and export controls
		try {
			unexportFile = new FileWriter("/sys/class/gpio/unexport");
			exportFile = new FileWriter("/sys/class/gpio/export");
	
			System.out.println(gpioChannel);
	
			// Reset the port
			File exportFileCheck = new File("/sys/class/gpio/gpio" + gpioChannel);
			
			if (exportFileCheck.exists()) {
				unexportFile.write(gpioChannel);
				unexportFile.flush();
			}
	
			// Set the port for use
			exportFile.write(gpioChannel);
			exportFile.flush();
	
			// Open file handle to input/output direction control of port
			FileWriter directionFile = new FileWriter("/sys/class/gpio/gpio" + gpioChannel + "/direction");
	
			// Set port for input
			directionFile.write(GPIO_OUT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
