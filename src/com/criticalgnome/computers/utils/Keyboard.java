package com.criticalgnome.computers.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author CriticalGnome
 *
 */
public class Keyboard {

	public static Scanner in = new Scanner(System.in);

	/**
	 * Input number from keyboard.
	 *
	 * @return the int
	 */
	public static int inputNumber() {
		int number = -1;
		in = new Scanner(System.in);
		try {
			number = in.nextInt();
		} catch (InputMismatchException e) {
			number = -1;
		}
		return number;
	}
}
