package ee.nemp.tdgenie.text;

public class AlphabeticStringGenerator extends TextGenerator<String> {
	
	//Instance variables
	boolean strsContainSpaces;
	
	@Override
	public String getRndValue(int minLength, int maxLength){
		int rndStringLength = getRndSeed().nextInt(maxLength - minLength + 1) + minLength;
		StringBuilder rndString = new StringBuilder(rndStringLength);
		
		while(rndString.length() < rndStringLength){
			if(strsContainSpaces){
				rndString.append(ALPHABETIC_CHARS_INC_SPACE.charAt(
						getRndSeed().nextInt(ALPHABETIC_CHARS_INC_SPACE.length())));
			}else{
				rndString.append(ALPHABETIC_CHARS.charAt(
						getRndSeed().nextInt(ALPHABETIC_CHARS.length())));
			}
		}
		
		return rndString.toString();
	}

	//[START]GETTERS AND SETTERS
	public boolean isStrsContainSpaces() {
		return strsContainSpaces;
	}
	public AlphabeticStringGenerator setStrsContainSpaces(boolean strsContainSpaces) {
		this.strsContainSpaces = strsContainSpaces;
		return this;
	}
	//[END]GETTERS AND SETTERS
}
