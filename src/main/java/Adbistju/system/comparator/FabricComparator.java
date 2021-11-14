package Adbistju.system.comparator;

import Adbistju.system.Constant;
import Adbistju.system.exception.ArgumentException;

public class FabricComparator {

    public Comparator FabricComparator(String[] args) {
        if(args.length == 0){
            throw new ArgumentException("no find argument");
        }
        for (int i = 0; i < args.length; i++) {
            if(args[i].equals(Constant.comparatorParam)&& i+1 <= args.length){
                return new ComparatorByRegular(ConverterMaskToRegular.addParam(args[i+1]));
            }
        }
        return new ComparatorByNoParams();
    }
}
