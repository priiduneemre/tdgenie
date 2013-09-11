package ee.nemp.tdgenie.sequence;

import ee.nemp.tdgenie.base.SequenceGenerator;

public class ShortSequenceGenerator extends SequenceGenerator<Short> {

	//Constants
	public static final short DEFAULT_START_VALUE = 1;
	public static final short DEFAULT_INCREMENTOR = 1;

	
	
	public ShortSequenceGenerator(){
		setCurValue(DEFAULT_START_VALUE);
		setIncrementBy(DEFAULT_INCREMENTOR);
	}
	
	@Override
	public Short getNextValue() {
		short curValue = getCurValue();
		short nextValue = (short) (curValue + getIncrementBy());
		setCurValue(nextValue);
		
		return curValue;
	}
}