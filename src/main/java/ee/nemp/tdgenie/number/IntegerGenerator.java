package ee.nemp.tdgenie.number;


public class IntegerGenerator extends NumberGenerator<Integer> {
	
	@Override
	public Integer getRndValue(Integer minValue, Integer maxValue) {
		int rndInteger = getRndSeed().nextInt(maxValue - minValue + 1) + minValue;
		return rndInteger;
	}
}
