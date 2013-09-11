package ee.nemp.tdgenie.text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ee.nemp.tdgenie.base.RandomGenerator;

public abstract class TextGenerator<T extends Comparable<? super T>>  extends RandomGenerator<T> {

	//Constants
	public static final String ALNUM_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALNUM_CHARS_INC_SPACE = ALNUM_CHARS + " ";
	public static final String NUMERIC_CHARS = "0123456789";
	public static final String NUMERIC_CHARS_INC_SPACE = NUMERIC_CHARS + " ";
	public static final String ALPHABETIC_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHABETIC_CHARS_INC_SPACE = ALPHABETIC_CHARS + " ";
	public static final String ALPHABETIC_CHARS_LC = "abcdefghijklmnopqrstuvwxyz";
	public static final String ALPHABETIC_CHARS_LC_INC_SPACE = ALPHABETIC_CHARS_LC + " ";
	public static final String ALPHABETIC_CHARS_UC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHABETIC_CHARS_UC_INC_SPACE = ALPHABETIC_CHARS_UC + " ";
	
	//Instance variables
	private int minLength;
	private int maxLength;
	
	
	public abstract T getRndValue(int minLength, int maxLength);
	
	@Override
	public List<T> getValues(int valueCount){
		List<T> rndValues = new ArrayList<T>(valueCount);
		Set<T> prevUsedValues = new HashSet<T>();
		
		while(rndValues.size() < valueCount){
			T curValue = getRndValue(minLength, maxLength);
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
	public int getMinLength() {
		return minLength;
	}
	public TextGenerator<T> setMinLength(int minLength) {
		this.minLength = minLength;
		return this;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public TextGenerator<T> setMaxLength(int maxLength) {
		this.maxLength = maxLength;
		return this;
	}
	//[END]GETTERS AND SETTERS
}