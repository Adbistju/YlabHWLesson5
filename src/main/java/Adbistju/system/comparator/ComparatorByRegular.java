package Adbistju.system.comparator;

import java.util.regex.Pattern;

public class ComparatorByRegular extends Comparator{

    private String param;
    private Pattern pattern;

    public ComparatorByRegular(String param) {
        this.param = param;
        this.pattern = Pattern.compile(param);
    }

    @Override
    public boolean check(String name) {
//        return name.matches(param);
        return pattern.matcher(name).matches();
    }
}
