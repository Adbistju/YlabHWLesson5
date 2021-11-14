package Adbistju.system;

import Adbistju.system.exception.ArgumentException;

public class ParserFilePathArg {

    public String addParams(String[] args){
        if(args.length < 2){
            throw new ArgumentException("few arguments were provided");
        }
        for (int i = 0; i < args.length; i++) {
            if(args[i].equals(Constant.filePathStartArg)){
                return args[i+1];
            }
        }
        throw new ArgumentException("no find argument file path");
    }

}
