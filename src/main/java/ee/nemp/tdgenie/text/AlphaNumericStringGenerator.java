package ee.nemp.tdgenie.text;

public class AlphaNumericStringGenerator extends TextGenerator<String> {

	//Instance variables
	boolean strsContainSpaces;
	
	@Override
	public String getRndValue(int minLength, int maxLength){
		int rndStringLength = getRndSeed().nextInt(maxLength - minLength + 1) + minLength;
		StringBuilder rndString = new StringBuilder(rndStringLength);
		
		while(rndString.length() < rndStringLength){
			if(strsContainSpaces){
				rndString.append(ALNUM_CHARS_INC_SPACE.charAt(getRndSeed().nextInt(ALNUM_CHARS_INC_SPACE.length())));
			}else{
				rndString.append(ALNUM_CHARS.charAt(getRndSeed().nextInt(ALNUM_CHARS.length())));
			}
		}
		
		return rndString.toString();
	}

	//[START]GETTERS AND SETTERS
	public boolean isStrsContainSpaces() {
		return strsContainSpaces;
	}
	public AlphaNumericStringGenerator setStrsContainSpaces(boolean strsContainSpaces) {
		this.strsContainSpaces = strsContainSpaces;
		return this;
	}
	//[END]GETTERS AND SETTERS
}
