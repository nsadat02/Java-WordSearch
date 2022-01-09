package wordsearch;

import java.util.*;
import java.io.*;

public class WordSearch {

    public static void main(String[] args) throws FileNotFoundException {
        int size=0;
        String word;
        
        Scanner b = new Scanner(new File("Board.txt"));
        Scanner w = new Scanner(new File("Words.txt"));
        //ArrayList<String> word = new ArrayList<>();
        
        size=Integer.parseInt(b.nextLine());
        System.out.println(size);
        
        char[][] board = new char[size][size];
        for (int i=0; i<size; i++) {
            board[i]=b.nextLine().toCharArray();
        }
        
        while(w.hasNextLine()){
            word=w.nextLine();
            if(checkWord(word,board,size)==true){
                System.out.println(word+" was found in the board");}
            else{
                System.out.println(word+" was NOT found in the board");
            }
        }
        //System.out.println(word+"");
        
    }
    
    public static boolean checkWord(String word,char[][] board,int size){       
        boolean found=false;
        
        for (int r=0; r<size; r++) {
            for (int c=0; c<size; c++) {
                if(board[r][c]==word.charAt(0)){
                    found=searchWord(word,board,size,r,c);
                    if(found==true){
                        return found;
                    }
                }
            }
        }
        
        return found;
    }
    
    public static boolean searchWord(String word,char[][] board,int size,int r, int c){
        int count,R,C;
        int[] row={-1,1,0,0,-1,-1,1,1};
        int[] col={0,0,-1,1,-1,1,-1,1};
        
        for (int x=0; x<8; x++) {
            count=1;
            R=r;
            C=c;
            //System.out.println(R+" "+C);
            for (int i=1; i<word.length(); i++) {
                R+=row[x];
                C+=col[x];
                if(R>=0 && R<board.length && C>=0 && C<board.length){
                    //System.out.println(board[R][C]+" "+R+" "+C);
                    if(board[R][C]==word.charAt(i)){
                        count++;
                    }
                }               
            }
            if(count==word.length()){
                return true;
            }
        }       
        return false;
    }
    
    
    
}
