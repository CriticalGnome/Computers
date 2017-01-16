package com.criticalgnome.computers.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.criticalgnome.computers.beans.Device;

/**
 * @author CriticalGnome
 *
 */
public class CG_SAXParser extends Parser {
	public Device parse(File inputFile) throws ParserConfigurationException, SAXException, IOException {
		System.out.println("Magic number detected! Activatind DARK FORCE!");
		System.out.println("Start alternate SAX Parser by CriticalGnome");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		CG_SAXHandler saxp = new CG_SAXHandler();
		parser.parse(inputFile, saxp);
		Device device = CG_SAXHandler.getResult();
		return device;
	}
}