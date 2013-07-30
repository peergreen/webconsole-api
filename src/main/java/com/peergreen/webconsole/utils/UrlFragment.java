package com.peergreen.webconsole.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mohammed Boukada
 */
public class UrlFragment {

    private static Pattern p = Pattern.compile("(/([^/]*))(/([^/]*))*");

    public static String getFirstFragment(String s) {
        Matcher m = p.matcher(s);
        if (m.matches()) return m.group(1);
        return s;
    }

    public static String subFirstFragment(String s) {
        Matcher m = p.matcher(s);
        if (m.matches()) return s.substring(m.group(1).length());
        return s;
    }
}
