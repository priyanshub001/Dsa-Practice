import java.util.*;

class Solution {
    int index = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    Set<String> parse(String s) {
        Set<String> res = new HashSet<>();
        res.add("");

        while (index < s.length() && s.charAt(index) != '}') {
            char c = s.charAt(index);

            if (c == ',') {
                index++;
                Set<String> next = parse(s);
                res.addAll(next);
                return res;
            }

            Set<String> part;

            if (c == '{') {
                index++;
                part = parse(s);
                index++;
            } else {
                part = new HashSet<>();
                part.add(String.valueOf(c));
                index++;
            }

            res = multiply(res, part);
        }

        return res;
    }

    Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> res = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                res.add(x + y);
            }
        }

        return res;
    }
}