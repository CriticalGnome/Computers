package com.criticalgnome.computers.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.criticalgnome.computers.beans.*;

public class StAXParser extends Parser implements XMLStreamConstants {
	
	private static Device result;
	private String name;
	private String origin;
	private int price;
	private Type type;
	private Group group;
	private boolean peripheral;
	private boolean hasCooler;
	private int energyConsumption;
	private boolean critical;
	private ArrayList <Port> ports;
	int id;
	
	boolean inName, inOrigin, inPrice, inCritical, inType, inGroup, inPeripheral, inHasCooler, inEnergyConsumption, inPorts;
	
	public Device parse(File inputFile) {
		
		StAXParser2 handler = new StAXParser2();
		try {
			FileInputStream inStream = new FileInputStream(inputFile);
			XMLStreamReader xmlReader =
					XMLInputFactory.newInstance().
							createXMLStreamReader(inStream);
			int event;
			while (xmlReader.hasNext()) {
				event = xmlReader.next();
				switch (event) {
				case START_ELEMENT:
					handler.processElement(xmlReader);
					break;
				case CHARACTERS:
					handler.processText(xmlReader.getText());
					break;
				case END_ELEMENT:
					handler.finishElement(xmlReader.getLocalName());
				}
			}
			xmlReader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	private void processElement(XMLStreamReader element) throws XMLStreamException {

		switch (element.getLocalName()) {
		case "device":
			//device = new Device();
			break;
		case "name":
			inName = true;
			break;
		case "type":
			type = new Type();
			break;
		case "origin":
			inOrigin = true;
			break;
		case "price":
			inPrice = true;
			break;
		case "critical":
			inCritical = true;
			break;
		case "group":
			inGroup = true;
			break;
		case "peripheral":
			inPeripheral = true;
			break;
		case "has-cooler":
			inHasCooler = true;
			break;
		case "energyConsumption":
			inEnergyConsumption = true;
			break;
		case "port-list":
			ports = new ArrayList <Port> ();
			break;
		case "port":
			inPorts = true;
			break;
		}
	}

	private void processText(String text) {

		if (inName) {
			name = text;
			inName = false;
		} else if (inOrigin) {
			origin = text;
			inOrigin = false;
		} else if (inPrice) {
			price = (Integer.parseInt(text));
			inPrice = false;
		} else if (inCritical) {
			critical = (Boolean.parseBoolean(text));
			inCritical = false;
		} else if (inGroup) {
			group = Group.valueOf(text.toUpperCase());
			type.setGroup(group);
			inGroup = false;
		} else if (inPeripheral) {
			peripheral = (Boolean.parseBoolean(text));
			inPeripheral = false;
		} else if (inHasCooler) {
			hasCooler = (Boolean.parseBoolean(text));
			inHasCooler = false;
		} else if (inEnergyConsumption) {
			energyConsumption = (Integer.parseInt(text));
			inEnergyConsumption = false;
		} else if (inPorts) {
			ports.add(new Port(id++, text));
			inPorts = false;
		}
	}

	private void finishElement(String name) {

		switch (name) {
		case "device":
			result = new Device.Builder().name(name).origin(origin).price(price).type(type).critical(critical)
			.build();
			break;
		case "type":
			type = new Type.Builder().group(group).peripheral(peripheral).hasCooler(hasCooler)
			.energyConsumption(energyConsumption).ports(ports).build();
			break;
		}
	}
}
