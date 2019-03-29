/**
 * Rod cutting problem described in Chapter 15 of textbook
 */

public class RodCutting {
          
    // Do not change the parameters!
    public int rodCuttingRecur(int rodLength, int[] lengthPrices) {

	// create an array to keep track of solved subproblems
	// each entry is the optimal solution for rodLength i 
        int[] memo = new int[lengthPrices.length+1];

	return rodCuttingRecur(rodLength,lengthPrices, memo);
    }

    // memoized recursive version
    public int rodCuttingRecur(int rodLength, int[] lengthPrices, int[] dp) {

	if (rodLength == 0) return 0;

	// return stored answer if available
	if (dp[rodLength] != 0) return dp[rodLength];
	
	int optSol = 0; // optimal solution variable

	// we evaluate the optimal solution, between the available optimal solution and
	// a rod of length i plus the optimal solution for the remaining length
	for (int i=1; i <= rodLength; i++) {
	    optSol = Math.max(optSol, 
			      lengthPrices[i-1] + rodCuttingRecur(rodLength-i,lengthPrices, dp));
      }

      return dp[rodLength] = optSol;
    }

    // extra: recursive without memoization
    /*
  public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
      //there are rodLength subproblems
      if (rodLength == 0) return 0;

      
      int optSol = 0; //lengthPrices[rodLength]; // optimal solution
      
      for (int i=1; i <= rodLength; i++) {
	  optSol = Math.max(optSol, 
			    lengthPrices[i-1] + rodCuttingRecur(rodLength-i,lengthPrices));
	  System.out.println("recursive step " + i + " opt solution: " + optSol);
      }

      return optSol;
  }
     */

    
  // Do not change the parameters!
    public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
	int[] array = new int[rodLength+1];
	array[0] = 0;

	for(int j=1; j <= rodLength; j++) {
	    int q = -1;
	    for (int i=1; i <= j; i++) {
		q = Math.max(q, lengthPrices[i-1] + array[j-i]);
	    }
      	    array[j] = q;
	}
	return array[rodLength];
    }


  public static void main(String args[]){
      RodCutting rc = new RodCutting();

      
      // In your turned in copy, do not touch the below lines of code.
      // Make sure below is your only output.
      int length1 = 7;
      int[] prices1 = {1, 4, 7, 3, 19, 5, 12};
      int length2 = 14;
      int[] prices2 = {2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26};
      int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
      int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);
      int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);
      int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);
      System.out.println(maxSell1Recur + " " + maxSell1Bottom);
      System.out.println(maxSell2Recur + " " + maxSell2Bottom);
       
  }
}
