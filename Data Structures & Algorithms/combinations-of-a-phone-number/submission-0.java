class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0){
return new ArrayList();
        }
        List<String> numChars = new ArrayList<>();
        for(int i = 0; i<digits.length();i++){
          char c = digits.charAt(i);
          if(c=='2'){
            numChars.add("abc");
          }else if(c=='3'){
            numChars.add("def");
          }else if(c=='4'){
            numChars.add("ghi");
          }else if(c=='5'){
            numChars.add("jkl");
          }else if(c=='6'){
            numChars.add("mno");
          }else if(c=='7'){
            numChars.add("pqrs");
          }else if(c=='8'){
            numChars.add("tuv");
          }else if(c=='9'){
            numChars.add("wxyz");
          }
        }

        List<String> result = new ArrayList<>();
        dfs(numChars,0,result,new StringBuilder());
return result;
    }

    private void dfs(List<String> numChars,int idx,List<String> result,StringBuilder sb){
        if(sb.length()== numChars.size()){
           result.add(sb.toString());
           return;
        }

        String w = numChars.get(idx);
        for(int i = 0; i< w.length(); i++){
             dfs(numChars,idx+1,result,new StringBuilder(sb).append(w.charAt(i)));
        }

    }
}
