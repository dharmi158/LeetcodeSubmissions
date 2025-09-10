class Solution {
    public void reverse(char[] c,int start,int end){
        while(start<end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;

            start++;
            end--;
        }
    }
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i=0;i<n;i+=2*k){
            int start = i;
            // for imcomplete 2k group 
            int end = Math.min(i+k-1,n-1);

            reverse(ch,start,end);
        }
        return new String(ch);
    }
}