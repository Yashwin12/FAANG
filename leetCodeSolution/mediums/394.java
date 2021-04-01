class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == ']') {
                makePattern(new StringBuilder(), stack);
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    private void makePattern(StringBuilder sb, Stack<Character> stack) {

        while (!stack.isEmpty() && stack.peek() != '[') {
            sb.append(stack.pop());
        }

        if (stack.peek() == '[') {
            stack.pop();

            StringBuilder patternRepeator = new StringBuilder();

            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                patternRepeator.insert(0, stack.pop());
            }

            appendToStack(sb, stack, Integer.valueOf(patternRepeator.toString()));
        }
    }

    private void appendToStack(StringBuilder sb, Stack<Character> stack, int patternRepeator) {
        while (patternRepeator > 0) {
            for (int i = sb.length() - 1; i >= 0; i--) {
                stack.push(sb.charAt(i));
            }
            patternRepeator--;
        }   
    }
}
