package com.criticalgnome.computers.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.criticalgnome.computers.beans.Device;

public class SAXParser extends Parser {
	@Override
	public Device parse(File inputFile) throws Exception {
		super.parse(inputFile);
		SAXParserFactory parcerFactory = SAXParserFactory.newInstance();
		Handler handler = new Handler();
		try {

			SAXParser saxparce = parcerFactory.newSAXParser();
			saxparce.parse(inputFile, handler);
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null; // Нужно возвращать Device Проверю push
		}
}