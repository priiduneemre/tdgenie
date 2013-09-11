package ee.nemp.tdgenie.misc.car;

import ee.nemp.tdgenie.misc.MiscGenerator;
import ee.nemp.tdgenie.text.TextGenerator;

public class EstonianNumberPlateGenerator extends MiscGenerator<String>{

	//Constants
	public static final int GENERIC_PLATE_LENGTH = 6;
	public static final int GENERIC_PLATE_NUMBER_PART_LENGTH = 3;
	public static final int GENERIC_PLATE_ALPHABETIC_PART_LENGTH = 3;
	
	//Instance variables
	boolean genericPlatesOnly;
	
	
	@Override
	public String getRndValue() {
		String rndNumberPlate;
		
		if(genericPlatesOnly){
			rndNumberPlate = generateGenericPlate();
		}else{
			rndNumberPlate = generateAnyPlate();
		}
		
		return rndNumberPlate;
	}
	
	public String generateGenericPlate(){
		StringBuilder rndNumberPlate = new StringBuilder();
		
		while(rndNumberPlate.length() < GENERIC_PLATE_NUMBER_PART_LENGTH){
			String curNumeric = String.valueOf(TextGenerator.NUMERIC_CHARS
					.charAt(getRndSeed().nextInt(TextGenerator.NUMERIC_CHARS.length())));
			rndNumberPlate.append(curNumeric);
		}
		while(rndNumberPlate.length() < GENERIC_PLATE_LENGTH){
			String curLetter = String.valueOf(TextGenerator.ALPHABETIC_CHARS_UC
					.charAt(getRndSeed().nextInt(TextGenerator.ALPHABETIC_CHARS_UC.length())));
			rndNumberPlate.append(curLetter);
		}
		
		return rndNumberPlate.toString();
	}
	
	public String generateAnyPlate(){
		throw new RuntimeException("Not yet implemented");
	}

	//[START]GETTERS AND SETTERS
	public boolean isGenericPlatesOnly() {
		return genericPlatesOnly;
	}
	public EstonianNumberPlateGenerator setGenericPlatesOnly(boolean genericPlatesOnly) {
		this.genericPlatesOnly = genericPlatesOnly;
		return this;
	}
	//[END]GETTERS AND SETTERS
}
