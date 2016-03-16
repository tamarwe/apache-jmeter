package com.ibm.issw.odc.gui;

import java.util.LinkedHashMap;
import java.util.Map;

public class BPMJMeterUtils {

	static public final String SERVER_HOST = "SERVER_HOST";
	static public final String SERVER_HOST_DEFAULT = "192.168.0.24";
	
	static public final String SERVER_PORT = "SERVER_PORT";
	static public final String SERVER_PORT_DEFAULT = "21319";
	
	static public final String THINK_TIME = "THINK_TIME";
	static public final String THINK_TIME_DEFAULT = "";		
	
	static public final String RAMP_UP = "RAMP_UP";
	static public final String RAMP_UP_DEFAULT = "";		
		
	
	public BPMJMeterUtils() {
		// TODO Auto-generated constructor stub
	}

	public String referenceVariable(String var)
	{
		return "${" + var + "}";
	}
	
	static public Map<String, String> getBPMUserDefinedVariables()
	{
		Map<String, String> variables = new LinkedHashMap<String,String>();
		variables.put(SERVER_HOST,SERVER_HOST_DEFAULT);
		variables.put(SERVER_PORT,SERVER_PORT_DEFAULT);
		variables.put(THINK_TIME,THINK_TIME_DEFAULT);
		variables.put(RAMP_UP,RAMP_UP_DEFAULT);
		return variables;
	}
}
