class PrefixTree {
    Trie[] trie=new Trie[26];;
    class Trie{
        char c;
        Trie[] childs = new Trie[26];
        boolean isWord;
    }

    public PrefixTree() {
         
    }

    public void insert(String word) {
char[] chars = word.toCharArray();
Trie[] tem = trie;
for(int i=0;i<chars.length;i++){
        int idx = chars[i]-'a';
        Trie t = tem[idx];
        if(t==null){
            t = new Trie();
            t.c=chars[i];
            tem[idx] = t;
        }
        if(i == chars.length-1)
        t.isWord=true;
      tem=t.childs;
}
    }

    public boolean search(String word) {
char[] chars = word.toCharArray();
Trie[] tem = trie;
Trie trie=null;
    for(int i=0;i<chars.length;i++){
        trie = tem[chars[i]-'a'];
        if(trie == null){
            return false;
        }
        tem = trie.childs;
    }
     return trie!=null && trie.isWord;
    }
   

    public boolean startsWith(String prefix) {
char[] chars = prefix.toCharArray();
Trie[] tem = trie;
Trie trie=null;
    for(int i=0;i<chars.length;i++){
        trie = tem[chars[i]-'a'];
        if(trie == null){
            return false;
        }
        tem = trie.childs;
    }
     return trie!=null;
    }
}
