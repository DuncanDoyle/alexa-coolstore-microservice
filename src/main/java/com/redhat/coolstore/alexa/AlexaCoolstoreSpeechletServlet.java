package com.redhat.coolstore.alexa;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

/**
 * Main servlet for the Red Hat Coolstore Demo' Alexa interface.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
@WebServlet("/")
public class AlexaCoolstoreSpeechletServlet extends SpeechletServlet {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AlexaCoolstoreSpeechletServlet.class);
	
	@Inject
	private AlexaCoolstoreSpeechlet speechlet;
	
	/**
	 * SerialVersionUID 
	 */
	private static final long serialVersionUID = 1L;

	public AlexaCoolstoreSpeechletServlet() {
		LOGGER.info("Bootstrapping Coolstore Alexa Skill.");
	}
	
	@PostConstruct
	public void init() {
		LOGGER.info("Post constructing skill. Setting speechlet: " + speechlet);
		this.setSpeechlet(speechlet);
	}

}
