class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            
             map.put(num, map.getOrDefault(num,0)+1);
            }

        List<Integer> bucket [] = new ArrayList[nums.length + 1];

        for(int i = 0; i < bucket.length; i++){

            bucket[i] = new ArrayList<>();

        
        } 

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int num = entry.getKey();
            int freq = entry.getValue();

            bucket[freq].add(num);

        }

        List<Integer> result = new ArrayList<>();

        for( int i = bucket.length -1 ; i>= 0 && result.size() < k ;i --){
           
          for(int num : bucket[i]){

            if(result.size() == k){
            break;
          }
              result.add(num);

          }

        }

        int ans[] = new int[k];

        for(int i = 0 ; i < k ; i++){
            ans[i] = result.get(i);
        }

        return ans;
            
    }
}
