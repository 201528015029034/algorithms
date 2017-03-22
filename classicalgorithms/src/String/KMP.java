package String;

/**
 * Created by silence on 2017/3/19.
 * 详细思路见‘算法 日常积累（思路）’之KMP
 */
public class KMP {
    private String pat;
    private int[][] dfa;
    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for(int X=0, j=1; j<M; j++) {
            //计算dfa[?][j]
            for(int c=0; c<R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        //在txt上模拟DFA的运行
        int i, j, N = txt.length(), M = pat.length();
        for(i=0, j=0; i<N && j<M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if(j == M) return i-M; // 找到匹配（到达模式字符串的结尾）
        else return N; //未找到匹配（达到文本字符串的结尾）
    }

    public static void main(String[] args) {
        String txt = "BCBAABACAABABACAA";
        System.out.print(new KMP("ABABAC").search(txt));
    }
}/*
Output 9,从源字符串位置9开始匹配，匹配成功
*/
