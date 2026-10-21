class TimeMap {
/*
Approach:
Use a HashMap to store each key mapped to a list of timestamp-value pairs. Since timestamps are added in increasing order for each key, the list remains sorted.

Get:
If the key doesn't exist, return "". Otherwise, use binary search on its list to find the largest timestamp that is less than or equal to the requested timestamp. If a timestamp is valid, save its value and continue searching right for a potentially newer valid timestamp. If it is too large, search left.

Time Complexity:
set: O(1) amortized
get: O(log n), where n is the number of entries for that key.

Space Complexity: O(N), where N is the total number of stored timestamp-value pairs.
*/

    HashMap<String, List<Pair>> map = new HashMap<>();

    public TimeMap() {



    }
    
    public void set(String key, String value, int timestamp) {
        
       map.computeIfAbsent(key, k -> new ArrayList<>())
   .add(new Pair(timestamp, value));

    }
    
    public String get(String key, int timestamp) {

        String result = "";

        if(map.containsKey(key)){

            List<Pair> list = map.get(key);

            int left = 0;
            int right = list.size() -1;

            while(left <= right){

                int mid = left+(right-left)/2;

                if(list.get(mid).timestamp <= timestamp){
                      result = list.get(mid).value;

                    left= mid+1;
                }

                else{

                    right = mid-1;


                }


            }
            


        }

        return result; 
        
    }
}


class Pair {
    int timestamp;
    String value;

    public Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}