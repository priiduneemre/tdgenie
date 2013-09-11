package ee.nemp.tdgenie.misc.car;

import java.util.Arrays;

import ee.nemp.tdgenie.misc.MiscGenerator;
import ee.nemp.tdgenie.text.TextGenerator;

public class VINGenerator extends MiscGenerator<String>{
	
	//Constants
	public static final int VIN_CODE_LENGTH = 17;
	public static final String[] VIN_CODE_PROHIBITED_LETTERS = new String[]{"I", "O", "Q"};
	
	@Override
	public String getRndValue(){
		StringBuilder rndVINCode = new StringBuilder(VIN_CODE_LENGTH);
		
		while(rndVINCode.length() < VIN_CODE_LENGTH){
			String curAlphaNumeric = String.valueOf((TextGenerator.NUMERIC_CHARS + TextGenerator.ALPHABETIC_CHARS_UC)
					.charAt(getRndSeed().nextInt((TextGenerator.NUMERIC_CHARS + TextGenerator.ALPHABETIC_CHARS_UC)
							.length())));
			
			if(Arrays.asList(VIN_CODE_PROHIBITED_LETTERS).contains(curAlphaNumeric)){
				continue;
			}
			rndVINCode.append(curAlphaNumeric);
		}
		
		return rndVINCode.toString();
	}
}
