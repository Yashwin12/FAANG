class Program {
	// T: O(n) | S: O(1) 
  public static int longestPeak(int[] array) {
		int longestPeakVal = 0;
		int i = 1;
		
		while ( i < array.length - 1 ){
			Boolean isPeak = array[i] > array[i-1] && array[i] > array[i + 1];
			
			if ( !isPeak ){
				// Not a Peak/ Tip 
				i++;
				continue;
			}
			
			// Found a tip/ Peak value
			int leftIdx = i - 1;
			int rightIdx = i + 1;
			
			// This is initiated as 3 bc it needs to have atleast three elementes to form a peak.
			int currentLongestPeakVal = 3;
			
			// Strictly Increasing
			while ( leftIdx > 0 && array[leftIdx] > array[leftIdx - 1]   ){
				leftIdx--;
				currentLongestPeakVal++;
			}
			
			// Strictly Deecreasing
			while ( rightIdx < array.length - 1 && array[rightIdx] > array[rightIdx + 1]   ){
				rightIdx++;
				currentLongestPeakVal++;
			}
			
			longestPeakVal = Math.max(longestPeakVal, currentLongestPeakVal);
			i = rightIdx;
		}
    return longestPeakVal;
  }
}
