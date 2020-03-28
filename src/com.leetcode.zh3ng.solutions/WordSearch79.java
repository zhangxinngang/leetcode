package com.leetcode.zh3ng.solutions;

public class WordSearch79 {

    //解题思路， 深度优先搜索  DFS
    public boolean exist(char[][] board, String word) {
        int orientation = 0;  //1 左，2 右，3 上 4 下
        boolean ok = false;
        for (int row=0;row < board.length;row++){
            for (int col=0;col<board[row].length;col++){
                if (board[row][col] == word.charAt(0)){
                    board[row][col] = ' ';
                    boolean o = exists(board,word,1,orientation,row,col,board);
                    if (!o){
                        board[row][col] = word.charAt(0);
                    }else{
                        ok = ok || o;
                    }
                }
            }
        }
        return ok;
    }

    public boolean exists(char[][]board,String word,int index,int orientation,int row,int col,char[][] touched){
        boolean exist = false;
        if (index == word.length()){
            return true;
        }
        //向右试探
        if (board[0].length > col+1&&board[row][col+1] == word.charAt(index) && orientation != 1){
            touched[row][col+1] = ' ';
            System.out.println("2 " + index);
            boolean o = exists(board,word,index+1,2,row,col+1,touched);
            if (!o){
                touched[row][col+1] = word.charAt(index);
            }
            exist = exist|| o;
        }
        //向下试探
        if (row + 1 < board.length && board[row+1][col] == word.charAt(index) && orientation != 3){
            touched[row+1][col] = ' ';
            System.out.println("4 " + index);
            boolean o = exists(board,word,index+1,4,row +1,col,touched);
            if (!o){
                touched[row+1][col] = word.charAt(index);
            }
            exist = exist||o;
        }
        //向左试探
        if (col - 1 >= 0 && board[row][col-1] == word.charAt(index)&& orientation != 2) {
            touched[row][col-1] =' ';
            System.out.println("1 " + index);
            boolean o = exists(board,word,index+1,1,row,col-1,touched);
            if (!o){
                touched[row][col-1] = word.charAt(index);
            }
            exist = exist||o;
        }
        //向上试探
        if (row - 1 >= 0 && board[row-1][col] == word.charAt(index) && orientation != 4){
            touched[row-1][col] = ' ';
            System.out.println("3 " + index);
            boolean o = exists(board,word,index+1,3,row-1,col,touched);
            if (!o){
                touched[row-1][col] = word.charAt(index);
            }
            exist = exist||o;
        }
        return exist;
    }


    public static void main(String[] args) {
        WordSearch79 wordSearch79 = new WordSearch79();

        char[][] board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'},
        };


//        System.out.println(wordSearch79.exist(board,"ABCCED") + "true");
//        System.out.println(wordSearch79.exist(board,"ABCB")+ "false");
        System.out.println(wordSearch79.exist(board,"SEE") + "true");
//
//        char[][] board1 = new char[][]{
//                new char[]{'A','A','A','A'},
//                new char[]{'A','A','A','A'},
//                new char[]{'A','A','A','A'},
//        };
//        System.out.println(wordSearch79.exist(board1,"AAAAAAAAAAAAA") + "faslse");

        char[][] board2 = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','E','S'},
                new char[]{'A','D','E','E'},
        };
        //System.out.println(wordSearch79.exist(board2,"ABCESEEEFS")+ "true");

        System.out.println(wordSearch79.exist(board2,"ABCEFSADEESE")+ "true");
    }
}

