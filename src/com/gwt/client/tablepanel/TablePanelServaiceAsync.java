package com.gwt.client.tablepanel;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt.shared.task.Task;

public interface TablePanelServaiceAsync {

	void getTask(long taskId, AsyncCallback<Task> callback);

	void getTaskList(long userId, Date dataEvent,
			AsyncCallback<List<Task>> callback);

}
