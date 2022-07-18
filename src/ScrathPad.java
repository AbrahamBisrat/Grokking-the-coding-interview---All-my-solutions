
public class ScrathPad {
	public static void main(String[] args) {
		
	}
	
	public int maxSubArray(int[] nums) {
      int max = nums[0];
      int currentSum = 0;
      
      for(int i = 0; i < nums.length; i++){
          if(currentSum > 0){
              currentSum += nums[i];
          }   
          else{
              currentSum = nums[i];
          }
           max = Math.max(currentSum, max);
      }
      return max;
  }
	/********************************/
	public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--; // return 1.. 5 bills
                ten++;
            }
            else if(bill == 20){
                if(five ==0 && ten == 0 || five < 3){  //checking the enough change
                    return false;
                }
                // there is another condition
                if(five >= 3 && ten ==0){
                    five = five - 3;
                    twenty++;
                }
                else{
                    five--;
                    ten--;
                    twenty++;
                }
            }
            else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
	
	// create a new array, add from ( index - end ) first 
	// add the rest next!!
	
	// Arrays.toString(array)
	
	
	
}
