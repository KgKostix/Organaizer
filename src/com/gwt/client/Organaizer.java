package com.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.client.tablepanel.TablePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Organaizer implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		headerPanel = RootPanel.get("headerContainer");
		leftPanel = RootPanel.get("leftContainer");
		rightPanel = RootPanel.get("rightContainer");
		errorPanel = RootPanel.get("errorContainer");
		
		rightPanel.add(new TablePanel());
	}
	
	public RootPanel headerPanel = null;
	public RootPanel leftPanel = null;
	public RootPanel rightPanel = null;
	public RootPanel errorPanel = null;

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

}
