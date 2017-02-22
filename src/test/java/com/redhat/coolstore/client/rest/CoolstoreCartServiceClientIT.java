package com.redhat.coolstore.client.rest;

import java.lang.reflect.Field;

import javax.ws.rs.client.ClientBuilder;

import org.junit.BeforeClass;
import org.junit.Test;

import com.redhat.coolstore.api_gateway.model.ShoppingCart;
import com.redhat.coolstore.util.Environment;

public class CoolstoreCartServiceClientIT {

	@BeforeClass
	public static void init() {
		//Set the default JAX-RS implementation to RESTEasy.
		System.setProperty(ClientBuilder.JAXRS_DEFAULT_CLIENT_BUILDER_PROPERTY, "org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder");
	}
	
	@Test
	public void testGetShoppingCart() throws Exception {
		CoolstoreCartServiceClient client = new CoolstoreCartServiceClient();
		
		//Set our mock environment with test environment prooperties.
		Field environment = client.getClass().getDeclaredField("environment");
		environment.setAccessible(true);
		environment.set(client, new Environment() {
			@Override
			public String getCartId() {
				return "1";
			}
			
			@Override
			public String getApiGatewayUrl() {
				//Location of our test NGINX. This is an integration test, not a unit-test. It requires a running environment.
				return "http://localhost:8081";
			}
		});
		
		
		ShoppingCart shoppingCart = client.getShoppingCart("1");
		
		System.out.println("ShoppingCart: " + shoppingCart);
	}
	
}
