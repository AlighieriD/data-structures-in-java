package ch01.exercise.pr02;

/**
 * Created by YH on 2020/5/4.
 */
public class Pr02 {
    /**
     * 编写一个程序求解字谜游戏问题
     */

    /**
     * 对单词表中的每个单词，我们检查每一个有序三元组（行，列，方向）检验是否有单词存在。这需要大量的嵌套for循环。
     * @param pazzleBoard
     * @param words
     */
    public void wordSearch_1(char[][] pazzleBoard, String[] words){
        // 方向 上 下 左 右 左上 左下 右上 右下
        Direct[] directs = {new Direct(-1,0),new Direct(1,0),
                new Direct(0,-1),new Direct(0,1),
                new Direct(-1,-1),new Direct(1,-1),
                new Direct(-1,1),new Direct(1,1)};
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            tag:
            for (int j = 0; j < pazzleBoard.length; j++) {
                for (int k = 0; k < pazzleBoard[0].length; k++) {
                    // 如果第一个单词match，则去尝试不同方向
                    // 直到找到单词或者发现不匹配为止
                    if (pazzleBoard[j][k] == word[0]){
                        for (int l = 0; l < directs.length; l++) {
                            Direct d = directs[l];
                            for (int m = 0; m < word.length; m++) {
                                if (j + d.x * m < pazzleBoard.length &&
                                        j + d.x * m >= 0 &&
                                        k + d.y * m < pazzleBoard[0].length &&
                                        k + d.y * m >= 0 &&
                                        pazzleBoard[j + d.x * m][k + d.y * m] == word[m]){

                                    if (m == word.length-1){
                                        System.out.println(words[i] + ":" +
                                                "("+ j + "," + k + ")" + " - " +
                                                "("+ (j + d.x * m) + "," + (k + d.y * m) + ")");
                                        break tag;
                                    }

                                }else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * TODO 01 可能可以通过hash表来加快字符串搜索的时间
     * TODO 02 Trie树（前缀树）是否可以进一步加快搜索
     */

    private static class Direct{
        int x;
        int y;
        Direct(int x ,int y){
            this.x = x;
            this.y = y;
        }
    }
}
