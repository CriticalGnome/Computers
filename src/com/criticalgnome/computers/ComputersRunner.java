package com.criticalgnome.computers;

import java.awt.Toolkit;

import com.criticalgnome.computers.utils.Constants;
import com.criticalgnome.computers.utils.DOMParser;
import com.criticalgnome.computers.utils.Keyboard;
import com.criticalgnome.computers.utils.MainMenu;

public class ComputersRunner {
	/**
	 * Main method. Entry point.
	 * 
	 * @param args
	 *            String[]:Command line arguments
	 */
	public static void main(String[] args) {
		while (true) {
			MainMenu.printMainMenu();
			switch (Keyboard.inputNumber()) {
			case Constants.DOM_PARSER_CASE:
				DOMParser.parse();
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
