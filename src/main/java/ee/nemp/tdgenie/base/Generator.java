package ee.nemp.tdgenie.base;

import java.util.List;
import java.util.Random;

public abstract class Generator<T> implements NullableGenerator{

	//Constants
	public static final int SOLE_RESULT_INDEX = 0;
	
	//Instance variables
	private boolean outputNullable;
	private int nullFreqPercentage;
	
	private Random rndSeed;
	
	
	public Generator(){
		rndSeed = new Random();
	}
	
	public abstract List<T> generateValues(int valueCount);
	
	@Override 
	public void setOutputNullable(boolean outputNullable){
		this.outputNullable = outputNullable;
	}
	
	@Override
	public void setNullFrequency(int nullFreqPercentage){
		this.nullFreqPercentage = nullFreqPercentage;
	}
	
	//[START]GETTERS AND SETTERS
	public boolean isOutputNullable() {
		return outputNullable;
	}
	public int getNullFrequency(){
		return nullFreqPercentage;
	}
	public Random getRndSeed() {
		return rndSeed;
	}
	public void setRndSeed(Random rndSeed) {
		this.rndSeed = rndSeed;
	}
	//[END]GETTERS AND SETTERS
}