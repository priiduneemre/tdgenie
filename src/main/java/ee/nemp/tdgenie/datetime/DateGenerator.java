package ee.nemp.tdgenie.datetime;

import java.sql.Date;

public class DateGenerator extends DateTimeGenerator<Date> {

	@Override
	public Date getRndValue(String minDate, String maxDate){
		long minDateMillis = Date.valueOf(minDate).getTime();
		long maxDateMillis = Date.valueOf(maxDate).getTime();
		
		long rndDateRangeMillis = maxDateMillis - minDateMillis + 1;
		Date rndDate = new Date(minDateMillis + (long)(getRndSeed().nextDouble() * rndDateRangeMillis));
		
		return rndDate;
	}
}
