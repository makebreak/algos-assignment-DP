/**
 * Glass Falling
 * Find minimum number of trials needed in the worse case
 */
public class GlassFalling {

  // Do not change the parameters!

    public int glassFallingRecur(int floors, int sheets) {

	// would only need 1 trial if there is 1 floor, none if none
	if (floors == 1 || floors == 0)
	    return floors; 

	// cannot have any trials if we have no sheets
	if (sheets == 0) return 0;

	// if we have only 1 sheet would need to try all the floors in the worst case
	if (sheets == 1)
	    return floors;

	int min = Integer.MAX_VALUE; // set min to a high number, to tell if it didn't change
	int x, y;

	// as we go up the floors, 
	for (x = 1; x <= floors; x++) {
	    y = Math.max(glassFallingRecur(x-1, sheets-1), //check lower floors, assume sheet broke
			 glassFallingRecur(floors-x, sheets)); //check upper floors, assume sheet okay
	    if (y < min)
		min = y; // set min to value above
	    System.out.println("This x is " + x + "with a min of " + min);
	}
	
       	return min + 1; // we add 1 to show we made it through another trial
  }

    public boolean tryGlass(int n) {
	if (n >= 3) return true;
	else return false;
    }

    // Optional:
    // Pick whatever parameters you want to, just make sure to return an int.
    public int glassFallingMemoized(int floors, int sheets, int low, int high, int dp[]) {

	// Fill in here and change the return
	return 0;
    }



  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
      int[] dp = new int[floors];
    return 0;
  }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();
      /*
      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
      */

      //DELETE LATER
      int minTrials1Recur = gf.glassFallingRecur(10, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(10, 2);
      int minTrials2Recur = gf.glassFallingRecur(4, 2);
      int minTrials2Bottom = gf.glassFallingBottomUp(4, 2);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);

  }
}
