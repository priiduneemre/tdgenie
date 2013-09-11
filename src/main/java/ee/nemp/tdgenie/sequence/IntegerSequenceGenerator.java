package ee.nemp.tdgenie.sequence;

import ee.nemp.tdgenie.base.SequenceGenerator;

public class IntegerSequenceGenerator extends SequenceGenerator<Integer> {

	//Constants
	public static final int DEFAULT_START_VALUE = 1;
	public static final int DEFAULT_INCREMENTOR = 1;

	
	
	public IntegerSequenceGenerator(){
		setCurValue(DEFAULT_START_VALUE);
		setIncrementBy(DEFAULT_INCREMENTOR);
	}
	
	@Override
	public Integer getNextValue() {
		int curValue = getCurValue();
		int nextValue = curValue + getIncrementBy();
		setCurValue(nextValue);
		
		return curValue;
	}
}