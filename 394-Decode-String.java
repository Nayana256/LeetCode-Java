class Solution {
    public String decodeString(String s) {
        Stack<Integer>stack1=new Stack<>();
        Stack<StringBuilder>stack2= new Stack<>();
        int num=0;
        StringBuilder current=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }else if(c=='['){
                stack1.push(num);
                stack2.push(current);
                num=0;
                current= new StringBuilder ();
            }else if(Character.isLetter(c)){
                current.append(c);
            }else if(c==']'){
                int x=stack1.pop();
                StringBuilder prev=stack2.pop();
                StringBuilder temp=new StringBuilder ();
                for(int j=0;j<x;j++){
                    temp.append(current);
                }
                prev.append(temp);
                current=prev;
            }
        }
        return current.toString();
    }
}