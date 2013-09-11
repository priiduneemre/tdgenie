package ee.nemp.tdgenie.misc.person;

import ee.nemp.tdgenie.misc.MiscGenerator;

public abstract class NameGenerator extends MiscGenerator<String> {

	public abstract String[] getNameAssortment();
	
	@Override
	public String getRndValue() {
		String[] nameAssortment = getNameAssortment();
		String rndName = nameAssortment[getRndSeed().nextInt(nameAssortment.length)];
		
		return rndName;
	}
}
