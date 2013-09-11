package ee.nemp.tdgenie.datetime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ee.nemp.tdgenie.base.RandomGenerator;

public abstract class DateTimeGenerator<T extends Comparable<? super T>> extends RandomGenerator<T> {

	//Constants
	public static final int MILLISECONDS_IN_SECOND = 1000;
	
	//Instance variables
	String minDateTime;
	String maxDateTime;
	
	
	public abstract T getRndValue(String minDateTime, String maxDateTime);
	
	@Override
	public List<T> getValues(int valueCount) {
		List<T> rndValues = new ArrayList<T>(valueCount);
		Set<T> prevUsedValues = new HashSet<T>();
		
		while(rndValues.size() < valueCount){
			T curValue = getRndValue(minDateTime, maxDateTime);
			if(isOutputUnique()){
				if(prevUsedValues.contains(curValue)){
					continue; 
				}
			}
			if(isOutputNullable()){
				if(getRndSeed().nextDouble() <= ((double)getNullFrequency()/100)){
					rndValues.add(null);
					continue;
				}
			}
			rndValues.add(curValue);
			prevUsedValues.add(curValue);
		}
		
		return rndValues;
	}
	
	//[START]GETTERS AND SETTERS
	public String getMinDateTime() {
		return minDateTime;
	}
	public DateTimeGenerator<T> setMinDateTime(String minDateTime) {
		this.minDateTime = minDateTime;
		return this;
	}
	public String getMaxDateTime() {
		return maxDateTime;
	}
	public DateTimeGenerator<T> setMaxDateTime(String maxDateTime) {
		this.maxDateTime = maxDateTime;
		return this;
	}
	//[END]GETTERS AND SETTERS
}