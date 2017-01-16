package com.criticalgnome.computers.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import com.criticalgnome.computers.beans.Device;
import com.criticalgnome.computers.beans.Group;
import com.criticalgnome.computers.beans.Port;
import com.criticalgnome.computers.beans.Type;

/**
 * @author CriticalGnome
 *
 */
public class CG_StAXHandler implements XMLStreamConstants {
	int portID = 0;
	static String name;
	static String origin;
	static int price;
	static Group group;
	static boolean peripheral;
	static boolean hasCooler;
	static int energyConsumption;
	static List<Port> ports = new ArrayList<Port>();
	static boolean critical;

	boolean inName, inOrigin, inPrice, inGroup, inPeripheral, inHasCooler, inEnergyConsumption, inPort, inCritical;

	public static Device getResult() {
		Type type = new Type.Builder().group(group).peripheral(peripheral).hasCooler(hasCooler)
				.energyConsumption(energyConsumption).ports(ports).build();
		Device device = new Device.Builder().name(name).origin(origin).price(price).type(type).critical(critical)
				.build();
		return device;
	}

	public void processElement(XMLStreamReader element) {
		switch (element.getLocalName()) {
		case "name":
			inName = true;
			break;
		case "origin":
			inOrigin = true;
			break;
		case "price":
			inPrice = true;
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
		case "energy-consumption":
			inEnergyConsumption = true;
			break;
		case "port":
			inPort = true;
			break;
		case "critical":
			inCritical = true;
			break;
		}
	}

	public void processText(String text) {
		if (inName) {
			name = text;
			inName = false;
		} else if (inOrigin) {
			origin = text;
			inOrigin = false;
		} else if (inPrice) {
			price = new Integer(text);
			inPrice = false;
		} else if (inGroup) {
			group = Group.valueOf(text);
			inGroup = false;
		} else if (inPeripheral) {
			if (text.equals("true")) {
				peripheral = true;
			} else {
				peripheral = false;
			}
			inPeripheral = false;
		} else if (inHasCooler) {
			if (text.equals("true")) {
				hasCooler = true;
			} else {
				hasCooler = false;
			}
			inHasCooler = false;
		} else if (inEnergyConsumption) {
			energyConsumption = new Integer(text);
			inEnergyConsumption = false;
		} else if (inPort) {
			Port port = new Port(portID, text);
			portID++;
			ports.add(port);
			inPort = false;
		} else if (inCritical) {
			if (text.equals("true")) {
				critical = true;
			} else {
				critical = false;
			}
			inCritical = false;
		}
	}
}
