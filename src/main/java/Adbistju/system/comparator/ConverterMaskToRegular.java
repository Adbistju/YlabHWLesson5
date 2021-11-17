package Adbistju.system.comparator;

import Adbistju.system.Constant;
import Adbistju.system.exception.ArgumentException;

public class ConverterMaskToRegular {

    public static String addParam(String param){
        char[] chars = param.toCharArray();
        if(chars[0] == Constant.comparatorParamStart1|| chars[0] == Constant.comparatorParamStart2){
            return constructParam(chars);
        }else{
            return constructParamFileName(chars);
        }
    }

    //Было введено чистое регулярное выражение в кавычках ``
    public static String constructParam(char[] chars){
        StringBuilder newMask = new StringBuilder();
        int j = 0;
        if(chars[chars.length-1] == Constant.comparatorParamStart1 || chars[chars.length-1] == Constant.comparatorParamStart2 ){
            j++;
        }
        for (int i = 1; i < chars.length-j; i++) {
            newMask.append(chars[i]);
        }
//        if (!newMask.toString().matches(newMask.toString())){
//            throw new ArgumentException("this regex is not correct -> "+ String.valueOf(newMask));
//        }
        return String.valueOf(newMask);
    }

    //Была введена маска для поиска или конкретное имя
    public static String constructParamFileName(char[] chars){
        StringBuilder newMask = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case '.' :
                    newMask.append("\\.");
                    break;
                case '?' :
                    newMask.append(".");
                    break;
                case '*' :
                    newMask.append(".*");
                    break;
                default  :
                    newMask.append(chars[i]);
                    break;
            }
        }
        if (!newMask.toString().matches(newMask.toString())){
            throw new ArgumentException("this regex is not correct -> "+ String.valueOf(newMask));
        }
        return String.valueOf(newMask);
    }
}
