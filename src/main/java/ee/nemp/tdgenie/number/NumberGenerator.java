package ee.nemp.tdgenie.number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ee.nemp.tdgenie.base.RandomGenerator;

public abstract class NumberGenerator<T extends Comparable<? super T>> extends RandomGenerator<T> {
	
	//Instance variables
	private T minValue;
	private T maxValue;
	
	
	public abstract T getRndValue(T minValue, T maxValue);
	
	public List<T> getValues(int valueCount){
		List<T> rndValues = new ArrayList<T>(valueCount);
		Set<T> prevUsedValues = new HashSet<T>();
		
		while(rndValues.size() < valueCount){
			T curValue = getRndValue(minValue, maxValue);
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
	public T getMinValue() {
		return minValue;
	}
	public NumberGenerator<T> setMinValue(T minValue) {
		this.minValue = minValue;
		return this;
	}
	public T getMaxValue() {
		return maxValue;
	}
	public NumberGenerator<T> setMaxValue(T maxValue) {
		this.maxValue = maxValue;
		return this;
	}			
	//[END]GETTERS AND SETTERS
}
