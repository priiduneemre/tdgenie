package ee.nemp.tdgenie.datetime;

import java.sql.Timestamp;

public class TimestampGenerator extends DateTimeGenerator<Timestamp> {

	@Override
	public Timestamp getRndValue(String minTimestamp, String maxTimestamp){
		long minTimestampMillis = Timestamp.valueOf(minTimestamp).getTime();
		long maxTimestampMillis = Timestamp.valueOf(maxTimestamp).getTime();
		
		long rndTimestampRangeMillis = maxTimestampMillis - minTimestampMillis + 1;
		Timestamp rndTimestamp = new Timestamp(minTimestampMillis + 
				(long)(getRndSeed().nextDouble() * rndTimestampRangeMillis));
		//Truncate the subsecond part from the timestamp
		rndTimestamp.setTime(rndTimestamp.getTime() - 
				(rndTimestamp.getTime() % DateTimeGenerator.MILLISECONDS_IN_SECOND));
				
		return rndTimestamp;		
	}
}
