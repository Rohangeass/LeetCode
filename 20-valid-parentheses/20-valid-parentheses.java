class Solution {
    public boolean isValid(String s) {
        int l=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<l;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{')
                st.push(ch);
            else
            {
                if(st.size()==0)
                    return false;
                if(')'== ch && '('!=st.peek())
                   return false;
                else if('}'== ch && '{'!=st.peek())
                    return false;
                else if(']'== ch && '['!=st.peek())
                    return false;
                else
                    st.pop();
                
            }
        }
        return (st.size()==0);
    }
}