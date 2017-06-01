/**
71. Simplify Path
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
public class Solution {
    public String simplifyPath(String path) {
        final String[] names = path.split("/");
        final Stack<String> levels = new Stack<>();
        for(String name:names)
        {
            if(name.isEmpty()||name.equals("."))
            {
                continue;
            }
            else if(name.equals(".."))
            {
                if(!levels.empty())
                {
                    levels.pop();
                }
                continue;
            }
            else
            {
                levels.push(name);
            }
        }
        if(levels.empty())
        {
            return "/";
        }
        final StringBuilder builder = new StringBuilder();
        while(!levels.empty())
        {
            builder.insert(0,levels.pop()).insert(0,"/");
        }
        return builder.toString();
        
    }
}