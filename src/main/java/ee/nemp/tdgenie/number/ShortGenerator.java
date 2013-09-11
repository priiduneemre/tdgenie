package ee.nemp.tdgenie.number;


public class ShortGenerator extends NumberGenerator<Short>{
	
	@Override
	public Short getRndValue(Short minValue, Short maxValue){
		short rndShort = (short)(getRndSeed().nextInt(maxValue - minValue + 1) + minValue);
		return rndShort;
	}
}
