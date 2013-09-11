package ee.nemp.tdgenie.misc.person;

import java.sql.Date;
import java.util.Arrays;

import ee.nemp.tdgenie.base.Generator;
import ee.nemp.tdgenie.datetime.DateGenerator;
import ee.nemp.tdgenie.datetime.DateTimeGenerator;
import ee.nemp.tdgenie.misc.MiscGenerator;
import ee.nemp.tdgenie.text.TextGenerator;

public class EstonianIDGenerator extends MiscGenerator<String> {

	//Constants
	public static final int ID_CODE_LENGTH = 11;
	public static final String[] ID_FIRST_POS_NUMERICS = new String[]{"3", "4", "5", "6"}; 
	
	//Instance variables
	private DateTimeGenerator<Date> dateGenerator;
	
	
	public EstonianIDGenerator(){
		dateGenerator = new DateGenerator();
	}
	
	@Override
	public String getRndValue() {
		StringBuilder rndEstonianID = new StringBuilder(ID_CODE_LENGTH);

		Date birthDate = dateGenerator.setMinDateTime("0000-01-01").setMaxDateTime("0099-12-31")
				.generateValues(1).get(Generator.SOLE_RESULT_INDEX);
		String birthDateStr = birthDate.toString().replaceAll("-", "").substring(2);
		
		rndEstonianID.append(Arrays.asList(ID_FIRST_POS_NUMERICS).get(getRndSeed()
				.nextInt(ID_FIRST_POS_NUMERICS.length)));
		rndEstonianID.append(birthDateStr);
		while(rndEstonianID.length() < ID_CODE_LENGTH){
			rndEstonianID.append(TextGenerator.NUMERIC_CHARS.
					charAt(getRndSeed().nextInt(TextGenerator.NUMERIC_CHARS.length())));
		}
		
		return rndEstonianID.toString();
	}
}