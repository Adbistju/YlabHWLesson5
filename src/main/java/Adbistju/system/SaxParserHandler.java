package Adbistju.system;

import Adbistju.system.comparator.Comparator;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SaxParserHandler extends DefaultHandler {
    private static ArrayList<String> address = new ArrayList<>();

    private boolean currentIsFile = false;
    private String currentTagName;

    private Comparator comparator;

    public SaxParserHandler(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTagName = qName;
        if(currentTagName.equals(Constant.child)){
            currentIsFile = Boolean.parseBoolean(attributes.getValue(Constant.isFile));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(currentTagName.equals(Constant.child)){
            currentIsFile = false;
            address.remove(address.size()-1);
        }
        currentTagName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentTagName == null) {
            return;
        }
        if(!new String(ch, start, length).isBlank()){
            if(address.size() == 0){
                if (new String(ch, start, length).equals(Constant.delimiter)){
                    address.add("");
                }else{
                    address.add(new String(ch, start, length));
                }
            }else if(currentTagName.equals(Constant.name)){
                if(currentIsFile && comparator.check(new String(ch, start, length))){
                    print(new String(ch, start, length));
                }else if(!currentIsFile && comparator.check(new String(ch, start, length))){
                    print(new String(ch, start, length));
                    address.add(new String(ch, start, length));
                }else if(!currentIsFile){
                    address.add(new String(ch, start, length));
                }
            }
        }
    }

    private void print(String str){
        for (int i = 0; i < address.size(); i++) {
            System.out.print(address.get(i)+Constant.delimiter);
        }
        System.out.println(str);
    }
}
