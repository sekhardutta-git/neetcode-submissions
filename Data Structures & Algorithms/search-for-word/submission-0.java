class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if( findWord(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

     boolean findWord(char[][] board,int x, int y,String word, int pos ){
        if(x<0 || x >=board.length || y<0 || y >=board[0].length){
            return false;
        }
    char c =board[x][y];
    if(c=='#' || c!=word.charAt(pos)){
     return false;
    }
    if(pos == word.length()-1){
        return true;
    }
    board[x][y]='#';
    boolean found =  findWord(board,x+1,y,word,pos+1)
     || findWord(board,x-1,y,word,pos+1)
    || findWord(board,x,y+1,word,pos+1)
      || findWord(board,x,y-1,word,pos+1);
 board[x][y]=c;
 return found;
    }
}
