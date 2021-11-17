package Adbistju.system;

import Adbistju.system.comparator.Comparator;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserHandler extends DefaultHandler {


    private String currentTagName;

    private Comparator comparator;

    public SaxParserHandler(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTagName = qName;
        if(currentTagName.equals(Constant.child)){
            comparator.setCurrentIsFile(Boolean.parseBoolean(attributes.getValue(Constant.isFile)));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(currentTagName.equals(Constant.child)){
            comparator.setCurrentIsFile(false);
            comparator.exitDir();
        }
        currentTagName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentTagName == null) {
            return;
        }
        if(!new String(ch, start, length).isBlank()){
            if(comparator.getAddress().size() == 0){
                if (new String(ch, start, length).equals(Constant.delimiter)){
                    comparator.addAddress("");
                }else{
                    comparator.addAddress(new String(ch, start, length));
                }
            }else if(currentTagName.equals(Constant.name)){
                if(comparator.isCurrentIsFile() && comparator.check(new String(ch, start, length))){
                    comparator.print(new String(ch, start, length));
                }else if(!comparator.isCurrentIsFile() && comparator.check(new String(ch, start, length))){
                    comparator.print(new String(ch, start, length));
                    comparator.addAddress(new String(ch, start, length));
                }else if(!comparator.isCurrentIsFile()){
                    comparator.addAddress(new String(ch, start, length));
                }
            }
        }
    }
}
