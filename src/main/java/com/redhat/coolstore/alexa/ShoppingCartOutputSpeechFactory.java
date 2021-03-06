package com.redhat.coolstore.alexa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.redhat.coolstore.api_gateway.model.ShoppingCart;
import com.redhat.coolstore.api_gateway.model.ShoppingCartItem;

public class ShoppingCartOutputSpeechFactory implements OutputSpeechFactory<PlainTextOutputSpeech> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartOutputSpeechFactory.class);
	
	private final String SHOPPING_CART_CONTAINS_TEXT = "Your shopping cart contains, ";
	
	private final String TOTAL_ORDER_AMOUNT_TEXT = "Your total order amount is ";
	
	private final ShoppingCart shoppingCart;
	
	public ShoppingCartOutputSpeechFactory(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	@Override
	public PlainTextOutputSpeech getOutputSpeech() {
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		StringBuilder speechBuilder = new StringBuilder(SHOPPING_CART_CONTAINS_TEXT);
		
		//Items
		if (shoppingCart.shoppingCartItemList.isEmpty()) {
			speechBuilder.append("no items.");
		} else {
			for (ShoppingCartItem nextItem: shoppingCart.shoppingCartItemList) {
				speechBuilder.append(nextItem.quantity).append(" ").append(nextItem.product.getName());
			}
		}
		speechBuilder.append(". ");
		
		//Total value
		speechBuilder.append(TOTAL_ORDER_AMOUNT_TEXT).append(shoppingCart.cartTotal);
		String speechText = speechBuilder.toString();
		LOGGER.debug("SpeechText for ShoppingCart: " +  speechText);
		
		speech.setText(speechBuilder.toString());
		return speech;
	}

}
