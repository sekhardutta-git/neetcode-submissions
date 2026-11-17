class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
          String sortedStr = sort(s);
          List<String> anas =  map.get(sortedStr);
          if(anas == null){
            anas = new ArrayList<>();
            map.put(sortedStr,anas);
          }
          anas.add(s);
        }
    List<List<String>> output = new ArrayList<>();
    for(List<String> l : map.values()){
        output.add(l);
    }
return output;
    }

    private static String sort(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
