/**
 * Glass Falling
 * Find minimum number of trials needed in the worse case
 */
public class GlassFalling {

  // Do not change the parameters!

    public int glassFallingRecur(int floors, int sheets) {

	// if we have only 1 sheet would need to try all the floors in the worst case
	if (sheets == 1) return floors;

	// would only need 1 trial if there is 1 floor, none if none
	if (floors == 1 || floors == 0) return floors;

	// cannot have any trials if we have no sheets
	//	if (sheets == 0) return 0;

	int min = Integer.MAX_VALUE; // set min to a high number, to tell if it didn't change

	// as we go up the floors, 
	for (int x = 1; x <= floors; x++) {
       	    int y = Math.max(glassFallingRecur(x-1, sheets-1), //check lower floors, assume sheet broke
			     glassFallingRecur(floors-x, sheets)); //check upper floors, assume sheet okay
	    if (y < min)
		min = y; // set min to value above
	    //	    System.out.println("Recur: x is " + x + " with a min of " + min);
	}

	int ans = min+1;
       	return ans; // we add 1 to show we made it through another trial
  }


    // Memoized version 
    public int glassFallingMemoized(int floors, int sheets) {
	int[][] memo = new int[floors + 1][sheets + 1];
	return glassFallingMemoized(floors, sheets, memo);
    }
    
    public int glassFallingMemoized(int floors, int sheets, int memo[][]) {

	// check if already stored in memo
	if (memo[floors][sheets] != 0) return memo[floors][sheets];

	// would only need 1 trial if there is 1 floor, none if none
	if (floors == 1 || floors == 0)
	    return floors; 

	// if we have only 1 sheet would need to try all the floors in the worst case
	if (sheets == 1)
	    return floors;

	int min = Integer.MAX_VALUE; // set min to a high number, to tell if it didn't change

	// as we go up the floors, 
	for (int x = 1; x <= floors; x++) {
	    int y = Math.max(glassFallingMemoized(x-1, sheets-1, memo), //check lower floors, assume sheet broke
			 glassFallingMemoized(floors-x, sheets, memo)); //check upper floors, assume sheet okay
	    if (y < min)
		min = y; // set min to value above
	}
	
       	return memo[floors][sheets] = min + 1; // we add 1 to show we made it through another trial
    }
  
    
    // Do not change the parameters!
    public int glassFallingBottomUp(int floors, int sheets) {
	int[][] dp = new int[floors+1][sheets+1];

	dp[0][0] = 0;

	for(int i=1; i < sheets; i++) {
	    dp[0][i] = 0;
	    dp[1][i] = 1;
	}

	for(int i=1; i < floors; i++) 
	    dp[i][1] = i;
	
	
	int floorMax = -1;
	int min = Integer.MAX_VALUE; // set min to a high number, to tell if it 

	for(int x=2; x <= sheets; x++) {

	    for(int j=2; j <= floors; j++) {
		min = Integer.MAX_VALUE;
		
		for(int k=1; k<=j; k++) {
		    floorMax = 1 + Math.max(dp[k-1][x-1], dp[j-k][x]);
		    if (floorMax < min) { // find max per floor
			min = floorMax;
			dp[j][x] = min;
		    }
		  
		}
	    }
	}
        return min;
    }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Memo = gf.glassFallingMemoized(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Memo + " " + minTrials2Bottom);

  }
}
