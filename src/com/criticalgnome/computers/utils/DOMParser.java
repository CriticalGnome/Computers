package com.criticalgnome.computers.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @author CriticalGnome
 *
 */
public class DOMParser {
	public static void parse() throws Exception {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fact.newDocumentBuilder();
		Document doc = builder.parse("bin/com/criticalgnome/computers/xml/Device.xml");
		NodeList list = doc.getElementsByTagName("device");
		System.out.println(list.item(0));
	}
}
