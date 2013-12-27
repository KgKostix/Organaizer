package com.gwt.server.tablepanel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.client.tablepanel.TablePanelServaice;
import com.gwt.shared.task.Task;

@SuppressWarnings("serial")
public class TablePanelServiceImpl extends RemoteServiceServlet implements
		TablePanelServaice {

	@Override
	public List<Task> getTaskList(long userId, Date dataEvent) {
		List<Task> taskList = new ArrayList<Task>();
		for (int i = 0; i <= 10; i++) {			
			taskList.add(new Task(0,"List task from server " + i,"List task from server", new Date()));
		}
		return taskList;
	}

	@Override
	public Task getTask(long taskId) {
		return new Task(0, "Task from server", "Task from server", new Date());
	}

}
