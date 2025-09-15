class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder output = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            // Get current character by doing modulo of columnNumber by 26
            char c = (char) (columnNumber % 26 + 'A');
            // Divide columnNumber by 26
            columnNumber /= 26;
            // Append the character into output
            output.append(c);
        }
        // Reverse the output string
        // Bcause we have found characters from right to left
        output.reverse();
        // Return the reversed string.
        return output.toString();
    }
}