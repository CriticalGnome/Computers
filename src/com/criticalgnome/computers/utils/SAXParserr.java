package com.criticalgnome.computers.utils;

import java.io.File;
import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.criticalgnome.computers.beans.Device;

import com.criticalgnome.computers.utils.Handler;

public class SAXParserr extends Parser {

	@Override
	public Device parse(File inputFile) throws Exception {
		

		super.parse(inputFile);
		SAXParserFactory parcerFactory = SAXParserFactory.newInstance();
		Handler handler = new Handler();
		
		try {

			SAXParser saxparce = parcerFactory.newSAXParser();
			saxparce.parse(inputFile, handler);
			Device device = Handler.getResult();
			return device;
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
		 // На экран-то выводит, но вот объект не создаёт/ //
						// Сделать объект? // Надо :) в этом окне все сверху
						// перетянуть вниз. Через CTRL-A
	}
}