package com.gwt.client.tablepanel;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TablePanel extends VerticalPanel {

	public TablePanel() {
		super();
		HorizontalPanel buttonPanel = new HorizontalPanel();
		Button addButton = new Button("Add");
		Button copyButton = new Button("Copy");
		Button deleteButton = new Button("Delete");
		
		buttonPanel.add(addButton);
		buttonPanel.add(copyButton);
		buttonPanel.add(deleteButton);
		
		add(buttonPanel);
	}
}
