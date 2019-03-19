package wordcont;
import java.io.BufferedReader;
import java.io.BufferedWriter;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 import java.util.TreeMap;
 

 import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
    	System.out.println("�����ļ�·����\n");			
		Scanner in=new Scanner(System.in);
		String line=in.nextLine();
		String fileName= line.trim();
		WordCont wc = new WordCont();
		wc.displayWordCount(fileName);
		wc.displayFrequencyWord(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/result.txt"));
         String s;
         int con =0;
         while ((s = bufferedReader.readLine()) != null) {
             Map<String, Integer> map = new TreeMap<String, Integer>();
             //����һ��words���飬�ָ��ַ�������ͳ�Ƶ��ʳ��ֵĴ���
            String[] words = s.split("[������.��,\"!--;:?\'\\] ]");
             for (int i = 0; i < words.length; i++) {
            	 con++;
                 String key = words[i].toLowerCase();
                 if (key.length() > 0) {
                     if (!map.containsKey(key)) {
                         map.put(key, 1);
                     } else {// ������ǵ�һ�γ��֣��Ͱ�valueֵ++����ôvalueֵ�Ƕ��پ��ǳ����˼���
                        int value = map.get(key);
                         value++;
                         map.put(key, value);
                     }
                 }
             }
             Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
             for (Map.Entry<String, Integer> entry : entrySet) {
                 
                 bufferedWriter.write(entry.getKey() +"---"+ entry.getValue()+"\r\n");
             }
             bufferedWriter.write("��Ӣ���ı��й��е��ʣ�"+con+"��"+"\r\n");
             bufferedWriter.newLine();
         }
         // �ر���������� 
        bufferedReader.close();
         bufferedWriter.close();
     }
 }