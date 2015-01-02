package com.testGenerate.utilities;

import java.util.ArrayList;

public class ExcelColumn {
	private String columnName;
	private ArrayList<String> columnValues = new ArrayList<String>();

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnValues(Integer columnIndex) {
		return columnValues.get(columnIndex);
	}

	public void setColumnValues(String columnVal) {
		columnValues.add(columnVal);
	}

	public Integer getColumnValuesSize() {
		return columnValues.size();
	}

}
