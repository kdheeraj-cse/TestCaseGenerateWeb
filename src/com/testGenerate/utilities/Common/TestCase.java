package com.testGenerate.utilities.Common;

import java.util.ArrayList;

public class TestCase {
private ArrayList<String> objTestSteps = new ArrayList<>(); 
public ArrayList<ArrayList<Integer>> objArrayListoftestStep = new ArrayList<>();

public ArrayList<String> getObjTestSteps() {
	return objTestSteps;
}
public void setObjTestSteps(String input) {
	objTestSteps.add(input);
}
}
