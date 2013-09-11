package ee.nemp.tdgenie.base;

import java.util.Collections;
import java.util.List;

public abstract class RandomGenerator<T extends Comparable<? super T>> extends Generator<T> 
	implements SortableGenerator, UniqueGenerator {
	
	//Instance variables
	private boolean outputSorted;
	private boolean outputUnique;
	
	
	public abstract List<T> getValues(int valueCount);
	
	@Override
	public List<T> generateValues(int valueCount){
		List<T> generatedValues = getValues(valueCount);
		generatedValues = handleSorting(generatedValues);
		
		return generatedValues;
	} 
	
	private List<T> handleSorting(List<T> rndItems){
		List<T> sortableItems = rndItems;
		if(isOutputSorted()){
			if(isOutputNullable()){
				int nullCount = 0;
				for(int i = 0; i < sortableItems.size(); i++){
					if(sortableItems.get(i) == null){
						nullCount++;
					}
				}
				while(sortableItems.contains(null)){
					sortableItems.remove(null);
				}
				Collections.sort(sortableItems);
				//Add the correct number of nulls back to the end of the (now sorted) ArrayList
				for(int i = 0; i < nullCount; i++){
					sortableItems.add(null);
				}
			}else{
				Collections.sort(sortableItems);
			}
		}
		return sortableItems;
	}
	
	@Override
	public void setOutputUnique(boolean outputUnique) {
		this.outputUnique = outputUnique;
	}

	@Override
	public void setOutputSorted(boolean outputSorted) {
		this.outputSorted = outputSorted;
	}
	//[START]GETTERS AND SETTERS
	public boolean isOutputSorted() {
		return outputSorted;
	}
	public boolean isOutputUnique() {
		return outputUnique;
	}
	//[END]GETTERS AND SETTERS
}
