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

/**
 * @author CriticalGnome
 *
 */
public class CG_SAXHandler extends DefaultHandler {

	String thisElement = "";
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
	public void endDocument() {

	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		thisElement = qName;
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		thisElement = "";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (thisElement.equals("name")) {
			name = new String(ch, start, length);
		}
		if (thisElement.equals("origin")) {
			origin = new String(ch, start, length);
		}
		if (thisElement.equals("price")) {
			price = new Integer(new String(ch, start, length));
		}
		if (thisElement.equals("group")) {
			group = Group.valueOf(new String(ch, start, length));
		}
		if (thisElement.equals("peripheral")) {
			if ((new String(ch, start, length)).equals("true")) {
				peripheral = true;
			} else {
				peripheral = false;
			}
		}
		if (thisElement.equals("has-cooler")) {
			if ((new String(ch, start, length)).equals("true")) {
				hasCooler = true;
			} else {
				hasCooler = false;
			}
		}
		if (thisElement.equals("energy-consumption")) {
			energyConsumption = new Integer(new String(ch, start, length));
		}
		if (thisElement.equals("port")) {
			Port port = new Port(portID, (new String(ch, start, length)));
			portID++;
			ports.add(port);
		}
		if (thisElement.equals("critical")) {
			if ((new String(ch, start, length)).equals("true")) {
				critical = true;
			} else {
				critical = false;
			}
		}
	}
}
