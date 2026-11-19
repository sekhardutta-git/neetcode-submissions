class WordDictionary {
    class TrieNode{
        TrieNode[] childs = new TrieNode[26];
        boolean isWord;
    }
    TrieNode root;

    public WordDictionary() {
       root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode tem = root;
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(tem.childs[idx] == null){
                tem.childs[idx] = new TrieNode();
            } 
            tem = tem.childs[idx];
        }
        tem.isWord = true;

    }

    public boolean search(String word) {
        return search(word,root,0);
    }


     public boolean search(String word,TrieNode current, int s) {
        for(int i = s;i<word.length();i++){
            char c = word.charAt(i);
            if(c =='.'){
                boolean found = false;
                for(TrieNode ch : current.childs){
                    if(ch!=null){
                         found = search(word,ch,i+1);
                        if(found){
                            break;
                        }
                    }
                    
                } 
                return found;
            }else{
             int idx = c -'a';
             current = current.childs[idx];
             if(current == null){
              return false;
             }
            }
        }
        return  current.isWord;
    }
}
