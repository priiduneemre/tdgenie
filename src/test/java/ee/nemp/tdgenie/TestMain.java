package ee.nemp.tdgenie;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import ee.nemp.tdgenie.base.RandomGenerator;
import ee.nemp.tdgenie.base.SequenceGenerator;
import ee.nemp.tdgenie.datetime.DateGenerator;
import ee.nemp.tdgenie.datetime.DateTimeGenerator;
import ee.nemp.tdgenie.datetime.TimestampGenerator;
import ee.nemp.tdgenie.misc.BooleanGenerator;
import ee.nemp.tdgenie.misc.MiscGenerator;
import ee.nemp.tdgenie.misc.car.EstonianNumberPlateGenerator;
import ee.nemp.tdgenie.misc.car.VINGenerator;
import ee.nemp.tdgenie.misc.person.EmailGenerator;
import ee.nemp.tdgenie.misc.person.EstonianIDGenerator;
import ee.nemp.tdgenie.misc.person.FirstNameGenerator;
import ee.nemp.tdgenie.misc.person.LastNameGenerator;
import ee.nemp.tdgenie.number.BigDecimalGenerator;
import ee.nemp.tdgenie.number.IntegerGenerator;
import ee.nemp.tdgenie.number.NumberGenerator;
import ee.nemp.tdgenie.number.ShortGenerator;
import ee.nemp.tdgenie.sequence.IntegerSequenceGenerator;
import ee.nemp.tdgenie.sequence.ShortSequenceGenerator;
import ee.nemp.tdgenie.text.AlphaNumericStringGenerator;
import ee.nemp.tdgenie.text.AlphabeticStringGenerator;
import ee.nemp.tdgenie.text.NumericStringGenerator;

public class TestMain {

	public static void main(String[] args){
		
		NumberGenerator<Integer> gen = new IntegerGenerator();
		gen.setOutputUnique(true);
		gen.setOutputSorted(true);
		gen.setOutputNullable(true);
		gen.setNullFrequency(10);
		List<Integer> genIntegers = gen.setMinValue(10).setMaxValue(120).generateValues(100);
		
		NumberGenerator<BigDecimal> gen2 = new BigDecimalGenerator();
		gen2.setOutputUnique(true);
		gen2.setOutputSorted(true);
		gen2.setOutputNullable(true);
		gen2.setNullFrequency(10);
		List<BigDecimal> genBigDecimals = gen2.setMinValue(new BigDecimal("10"))
				.setMaxValue(new BigDecimal("100.50")).generateValues(100);
		
		NumberGenerator<Short> gen3 = new ShortGenerator();
		gen3.setOutputUnique(true);
		gen3.setOutputSorted(true);
		gen3.setOutputNullable(true);
		gen3.setNullFrequency(10);
		List<Short> genShorts = gen3.setMinValue((short)10).setMaxValue((short)120)
				.generateValues(100);
		
		AlphaNumericStringGenerator gen4 = new AlphaNumericStringGenerator();
		gen4.setOutputUnique(true);
		gen4.setOutputSorted(true);
		gen4.setOutputNullable(true);
		gen4.setNullFrequency(10);
		List<String> genAlNumStrings = gen4.setStrsContainSpaces(true).setMinLength(10)
				.setMaxLength(20).generateValues(100);
		
		RandomGenerator<Boolean> gen5 = new BooleanGenerator();
		gen5.setOutputSorted(true);
		gen5.setOutputNullable(true);
		gen5.setNullFrequency(10);
		List<Boolean> genBooleans = gen5.generateValues(100);
		
		DateTimeGenerator<Date> gen6 = new DateGenerator();
		gen6.setOutputSorted(true);
		gen6.setOutputUnique(true);
		gen6.setOutputNullable(true);
		gen6.setNullFrequency(10);
		List<Date> genDates = gen6.setMinDateTime("1900-01-01").setMaxDateTime("2100-01-01")
				.generateValues(100);
		
		DateTimeGenerator<Timestamp> gen7 = new TimestampGenerator();
		gen7.setOutputSorted(true);
		gen7.setOutputUnique(true);
		gen7.setOutputNullable(true);
		gen7.setNullFrequency(10);
		List<Timestamp> genTimestamps = gen7.setMinDateTime("1900-01-01 00:00:00")
				.setMaxDateTime("2100-01-01 00:00:00").generateValues(100);
		
		NumericStringGenerator gen8 = new NumericStringGenerator();
		gen8.setOutputSorted(true);
		gen8.setOutputUnique(true);
		gen8.setOutputNullable(true);
		gen8.setNullFrequency(10);
		List<String> genNumStrings = gen8.setMinLength(10).setMaxLength(20).generateValues(100);
		
		RandomGenerator<String> gen9 = new VINGenerator();
		gen9.setOutputSorted(true);
		gen9.setOutputUnique(true);
		gen9.setOutputNullable(true);
		gen9.setNullFrequency(10);
		List<String> genVINs = gen9.generateValues(100);
		
		RandomGenerator<String> gen10 = new EstonianIDGenerator();
		gen10.setOutputSorted(true);
		gen10.setOutputUnique(true);
		gen10.setOutputNullable(true);
		gen10.setNullFrequency(10);
		List<String> genEstonianIDs = gen10.generateValues(100);
		
		RandomGenerator<String> gen11 = new EmailGenerator();
		gen11.setOutputSorted(true);
		gen11.setOutputUnique(true);
		gen11.setOutputNullable(true);
		gen11.setNullFrequency(10);
		List<String> genEmails = gen11.generateValues(100);
		
		EstonianNumberPlateGenerator gen12 = new EstonianNumberPlateGenerator();
		gen12.setOutputSorted(true);
		gen12.setOutputUnique(true);
		gen12.setOutputNullable(true);
		gen12.setNullFrequency(10);
		List<String> genEstonianNumberPlates = gen12.setGenericPlatesOnly(true).generateValues(100);
		
		AlphabeticStringGenerator gen13 = new AlphabeticStringGenerator();
		gen13.setOutputSorted(true);
		gen13.setOutputUnique(true);
		gen13.setOutputNullable(true);
		gen13.setNullFrequency(10);
		List<String> genAlphaStrings = gen13.setMinLength(10).setMaxLength(20).generateValues(100);
		
		SequenceGenerator<Integer> gen14 = new IntegerSequenceGenerator();
		gen14.setStartWith(1).setIncrementBy(1);
		List<Integer> genIntegerSeq = gen14.generateValues(100);
		
		SequenceGenerator<Short> gen15 = new ShortSequenceGenerator();
		gen15.setStartWith((short)1).setIncrementBy((short)1);
		List<Short> genShortSeq = gen15.generateValues(100);
		
		MiscGenerator<String> gen16 = new FirstNameGenerator();
		gen16.setOutputSorted(true);
		gen16.setOutputUnique(true);
		gen16.setOutputNullable(true);
		gen16.setNullFrequency(10);
		List<String> genFirstNames = gen16.generateValues(100);
		
		MiscGenerator<String> gen17 = new LastNameGenerator();
		gen17.setOutputSorted(true);
		gen17.setOutputUnique(true);
		gen17.setOutputNullable(true);
		gen17.setNullFrequency(10);
		List<String> genLastNames = gen17.generateValues(100);
		
		//[START]DEBUG INFO BLOCK
		System.out.println("\n'tdgenie' EXAMPLE RESULTS:\n");
		System.out.println("IntegerGenerator output: " + genIntegers);
		System.out.println("BigDecimalGenerator output: " + genBigDecimals);
		System.out.println("ShortGenerator output: " + genShorts);
		System.out.println("AlhpaNumericGenerator output: " + genAlNumStrings);
		System.out.println("BooleanGenerator output: " + genBooleans);
		System.out.println("DateGenerator output: " + genDates);
		System.out.println("TimestampGenerator output: " + genTimestamps);
		System.out.println("NumericStringGenerator output: " + genNumStrings);
		System.out.println("VINGenerator output: " + genVINs);
		System.out.println("EstonianIDGenerator output: " + genEstonianIDs);
		System.out.println("EmailGenerator  output: " + genEmails);
		System.out.println("EstonianNumberPlateGenerator output: " + genEstonianNumberPlates);
		System.out.println("AlphabeticStringGenerator output: " + genAlphaStrings);
		System.out.println("IntegerSequenceGenerator output: " + genIntegerSeq);
		System.out.println("ShortSequenceGenerator output: " + genShortSeq);
		System.out.println("FirstNameGenerator output: " + genFirstNames);
		System.out.println("LastNameGenerator output: " + genLastNames);
		//[END]DEBUG INFO BLOCK			
	}
}
