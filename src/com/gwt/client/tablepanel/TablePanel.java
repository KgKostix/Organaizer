package com.gwt.client.tablepanel;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.gwt.shared.task.Task;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
		
		CellTable<Task> taskTable = new CellTable<Task>();
		
		// Create subject column.
	    TextColumn<Task> subjectColumn = new TextColumn<Task>() {
	      @Override
	      public String getValue(Task task) {
	        return task.getSubject();
	      }
	    };
	    
		// Create subject column.
	    TextColumn<Task> textColumn = new TextColumn<Task>() {
	      @Override
	      public String getValue(Task task) {
	        return task.getText();
	      }
	    };
	    
	    
	    taskTable.addColumn(subjectColumn, "Subject");
	    taskTable.addColumn(textColumn, "Text");
	    taskTable.setColumnWidth(subjectColumn, 30, Unit.PCT);
	    taskTable.setColumnWidth(textColumn, 70, Unit.PCT);
	    	    
	    ListDataProvider<Task> listProvider = new ListDataProvider<Task>();
	    listProvider.addDataDisplay(taskTable);
	    
	    java.util.List<Task> list = listProvider.getList();
	    for (int i = 0; i < 100; i++) {
	    	list.add(new Task("subject " + i, "text " +i));	
	    }
	    
	    taskTable.setRowCount(list.size(), true);
	    taskTable.setVisibleRange(0, 50);
	    
	    add(taskTable);
	}
}
