// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList();
//         backtrack(ans, "", 0, 0, n);
//         return ans;
//     }

//     public void backtrack(List<String> ans, String cur, int open, int close, int max) {
//         if (cur.length() == max * 2) {
//             ans.add(cur);
//             return;
//         }

//         if (open < max)
//             backtrack(ans, cur + "(", open + 1, close, max);
//         if (close < open)
//             backtrack(ans, cur + ")", open, close + 1, max);
//     }
// }


// Stringbuilder is mutable so has to be removed after changes are done; while string is immutable so everytime a new string is created when modified. 
// HACK: https://stackoverflow.com/questions/65037190/getting-different-result-stringbuilder-vs-string-using-recusrion-in-java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        helperMethod(list, new StringBuilder(), 0, 0, n);

        return list;
    }

    private void helperMethod(List<String> list, StringBuilder sb, int open, int close, int max) {

        // Goal or base case
        if (sb.length() == max * 2) {
            list.add(sb.toString());
            return;
        }

        // constraint
        if (open < max) {
            // choices
            helperMethod(list, sb.append("("), open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        // constraint
        if (open > close) {
            // choices
            helperMethod(list, sb.append(")"), open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}