package ee.nemp.tdgenie.base;

import java.util.ArrayList;
import java.util.List;

public abstract class SequenceGenerator<T> extends Generator<T> {

	//Instance variables
	private T curValue;
	private T incrementBy;
	
	
	public abstract T getNextValue();
	
	@Override
	public List<T> generateValues(int valueCount) {
		List<T> seqValues = new ArrayList<T>(valueCount);
		
		while(seqValues.size() < valueCount){
			T curValue = getNextValue();
		
			if(isOutputNullable()){
				if(getRndSeed().nextDouble() <= ((double)getNullFrequency()/100)){
					seqValues.add(null);
					continue;
				}
			}
			seqValues.add(curValue);
		}
		
		return seqValues;
	}
	
	//[START]GETTERS AND SETTERS
	protected T getCurValue() {
		return curValue;
	}
	protected void setCurValue(T curValue) {
		this.curValue = curValue;
	}
	public SequenceGenerator<T> setStartWith(T curValue) {
		this.curValue = curValue;
		return this;
	}
	public T getIncrementBy() {
		return incrementBy;
	}
	public SequenceGenerator<T> setIncrementBy(T incrementBy) {
		this.incrementBy = incrementBy;
		return this;
	}
	//[END]GETTERS AND SETTERS
}