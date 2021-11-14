package Adbistju.system.comparator;

import Adbistju.system.Constant;
import Adbistju.system.exception.ArgumentException;

public class FabricComparator {

    public Comparator FabricComparator(String[] args) {
        if(args.length == 0){
            throw new ArgumentException("no find argument");
        }
        for (int i = 0; i < args.length; i++) {
            if(args[i].equals(Constant.comparatorParam)&& i+1 <= args.length && args.length >=4){
                return new ComparatorByRegular(addParam(args[i+1]));
            }
        }
        return new ComparatorByNoParams();

    }


    private String addParam(String param){
        char[] chars = param.toCharArray();
        if(chars[0] == Constant.comparatorParamStart1|| chars[0] == Constant.comparatorParamStart2){
            return constructParam(chars);
        }else{
            return constructParamFileName(chars);
        }
    }

    private String constructParam(char[] chars){
        String param = "";
        int j = 0;
        if(chars[chars.length-1] == Constant.comparatorParamStart1 || chars[chars.length-1] == Constant.comparatorParamStart2 ){
            j++;
        }
        for (int i = 1; i < chars.length-j; i++) {
            param = param+chars[i];
        }
        if (!param.matches(param)){
            throw new ArgumentException("this regex is not correct");
        }
        return param;
    }

    private String constructParamFileName(char[] chars){
        String param = "";
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == Constant.comparatorParamArg){
                param = param + Constant.comparatorParamArgRep;
            }else{
                param = param+chars[i];
            }
        }
        return param;
    }
}
