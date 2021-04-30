package guia05.infrastructure;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public abstract class Utils {
	public static String InstantToDateString(Instant instant) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault()).format(instant);
	}
}
