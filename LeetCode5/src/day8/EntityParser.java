package day8;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 题解思路：
 * 数组存储需要替换的html的字符集
 * 判断字符串以& 开头 并和字符串进行比对
 */
public class EntityParser {
    public static void main(String[] args) {
        String text = "&amp; is an HTML entity but &ambassador; is not.&";
        EntityParser entityParser = new EntityParser();
        String s = entityParser.entityParser(text);
        System.out.println(s);
    }

    public String entityParser(String text) {
        text = text.replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")
                .replaceAll("&gt;", ">")
                .replaceAll("&amp;", "&")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/");
        return text;
    }
    public String entityParser2(String text) {
        //1. 创建map存储字符
        Map<String, String> map = new HashMap<>();
        map.put("&quot;","\"");
        map.put("&apos;","'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");
        StringBuilder textBuilder = new StringBuilder(text);
        for (int i = textBuilder.length()-1; i >=0 ; i--) {
            if(text.charAt(i) == '&') {
                for (int j = 3; j <= 6; j++) {
                    if(i+j+1>textBuilder.length())
                        break;
                    String substring = textBuilder.substring(i, i + j+1);
                    String replace = map.get(substring);
                    if (replace!=null) {
                        textBuilder.replace(i,j+i+1,replace);
                        break;
                    }
                }
            }
        }
        return textBuilder.toString();
    }
}
