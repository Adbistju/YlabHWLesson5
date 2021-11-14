package Adbistju.system.comparator;

import java.util.regex.Pattern;

public class ComparatorByRegular extends Comparator{

    private Pattern pattern;

    public ComparatorByRegular(String param) {
        this.pattern = Pattern.compile(param);
    }

    @Override
    public boolean check(String name) {
        return pattern.matcher(name).matches();
    }
}
