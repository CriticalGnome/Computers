package com.criticalgnome.computers;

import java.awt.Toolkit;
import java.io.File;

import javax.xml.parsers.ParserConfigurationException;

import com.criticalgnome.computers.beans.Device;
import com.criticalgnome.computers.utils.Constants;
import com.criticalgnome.computers.utils.Keyboard;
import com.criticalgnome.computers.utils.MainMenu;
import com.criticalgnome.computers.utils.Parser;
import com.criticalgnome.computers.utils.ParserFabric;

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
		File inputFile = new File(Constants.XML_FILE);
		while (true) {
			MainMenu.printMainMenu();
			int inputNumber = Keyboard.inputNumber();
			if (inputNumber == Constants.EXIT_CASE) {
				System.out.println(Constants.EXIT_MESSAGE);
				System.exit(0);
			}
			if (inputNumber > Constants.MIN_KEYBOARD_INPUT_RANGE && inputNumber < Constants.MAX_KEYBOARD_INPUT_RANGE) {
				Parser parser = ParserFabric.createParser(inputNumber);
				Device device = parser.parse(inputFile);
				System.out.println(device);
			} else {
				System.out.println(Constants.INVALID_INPUT_MESSAGE);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}
