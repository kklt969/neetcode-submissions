class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] result = new int[temperatures.length];

        for(int i = 0 ; i < temperatures.length ; i++){

            int currentTemperature = temperatures[i];
            int dayCounter = 0;

            for(int j = i+1; j < temperatures.length; j++){

                int temp = temperatures[j];
                //int counter = 0;
                boolean higherTemp = false;

                if(temp > currentTemperature)
                {
                    dayCounter++;
                  
                    break;
                }
              
              dayCounter++;

              if(j == (temperatures.length - 1) && (!higherTemp)){

                    dayCounter = 0;

              }


            }

            result[i] = dayCounter;

        }

        return result;

    }
}
