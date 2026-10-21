class TimeMap {

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