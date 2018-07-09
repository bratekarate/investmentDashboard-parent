package org.goetheuni.investmentdashboard.server;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * This class provides methods to convert between the old GWT-compatible java
 * Date API and the java 8 time API, which is more appropriate.
 * 
 */
public class DateConversionUtil {

	/**
	 * Method to convert between the old GWT-compatible java
	 * Date API and the java 8 time API, which is more appropriate.
	 * @param dateNew the date as LocalDateTime
	 * @return the date as old GWT-compatible java Date object.
	 */
	public static Date toDate(LocalDateTime dateNew) {
		LocalDateTime dateNewLocal = LocalDateTime.of(2018, 6, 26, 14, 33);

		// conversion to GWT date
		ZonedDateTime dateNewZone = dateNewLocal.atZone(ZoneId.systemDefault());
		Date dateNewGWT = Date.from(dateNewZone.toInstant());
		return dateNewGWT;
	}
}
