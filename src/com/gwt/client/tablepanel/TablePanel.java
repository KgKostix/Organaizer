package com.gwt.client.tablepanel;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwt.client.posform.PosForm;
import com.gwt.shared.task.Task;

public class TablePanel extends VerticalPanel {

	public TablePanel() {
		super();
		HorizontalPanel buttonPanel = new HorizontalPanel();
		Button addButton = new Button("Add");
		Button copyButton = new Button("Copy");
		Button deleteButton = new Button("Delete");
		addButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				PosForm posForm = new PosForm();
				posForm.setDataProvider(dataProvider);
				posForm.show();				
			}
		});
		
		copyButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				PosForm posForm = new PosForm();
				posForm.setCurentTask(selectedTask);
				posForm.setDataProvider(dataProvider);
				posForm.show();				
			}
		});
		
		deleteButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				if (selectedTask != null) {					
					dataProvider.getList().remove(selectedTask);					
				} 
			}
		});
		
		buttonPanel.add(addButton);
		buttonPanel.add(copyButton);
		buttonPanel.add(deleteButton);
		add(buttonPanel);
		
		CellTable<Task> taskTable = new CellTable<Task>();

	    taskTable.setAutoFooterRefreshDisabled(false);
	    taskTable.setAutoHeaderRefreshDisabled(false);
		taskTable.setWidth("100%", true);
		
		// Add a selection model to handle user selection.
        final SingleSelectionModel<Task> selectionModel = new SingleSelectionModel<Task>();
        taskTable.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
            	selectedTask = selectionModel.getSelectedObject();
            }
        });
        
		taskTable.addDomHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				PosForm posForm = new PosForm();
				posForm.setCurentTask(selectedTask);
				posForm.setDataProvider(dataProvider);
				posForm.show();		
			}
		}, DoubleClickEvent.getType());
		
		
		SimplePager  pager = new SimplePager();
		pager.setDisplay(taskTable);

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
	    
	    dataProvider = new ListDataProvider<Task>();
	    
	    java.util.List<Task> list = dataProvider.getList();
	    for (int i = 0; i < 10; i++) {
	    	list.add(new Task("subject " + i, "text " +i));	
	    }
	 
	    dataProvider.addDataDisplay(taskTable);	   
	    taskTable.setVisibleRange(0, 15);
	    add(taskTable);
	    add(pager);		
	}
	
	private Task selectedTask = null;
	private ListDataProvider<Task> dataProvider = null;
}
