package com.julianoribeiro.model;

import java.util.HashMap;
import java.util.Map;


public enum StatusSensor {

		ON(1, "On"),
		OFF(0, "Off");
		
		private final int code;
		private final String description;
		
		private static Map<Integer, StatusSensor> valueMap;

		private StatusSensor(int code, String description){
			this.code = code;
			this.description = description;
		}
		
		public static StatusSensor getStatus(int i) {
	        if (valueMap == null) {
	            initMapping();
	        }
	        return valueMap.get(i);
	    }
	 
	    private static void initMapping() {
	    	valueMap = new HashMap<Integer, StatusSensor>();
	        for (StatusSensor s : values()) {
	        	valueMap.put(s.code, s);
	        }
	    }
	 
	    public int getCode() {
	        return code;
	    }
	 
	    public String getDescription() {
	        return description;
	    }
	 
	    @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder();
	        sb.append("StatusSensor");
	        sb.append("{code=").append(code);
	        sb.append(", description='").append(description).append('\'');
	        sb.append('}');
	        return sb.toString();
	    }
	 
}
