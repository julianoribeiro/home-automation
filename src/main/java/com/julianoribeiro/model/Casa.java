package com.julianoribeiro.model;

import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Component
public class Casa {
	
	private int lumens;
	
    GpioController gpio = GpioFactory.getInstance();
    GpioPinDigitalOutput pinLed;

	public Casa() {
		pinLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED", PinState.LOW);
//		pinLdr = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.OFF);
	};
	
	public int getLumens() {
		return lumens;
	}
	
	public StatusSensor getStatusLampada() {
		if (pinLed.isHigh()) {
			return StatusSensor.ON;
		} else {
			return StatusSensor.OFF;
		}
	}
	
	public void setLampada(StatusSensor lampada) {

		if (StatusSensor.ON.equals(lampada)) {
			pinLed.high();
		} else {
			pinLed.low();
		}
	}
	
	public String getMessage() {
		
		StringBuffer sb = new StringBuffer();
	
		GpioPinDigitalOutput pinLdrOut = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
		pinLdrOut.setState(PinState.LOW);
		gpio.unprovisionPin(pinLdrOut);
		
		int valor = 0;

		GpioPinDigitalInput pinLdrIn = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.OFF);

		while (pinLdrIn.isLow()) {
			valor++;
		}
		gpio.unprovisionPin(pinLdrIn);
		
		sb.append("[valor: ").append(valor).append("]");
		
		return sb.toString();
	}

}
