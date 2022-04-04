package pacopaquetes;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Auxiliary class that allow us to test with modifiable and controlled dates
 * 
 * @author PADSOF Teachers
 *
 */
public class ModifiableDate implements Serializable {

	// Default initialization. DO NOT CHANGE
	private static LocalDate modifiableDate = LocalDate.now().withDayOfMonth(12).withMonth(2).withYear(2016);

	/**
	 * This function is used to add a specific number of days to the date.
	 * 
	 * @param numDays Number of days we want to increase
	 */
	public static void plusDays(int numDays) {
		modifiableDate = modifiableDate.plusDays(numDays);
	}

	/**
	 * To set 'today' as the modifiable date
	 */
	public static void setToday() {
		modifiableDate = LocalDate.now();
	}

	/**
	 * This function returns the current modifiable date.
	 * 
	 * @return Current modifiable date
	 */
	public static LocalDate getModifiableDate() {
		return modifiableDate;
	}

	/**
	 * To set the modifiable date to a specific values given the day, month and year
	 * as parameters.
	 * 
	 * @param day   The day for the new modifiable date
	 * @param month The month for the modifiable date
	 * @param year  The year for the modifiable date
	 * @return The current modifiable date with the values specified as parameters
	 */
	public static LocalDate setDate(int day, int month, int year) {
		modifiableDate = modifiableDate.withDayOfMonth(day).withMonth(month).withYear(year);
		return modifiableDate;
	}

	public int compareTo(ModifiableDate fecha) {
		return 0;
	}

}