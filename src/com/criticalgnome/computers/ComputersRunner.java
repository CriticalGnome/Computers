package com.criticalgnome.computers;

import java.awt.Toolkit;
import java.io.File;

import javax.xml.parsers.ParserConfigurationException;

import com.criticalgnome.computers.beans.Device;
import com.criticalgnome.computers.utils.Constants;
import com.criticalgnome.computers.utils.DOMParser;
import com.criticalgnome.computers.utils.Keyboard;
import com.criticalgnome.computers.utils.MainMenu;
import com.criticalgnome.computers.utils.Parser;
import com.criticalgnome.computers.utils.SAXParser;
import com.criticalgnome.computers.utils.StAXParser;

/**
 * @author CriticalGnome
 *
 */
public class ComputersRunner {
	/**
	 * Main method. Entry point.
	 * 
	 * @param args
	 *            String[]:Command line arguments
	 * @throws Exception
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws Exception {
		File inputFile = new File("bin/com/criticalgnome/computers/xml/Device.xml");
		while (true) {
			MainMenu.printMainMenu();
			switch (Keyboard.inputNumber()) {
			case Constants.DOM_PARSER_CASE:
				Parser parser = new DOMParser();
				Device device1 = parser.parse(inputFile);
				System.out.println(device1);
				break;
			case Constants.SAX_PARSER_CASE:
				SAXParser.parse();
				break;
			case Constants.STAX_PARSER_CASE:
				StAXParser.parse();
				break;
			case Constants.EXIT_CASE:
				System.out.println(Constants.EXIT_MESSAGE);
				System.exit(0);
			default:
				System.out.println(Constants.INVALID_INPUT_MESSAGE);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}
