package com.criticalgnome.computers.utils;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import com.criticalgnome.computers.beans.Device;

/**
 * @author CriticalGnome
 *
 */
public class CG_StAXParser extends Parser {
	public Device parse(File inputFile) {
		System.out.println("Magic number detected! Activatind DARK FORCE!");
		System.out.println("Start alternate StAX Parser by CriticalGnome");
		CG_StAXHandler handler = new CG_StAXHandler();
		try {
			FileInputStream inStream = new FileInputStream(inputFile);
			XMLStreamReader xmlReader = XMLInputFactory.newInstance().createXMLStreamReader(inStream);
			int event;
			while (xmlReader.hasNext()) {
				event = xmlReader.next();
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					handler.processElement(xmlReader);
					break;
				case XMLStreamConstants.CHARACTERS:
					handler.processText(xmlReader.getText());
				}
			}
			Device device = CG_StAXHandler.getResult();
			return device;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
