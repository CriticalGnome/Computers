package com.criticalgnome.computers.utils;

public class ParserFabric {
	public static Parser createParser(int inputNumber) {
		Parser parser = null;
		switch (inputNumber) {
		case Constants.DOM_PARSER_CASE:
			parser = new DOMParser();
			break;
		case Constants.SAX_PARSER_CASE:
			parser = new SAXParser();
			break;
		case Constants.STAX_PARSER_CASE:
			parser = new SAXParser();
			break;
		}
		return parser;
	}
}
