package ee.nemp.tdgenie.misc;

public class BooleanGenerator extends MiscGenerator<Boolean> {

	@Override
	public Boolean getRndValue(){
		return getRndSeed().nextBoolean();
	}
}
