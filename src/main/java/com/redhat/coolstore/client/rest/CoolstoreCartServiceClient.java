package com.redhat.coolstore.client.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.coolstore.api_gateway.model.ShoppingCart;
import com.redhat.coolstore.util.Environment;

/**
 * Simple JAX-RS client for the ShoppingCartService.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
@ApplicationScoped
public class CoolstoreCartServiceClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(CoolstoreCartServiceClient.class);
	
	@Inject
	private Environment environment;
	
	private Client client = ClientBuilder.newClient();
	
	public ShoppingCart getShoppingCart(String cartId) {
		
		WebTarget target = client.target(environment.getApiGatewayUrl() + "/api/cart/{cart-id}").resolveTemplate("cart-id", cartId);
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		//Can use the builder to add additional headers. For now we just fire a simple Get request.
		Response response = builder.get();
		
		ShoppingCart shoppingCart = null;
		//If we don't get a 200, we return an Alexa Error message.
		if (response.getStatus() == 200) {
			shoppingCart = response.readEntity(ShoppingCart.class);
		} else {
			throw new RuntimeException("Unexpected reponse from the Coolstore Gateway.");
		}
		return shoppingCart;
	}
	
}
