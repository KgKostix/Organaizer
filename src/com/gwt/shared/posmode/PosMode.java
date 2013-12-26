package com.gwt.shared.posmode;

public enum PosMode {
	
	EDIT_MODE("edit_mode", 1),
	
	ADD_MODE("add_mode", 2),
	
	COPY_MODE("copy_mode", 3),
	
	UNKNOWN_MODE("unknown_mode", 0);
	
	PosMode(String name, int edit_mode) {
		this.name = name;
		this.edit_mode = edit_mode;
	}
	
	private String name;
	private int edit_mode;
}
