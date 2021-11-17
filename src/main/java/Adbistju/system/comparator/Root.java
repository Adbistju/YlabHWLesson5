package Adbistju.system.comparator;

import Adbistju.system.Constant;

import java.util.ArrayList;

public abstract class Root {
    protected static ArrayList<String> address = new ArrayList<>();

    protected boolean currentIsFile = false;


    public boolean isCurrentIsFile() {
        return currentIsFile;
    }

    public void setCurrentIsFile(boolean currentIsFile) {
        this.currentIsFile = currentIsFile;
    }

    public void exitDir() {
        address.remove(address.size()-1);
    }

    public ArrayList getAddress() {
        return address;
    }

    public void addAddress(String value) {
        address.add(value);
    }

    public void print(String str){
        for (int i = 0; i < address.size(); i++) {
            System.out.print(address.get(i)+ Constant.delimiter);
        }
        System.out.println(str);
    }
}
