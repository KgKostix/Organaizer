package com.gwt.client.posform;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.gwt.shared.task.Task;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class PosForm extends DialogBox {

	public PosForm() {
		this(new CaptionImpl());
	}

	public PosForm(Caption captionWidget) {
		this(false, false, captionWidget);
	}
	
	public PosForm(boolean autoHide, boolean modal, Caption captionWidget) {
		super(autoHide, modal, captionWidget);
		setAnimationEnabled(true);
		setGlassEnabled(true);
		setText("Task");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setSpacing(4);
		
		Button btnClose = new Button("Close");
		Button btnSave = new Button("Save");
		btnClose.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		btnSave.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				dataProvider.getList().add(
						new Task(subjectText.getValue(), text.getValue()));
				hide();
			}
		});			
		
		buttonPanel.add(btnClose);
		buttonPanel.add(btnSave);
		HorizontalPanel subjectPanel = new HorizontalPanel();
		subjectPanel.setSpacing(4);
		subjectPanel.add(new Label("Subject:"));
		subjectText = new TextBox();		
		subjectPanel.add(subjectText);
		verticalPanel.add(subjectPanel);
		
		text = new TextArea();
		text.setSize("200" + Unit.PX, "200" + Unit.PX);
		verticalPanel.add(text);
		verticalPanel.add(buttonPanel);
		setWidget(verticalPanel);
		center();
	}
	
	
	@Override
	public void show() {
		fill();
		super.show();
	}

	public void fill() {
		if (curentTask != null) {
			subjectText.setValue(curentTask.getSubject());
			text.setValue(curentTask.getText());			
		}		
	}
	
	public Task getCurentTask() {
		return curentTask;
	}

	public void setCurentTask(Task curentTask) {
		this.curentTask = curentTask;
	}
	
	
	public ListDataProvider<Task> getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(ListDataProvider<Task> dataProvider) {
		this.dataProvider = dataProvider;
	}


	private Task curentTask = null;	
	private TextBox subjectText = null;
	private TextArea text = null;
	private ListDataProvider<Task> dataProvider = null;
}
