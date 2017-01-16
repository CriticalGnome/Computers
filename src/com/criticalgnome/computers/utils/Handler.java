package com.criticalgnome.computers.utils;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.criticalgnome.computers.beans.Device;
import com.criticalgnome.computers.beans.Group;
import com.criticalgnome.computers.beans.Port;
import com.criticalgnome.computers.beans.Type;

public class Handler extends DefaultHandler {

	String obj = "";
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

	public static Device getResult() {
		Type type = new Type.Builder().group(group).peripheral(peripheral).hasCooler(hasCooler)
				.energyConsumption(energyConsumption).ports(ports).build();
		Device device = new Device.Builder().name(name).origin(origin).price(price).type(type).critical(critical)
				.build();
		return device;
	}

	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void startElement(String namespace, String localName, String qName, Attributes attr) {

		obj = qName;

	}

	@Override

	public void endElement(String namespace, String localName, String qName) throws SAXException {
		obj = "";
	}

	@Override
	public void characters(char[] ch, int start, int end) {

		if (obj.equals("name")) {
			name = new String(ch, start, end);
		}
		if (obj.equals("origin")) {
			origin = new String(ch, start, end);
		}
		if (obj.equals("price")) {
			price = new Integer(new String(ch, start, end));
		}
		if (obj.equals("group")) {
			group = Group.valueOf(new String(ch, start, end));
		}
		if (obj.equals("peripheral")) {
			if ((new String(ch, start, end)).equals("true")) {
				peripheral = true;
			} else {
				peripheral = false;
			}
		}
		if (obj.equals("has-cooler")) {
			if ((new String(ch, start, end)).equals("true")) {
				hasCooler = true;
			} else {
				hasCooler = false;
			}
		}
		if (obj.equals("energy-consumption")) {
			energyConsumption = new Integer(new String(ch, start, end));
		}
		if (obj.equals("port")) {
			Port port = new Port(portID, (new String(ch, start, end)));
			portID++;
			ports.add(port);
		}
		if (obj.equals("critical")) {
			if ((new String(ch, start, end)).equals("true")) {
				critical = true;
			} else {
				critical = false;
			}
		}

	}
}