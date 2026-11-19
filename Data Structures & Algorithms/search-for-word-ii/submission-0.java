class Solution {
    class TrieNode{
        TrieNode[] childrens = new TrieNode[26];
        String word;
    }

    private void addWord(TrieNode root, String word){
       for(int i=0;i<word.length();i++){
        char c = word.charAt(i);
        int idx = c -'a';
        if(root.childrens[idx] == null){
            root.childrens[idx]=new TrieNode();
        }
        root = root.childrens[idx];
       }
         root.word = word;    
    }



    public List<String> findWords(char[][] board, String[] words) {
          TrieNode root = new TrieNode();
          for(String word :words){
             addWord(root,word);
          }
          int x = board.length;
          int y = board[0].length;
          List<String> resultWords = new ArrayList<>();
          for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
               matchWords(board,root,i,j,resultWords);
            }
          }
          return resultWords;
    }

    private void matchWords(char[][] board,TrieNode root,int x, int y,List<String> resultWords){
       if(x<0 || y<0 || x>=board.length || y>=board[0].length){
          return;
       }
       char c = board[x][y];
       if(c == '#'){
            return;
       }
       
       TrieNode tem = root.childrens[c-'a'];
     if (tem == null){
       return;
     }
  if(tem.word!=null){
        resultWords.add(tem.word);
        tem.word = null;
  }
  board[x][y] = '#';

  matchWords(board,tem,x,y+1,resultWords);
  matchWords(board,tem,x,y-1,resultWords);
  matchWords(board,tem,x+1,y,resultWords);
  matchWords(board,tem,x-1,y,resultWords);
board[x][y] = c;

    }
}
