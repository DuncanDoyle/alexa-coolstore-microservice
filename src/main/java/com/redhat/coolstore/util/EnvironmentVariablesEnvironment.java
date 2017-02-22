package com.redhat.coolstore.util;

public class EnvironmentVariablesEnvironment implements Environment {
	 
	private static final String CART_ID = System.getenv("CART_ID");
	
	private static final String API_GATEWAY_URL = System.getenv("API_GATEWAY");
	
	@Override
	public String getCartId() {
		//TODO: Using a cart-id set via an env variable until we've sorted out authentication.
		return CART_ID;
	}

	@Override
	public String getApiGatewayUrl() {
		return API_GATEWAY_URL;
	}

}
