package com.redhat.coolstore.util;

public class SystemPropertiesEnvironment implements Environment {

	@Override
	public String getCartId() {
		//TODO: Needs to retrieve values from system properties
		return "1";
	}

	@Override
	public String getApiGatewayUrl() {
		// TODO: Needs to retrieve values from system properties
		return "http://localhost:8081";
	}

}
