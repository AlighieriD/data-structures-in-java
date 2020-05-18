package ch01.exercise.pr15;


import java.util.Comparator;

/**
 * Created by YH on 2020/5/14.
 */
public class Pr15 {
    /**
     * 定义一个Rectangle类，该类提供getLength和getWidth方法。
     * 利用图1-18中的findMax例程编写一种main方法，该方法创建一个Rectangle数组
     * 并首先找出依面积最大的Rectangle对象，然后找出依周长最大的Rectangle对象。
     */

    public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp){
        int maxInd = 0;
        for (int i = 1; i < arr.length; i++) {
            if (cmp.compare(arr[maxInd], arr[i]) < 0)
                maxInd = i;
        }
        return arr[maxInd];
    }

    public Rectangle getMaxS(Rectangle[] arr){
        Comparator<Rectangle> c = (o1,o2) -> (o1.length * o1.width) - (o2.length * o2.width);
        Rectangle r = findMax(arr,c);
        return r;
    }

    public Rectangle getMaxC(Rectangle[] arr){
        Comparator<Rectangle> c = Comparator.comparing((r)->r.width*2 + r.length*2);
        Rectangle r = findMax(arr,c);
        return r;
    }

    public static class Rectangle {
        private int length;
        private int width;
        public Rectangle(int length, int width){
            this.length = length;
            this.width = width;
        }
        public int getLength(){
            return length;
        }
        public int getWidth(){
            return width;
        }
    }


}
