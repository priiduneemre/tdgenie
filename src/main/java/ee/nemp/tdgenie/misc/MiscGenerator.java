package ee.nemp.tdgenie.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ee.nemp.tdgenie.base.RandomGenerator;

public abstract class MiscGenerator<T extends Comparable<? super T>> extends RandomGenerator<T>  {

	
	public abstract T getRndValue();
	
	@Override
	public List<T> getValues(int valueCount){
		List<T> rndValues = new ArrayList<T>(valueCount);
		Set<T> prevUsedValues = new HashSet<T>();
		
		while(rndValues.size() < valueCount){
			T curValue = getRndValue();
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
}