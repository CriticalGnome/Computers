package com.criticalgnome.computers.utils;

/**
 * @author CriticalGnome
 *
 */
public class MainMenu {

	/**
	 * Print main menu to console
	 */
	public static void printMainMenu() {
		System.out.println(Constants.THIСK_LINE);
		System.out.println("1. DOM-парсер (Сергей Калиновский)");
		System.out.println("2. SAX-парсер (Влад Сытый)");
		System.out.println("3. StAX-парсер (Константин Климов)");
		System.out.println("0. Выход");
		System.out.println(Constants.THIN_LINE);
	}

}
