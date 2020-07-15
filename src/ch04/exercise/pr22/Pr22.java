package ch04.exercise.pr22;

import ch04.exercise.pr21.Pr21;

public class Pr22 {

    //设计一个线性时间算法，该算法检验AVL树中的高度信息是否被正确保留并且平衡性质是否成立。
    // 1.是否被正确保留
    // 2.平衡性质是否成立。
    public static class PR22_isBalance<K extends Comparable<? super K>,V> extends Pr21.MyAVLTree<K,V>{

        public static void isCorrectAndBalance(PR22_isBalance avlTree){
            isCorrectAndBalance(avlTree.root);
        }

        private static int isCorrectAndBalance(EntryNode t){
            if (t == null)
                return -1;
            int left = isCorrectAndBalance(t.left);
            int right = isCorrectAndBalance(t.right);
            //isCorrect
            int curHight = height(t);
            int hight = Math.max(left,right) + 1;
            boolean isCorrect = curHight == hight;
            System.out.println("当前节点树高："+curHight + " , " + "是否正确" + isCorrect);
            //isBalance
            System.out.println("左树高："+ left + " , " + "右树高："+right);
            System.out.println("--------------------------------------");
            return hight;
        }
    }
}
