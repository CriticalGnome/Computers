package com.criticalgnome.computers.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author CriticalGnome
 *
 */
public class DOMParser extends Parser {

	@Override
	public void parse() throws Exception {
		super.parse();
		try {
			File inputFile = new File("bin/com/criticalgnome/computers/xml/Device.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			Node nNode = doc.getFirstChild();
			Element eElement = (Element) nNode;
			System.out.println("Name:\t\t\t" + eElement.getElementsByTagName("name").item(0).getTextContent());
			System.out.println("Origin:\t\t\t" + eElement.getElementsByTagName("origin").item(0).getTextContent());
			System.out.println("Price:\t\t\t" + eElement.getElementsByTagName("price").item(0).getTextContent());
			System.out.println("Group:\t\t\t" + eElement.getElementsByTagName("group").item(0).getTextContent());
			System.out
					.println("Peripheral:\t\t" + eElement.getElementsByTagName("peripheral").item(0).getTextContent());
			System.out
					.println("Has Cooler:\t\t" + eElement.getElementsByTagName("has-cooler").item(0).getTextContent());
			System.out.println("Energy Consumption:\t"
					+ eElement.getElementsByTagName("energy-consumption").item(0).getTextContent());
			NodeList nList = doc.getElementsByTagName("port");
			System.out.print("Ports(" + nList.getLength() + "):\t\t");
			for (int i = 0; i < nList.getLength(); i++) {
				Element eElementPort = (Element) nList.item(i);
				System.out.print(eElementPort.getTextContent());
				if ((i + 1) < nList.getLength()) {
					System.out.print(", ");
				}
			}
			System.out.println("");
			System.out.println("Critical:\t\t" + eElement.getElementsByTagName("critical").item(0).getTextContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
