package com.criticalgnome.computers.utils;

import java.io.File;

import com.criticalgnome.computers.beans.Device;

public class StAXParser extends Parser {
	@Override
	public Device parse(File inputFile) throws Exception {
		super.parse(inputFile);
		System.out.print("Not realized: ");
		return null;
	}
}
