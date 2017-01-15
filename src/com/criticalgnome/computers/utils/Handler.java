package com.criticalgnome.computers.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parsing... ");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end parsing... ");
	}

	@Override
	public void startElement(String namespace, String localName, String qName, Attributes attr) {
	}

	@Override

	public void endElement(String namespace, String localName, String qName) throws SAXException {

	}

	@Override
	public void characters(char[] ch, int start, int end) {
		String str = new String(ch, start, end);
		System.out.println(str);
	}

}