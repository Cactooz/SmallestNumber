public class Main {
	public static void main(String[] args) {
		int[] array = {23,12,23,44,22,4,54,23,54,23,3,33,43,77,45,23,12,2,76};
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("Length: " + array.length);
		System.out.println("Output: " + minValue(array));
	}
	
	//Returns the min value in the sequence, if the sequence is empty throw IllegalArgumentException
	public static int minValue(int[] element) throws IllegalArgumentException
	{
		if (element.length == 0)
			throw new IllegalArgumentException ("Empty array");
		
		//Set the min value to the first element
		int minValue = element[0];
		
		//Check if the other elements are smaller than minValue
		for(int i = 1; i < element.length; i++) {
			if(element[i] < minValue)
				minValue = element[i];
		}
		
		//Return the min value
		return minValue;
	}
	
	//Returns the min value in the sequence, if the sequence is empty throw IllegalArgumentException
	public static int min(int[] element) throws IllegalArgumentException
	{
		if (element.length == 0)
			throw new IllegalArgumentException ("Empty array");
		
		//Calculate the pairs and elements
		int[] sequence = element;
		int pairs = sequence.length / 2;
		int unpairedElements = sequence.length % 2;
		int possibleElements = pairs + unpairedElements;
		int[] partSequence = new int[possibleElements];
		
		while (pairs >= 1)
		{
			//Get the partSequence with the possible elements
			int i = 0;
			int j = 0;
			while (j < pairs)
			{
				if(sequence[i] < sequence[i+1]) {
					partSequence[j++] = sequence[i];
				}
				else {
					partSequence[j++] = sequence[i+1];
				}
				
				i += 2;
			}
			if (unpairedElements == 1) {
				partSequence[j] = sequence[i];
			}
			
			//Calculations from the partSequence
			sequence = partSequence;
			pairs = possibleElements / 2;
			unpairedElements = possibleElements % 2;
			possibleElements = pairs + unpairedElements;
		}
		
		//Return the smallest value
		return sequence[0];
	}
}
