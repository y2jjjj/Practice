class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] res=new int[k];
        int o=0;
        while(k!=0 && !map.isEmpty()){
            int maxe=-1;int maxv=-1;
            for(Map.Entry<Integer,Integer>entry:map.entrySet()){
                if(entry.getValue()>maxv || (entry.getValue()==maxv && entry.getKey()>maxe)){
                    maxe=entry.getKey();
                    maxv=entry.getValue();
                }
            }
            res[o]=maxe;
            o++;map.remove(maxe);
            k--;
        }
        return res;
    }
}
