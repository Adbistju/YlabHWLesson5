package Adbistju.system;

import Adbistju.system.comparator.FabricComparator;

public class Main {
    public static void main(String[] args) {
        SaxMyParser parser = new SaxMyParser();
        parser.setComparator(
                new FabricComparator().FabricComparator(args)
            ).setFilePath(
                new ParserFilePathArg().addParams(args)
        ).parse();
    }
}
