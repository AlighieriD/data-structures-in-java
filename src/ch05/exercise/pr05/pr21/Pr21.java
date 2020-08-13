package ch05.exercise.pr05.pr21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by YH on 2020/8/12.
 */
public class Pr21 {
    /**
     *
     * 通过使用散列表实现一个拼写检查程序。设词典来自两个来源：一本现有的大词典以及包含一本个人词典的第二个文件。
     * 输出所有拼错的单词和这些单词出现的行号。
     * 再有，对于每个拼错的单词列出应用下列任一种法则在词典中能够得到的任意的单词：
     * a. 添加一个字符
     * b. 去掉一个字符
     * c. 交换两个相邻的字符。
     */

    private static class Entry{
        public int line;
        public List<String> words;
        public Entry(int line, List<String> words){
            this.line = line;
            this.words = words;
        }
    }

    public static Map<String,Entry> wordTest() throws FileNotFoundException {
        String dictName = Pr21.class.getResource("dict.txt").getPath();
        File dict = new File(dictName);

        String personName = Pr21.class.getResource("person.txt").getPath();
        File person = new File(personName);

        Set<String> wordSet = new HashSet<>();
        Scanner scanner1 = new Scanner(dict);
        while (scanner1.hasNextLine())
            wordSet.add(scanner1.nextLine());
        Scanner scanner2 = new Scanner(person);
        while (scanner2.hasNextLine())
            wordSet.add(scanner2.nextLine());

        String inputName = Pr21.class.getResource("input.txt").getPath();
        File input = new File(inputName);

        Map<String,Entry> result = new HashMap<>();
        Scanner scanner = new Scanner(input);
        int i = 1;
        while (scanner.hasNextLine()){
            String word = scanner.nextLine();
            if (!wordSet.contains(word)){
                Entry entry = new Entry(i,new ArrayList<>());
                test(wordSet,word,entry.words);
            }
            i++;
        }
        return result;
    }

    private static void test(Set<String> set, String input, List<String> result){

    }

    public static void main(String[] args) {
        try {
            Map<String,Entry> m = wordTest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
