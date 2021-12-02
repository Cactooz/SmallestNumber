public class Main {
	public static void main(String[] args) {

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
		int i = 0;
		int j = 0;
		
		while (pairs >= 1)
		{
			//Get the partSequence with the possible elements
			i = 0;
			j = 0;
			while (j < pairs)
			{
				partSequence[j++] = (sequence[i] < sequence[i + 1])? sequence[i] : sequence[i + 1];
				i += 2;
			}
			if (unpairedElements == 1)
				partSequence[j] = sequence[sequence.length - 1];
			
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
