// Given an absolute path for a file (Unix-style), simplify it.
//
// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
//
//
// click to show corner cases.
//
// Corner Cases:
//
//
//
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".


public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> st = new LinkedList<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.removeLast();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                st.add(s);
            }
        }
        for (String s : st) {
            sb.append(s + "/");
        }
        //Check if input is "", if not, remove last "/"
        if (!st.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
