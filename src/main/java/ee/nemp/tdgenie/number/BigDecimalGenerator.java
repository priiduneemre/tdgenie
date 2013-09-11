package ee.nemp.tdgenie.number;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class BigDecimalGenerator extends NumberGenerator<BigDecimal> {
	
	@Override
	public BigDecimal getRndValue(BigDecimal minDecimal, BigDecimal maxDecimal){
		int maxScale = 0;
		
		BigDecimal rndDecimalRange = maxDecimal.subtract(minDecimal);
		//Get the maximum scale over minDecimal and maxDecimal
		if(minDecimal.scale() > maxScale)maxScale = minDecimal.scale();
		if(maxDecimal.scale() > maxScale)maxScale = maxDecimal.scale();
		
		BigDecimal rndDecimal = minDecimal.add(rndDecimalRange.multiply(new BigDecimal(
				getRndSeed().nextDouble())));
		//[START]DEBUG INFO
		//System.out.println("RndDecimal: " + rndDecimal  + "; (scale: " 
		//+ rndDecimal.scale() + "; precision: " + rndDecimal.precision() + ")");
		//[END]DEBUG INFO

		//Round the generated decimal to the maximum scale presented by minDecimal (or) maxDecimal
		rndDecimal = rndDecimal.setScale(maxScale, RoundingMode.HALF_DOWN);

		return rndDecimal;
	}
}
