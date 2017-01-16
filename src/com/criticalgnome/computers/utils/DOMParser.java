package com.criticalgnome.computers.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.criticalgnome.computers.beans.Device;
import com.criticalgnome.computers.beans.Group;
import com.criticalgnome.computers.beans.Port;
import com.criticalgnome.computers.beans.Type;;

/**
 * @author CriticalGnome
 *
 */
public class DOMParser extends Parser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.criticalgnome.computers.utils.Parser#parse(java.io.File)
	 */
	@Override
	public Device parse(File inputFile) throws Exception {
		super.parse(inputFile);
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			Node nNode = doc.getFirstChild();
			Element eElement = (Element) nNode;
			String name = eElement.getElementsByTagName("name").item(0).getTextContent();
			String origin = eElement.getElementsByTagName("origin").item(0).getTextContent();
			int price = Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent());
			Group group = Group.valueOf(eElement.getElementsByTagName("group").item(0).getTextContent().toUpperCase());
			boolean peripheral;
			if (eElement.getElementsByTagName("peripheral").item(0).getTextContent().equals("true")) {
				peripheral = true;
			} else {
				peripheral = false;
			}
			boolean hasCooler;
			if (eElement.getElementsByTagName("has-cooler").item(0).getTextContent().equals("true")) {
				hasCooler = true;
			} else {
				hasCooler = false;
			}
			int energyConsumption = Integer
					.parseInt(eElement.getElementsByTagName("energy-consumption").item(0).getTextContent());
			NodeList nList = doc.getElementsByTagName("port");
			List<Port> ports = new ArrayList<Port>();
			for (int i = 0; i < nList.getLength(); i++) {
				Element eElementPort = (Element) nList.item(i);
				Port port = new Port(i, eElementPort.getTextContent());
				ports.add(port);
			}
			boolean critical;
			if (eElement.getElementsByTagName("critical").item(0).getTextContent().equals("true")) {
				critical = true;
			} else {
				critical = false;
			}

			Type type = new Type.Builder().group(group).peripheral(peripheral).hasCooler(hasCooler)
					.energyConsumption(energyConsumption).ports(ports).build();
			Device device = new Device.Builder().name(name).origin(origin).price(price).type(type).critical(critical)
					.build();
			return device;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
