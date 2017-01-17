package com.redhat.coolstore.alexa;

import javax.servlet.annotation.WebServlet;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

/**
 * Main servlet for the Red Hat Coolstore Demo' Alexa interface.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
@WebServlet("/")
public class AlexaCoolstoreSpeechletServlet extends SpeechletServlet {
	
	/**
	 * SerialVersionUID 
	 */
	private static final long serialVersionUID = 1L;

	public AlexaCoolstoreSpeechletServlet() {
		this.setSpeechlet(new AlexaCoolstoreSpeechlet());
	}

}
