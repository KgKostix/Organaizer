package com.gwt.client.tablepanel;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwt.shared.task.Task;

@RemoteServiceRelativePath("tablepanel")
public interface TablePanelServaice extends RemoteService {

	public List<Task> getTaskList(long userId, Date dataEvent);
	
	public Task getTask(long taskId);

}
