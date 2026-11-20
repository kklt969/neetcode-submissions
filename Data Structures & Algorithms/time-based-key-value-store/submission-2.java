class TimeMap {

    HashMap<String, List<TimeInfo>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(map.containsKey(key)){
            List<TimeInfo> list = map.get(key);
            list.add(new TimeInfo(value,timestamp));
            map.put(key, list);

        }else{
            List<TimeInfo> newList = new ArrayList<>();
            newList.add(new TimeInfo(value,timestamp));
            map.put(key, newList);
        }


    }
    
    public String get(String key, int timestamp) {
        

        String result = "";

        if(map.containsKey(key)){

            List<TimeInfo> vals = map.get(key);

             int left = 0;
       int right = vals.size()-1;


            while(left <= right){

                    int mid = left + (right - left) / 2;


                    if(vals.get(mid).timestamp <= timestamp){
                        result = vals.get(mid).value;
                        left=mid+1;

                    }
                    else{
                        right = mid-1;
                    }


            }


        }
       
        return result;





    }
}

class TimeInfo{

    String value;
    int timestamp;

    TimeInfo(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }





}
