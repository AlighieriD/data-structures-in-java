package ch01.exercise.pr04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by YH on 2020/5/9.
 */
public class Pr04 {
    /**
     * 编写一个程序，使它读入被一些include语句修饰的文件并且输出这个文件。
     */

    private static Map<String,Boolean> map = new HashMap<>();
    public void processFile(String name) throws FileNotFoundException {
        if (map.containsKey(name)){
            return;
        }else {
            map.put(name,true);
        }
        File file = new File(name);
        if (!file.exists())
            throw new FileNotFoundException(name);
        System.out.println("加载： "+name);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] sb = line.split(" ");
            String filePath = name.substring(0,name.lastIndexOf('/')+1);
            String compactName = compact(filePath,sb[1]);
            processFile(compactName);
        }
    }

    private String compact(String filePath, String fileName){
        String[] parts = (filePath+fileName).split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < parts.length; i++) {
            if (".".equals(parts[i])){
                continue;
            }else if ("..".equals(parts[i]) && !stack.isEmpty()){
                stack.pop();
            }else {
                String e = parts[i];
                if (i != parts.length - 1){
                    e += "/";
                }
                stack.push(e);
            }
        }
        StringBuilder compact = new StringBuilder();
        while (!stack.isEmpty()){
            compact.append(stack.pollLast());
        }
        return compact.toString();
    }

}
