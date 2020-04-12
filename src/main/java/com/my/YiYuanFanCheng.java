package com.my;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YiYuanFanCheng {
    public static void main(String[] args){
         String str = "2x+5-3+x=6+x-2";
        //String str = "2x+5-3+x=6-2";
        double res = caculate(str);
        System.out.println(res);
    }
    static class SuanShi{
        int weizhisu;
        int chansu;
        char x;
        SuanShi(String str){
            int len = str.length();
            for(int i=0;i<len;i++){
                char c = str.charAt(i);
                if((c<='9'&&c>='0')||c=='+'||c=='-'){

                } else {
                    x = c;
                    break;
                }
            }
            chansu=0;
            weizhisu=0;
            //2x+5-3+x
            //str = "+" + str;
            // +2x+5-3+x
            str = str.replace("+","#+");
            str = str.replace("-","#-");
            //|+2x|+5|-3|+x
            String[] subStrs = str.split("#");
            for(String subStr : subStrs){
                boolean zhen = true;
                if(subStr.startsWith("-")) {
                    zhen = false;
                }
                subStr = subStr.replace("-","");
                subStr = subStr.replace("+","");
                Pattern pattern = Pattern.compile("[0-9]*");
                Matcher isNum = pattern.matcher(subStr);
                if(isNum.matches()){
                    // is num
                    int value = Integer.parseInt(subStr);
                    if(zhen){
                        chansu = chansu + value;
                    } else {
                        chansu = chansu - value;
                    }
                } else {
                    // not num
                    subStr = subStr.replace(String.valueOf(x),"");
                    int value;
                    if(subStr.length()==0){
                        value = 1;
                    } else {
                        value = Integer.parseInt(subStr);
                    }
                    if(zhen){
                        weizhisu = weizhisu + value;
                    } else {
                        weizhisu = weizhisu - value;
                    }
                }
            }

        }
    }

    private static double caculate(String str) {
        String[] array = str.split("=");
        SuanShi left = new SuanShi(array[0]);
        SuanShi right = new SuanShi(array[1]);
        double fenmu=right.chansu-left.chansu;
        double fenzi=left.weizhisu-right.weizhisu;
        return fenmu/fenzi;
        //return left.;
    }
}
