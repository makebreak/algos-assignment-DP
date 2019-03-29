/**
 * Rod cutting problem described in Chapter 15 of textbook
 */

public class RodCutting {

  // Do not change the parameters!
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

  // Do not change the parameters!
    public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
	int[] array = new int[rodLength+1];
	array[0] = 0;

	for(int j=1; j <= rodLength; j++) {
	    int q = -1;
	    for (int i=1; i <= j; i++) {
		int diff = j-i;
		int what = i-1;
		System.out.println("j is: " + j + ", i-1 is" + what + " and j-i is" + diff);
		q = Math.max(q, lengthPrices[i-1] + array[j-i]);
	    }
      	    array[j] = q;
	    System.out.println("array[" + j + "], or q, is: " + q);
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

      /*      //DELETE BELOW 
      int length1 = 4;
      int[] prices1 = {1, 5, 8, 9};
      int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
      */
      //System.out.println(maxSell1Recur);
      //System.out.println(maxSell2Recur);
       
  }
}
