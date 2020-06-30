package ch04.exercise.pr10;

import java.io.File;
import java.util.Scanner;

/**
 * Created by YH on 2020/7/1.
 */
public class Pr10 {

    //编写一个程序，该程序列出一个目录中所有的文件和它们的大小。
    private static long printSize(File file,String prefix){
        long size = 0;
        if (!file.isDirectory()){
            size = file.length();
        }else {
            for (File f : file.listFiles()){
                size += printSize(f,prefix + "  ");
            }
        }
        System.out.println(prefix+file.getName()+" "+size);
        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入目录/文件");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        if (file.isDirectory() || file.isFile()){
            long l = printSize(file,"");
            System.out.println("郁昊:"+l);
        }else {
            System.out.println("不是目录或者文件");
        }
    }
}
