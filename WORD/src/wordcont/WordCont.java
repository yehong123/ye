package wordcont;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import wordcont.Sort;

public class WordCont {

	public void displayWordCount(String fileName){
		//字符统计
    	try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = null;
	        TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
	        int count = 0;
	        while((line=reader.readLine())!=null){
	        	line = line.toLowerCase();
	        	String str[] = line.split("[【】、.。,\"!--;:?\'\\] ]");
	        	for(int i = 0; i<str.length; i++){
	        		 count++;
	        		String word = str[i].trim();
	        		if(tm.containsKey(word)){
	        			tm.put(word, tm.get(word)+1);
	        		}else{
	        			tm.put(word, 1);
	        		}
	        	}
	        }
	        //输出我们想要的字符串格式
            System.out.println("按字典序输出为：");
            Iterator iterator=tm.entrySet().iterator();
            while(iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
            System.out.println("该英文文本中共有单词："+count+"个");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void displayFrequencyWord(String fileName){
    	//显示输出
    	try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String s;
            StringBuffer sb = new StringBuffer();
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            
            Map<String,Integer> map = new HashMap<String, Integer>();
            StringTokenizer st = new StringTokenizer(sb.toString(),",.! \n");
            while (st.hasMoreTokens()) {
                String letter = st.nextToken().trim();
                int count;
                if (!map.containsKey(letter)) {
                    count = 1;
                } else {
                    count = map.get(letter).intValue() + 1;
                }
                map.put(letter,count);
            }
            
            Set<Sort> set = new TreeSet<Sort>();
            for (String key : map.keySet()) {
                set.add(new Sort(key,map.get(key)));
            }

            System.out.println("出现频率最高的单词：");
            Iterator<Sort> it1 = set.iterator();
            int count=it1.next().getCount();
            for (Iterator<Sort> it = set.iterator(); it.hasNext(); ) {
                Sort w = it.next();
                
                if (w.getCount()==count)// 当输出3个后跳出循环
                
                System.out.println(w.getKey() + " 出现的次数为： "+ w.getCount());
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到~！");
        } catch (IOException e) {
            System.out.println("文件读异常~！");
        }

    }

}
