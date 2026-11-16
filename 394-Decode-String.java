/*
Problem Number: 394

Problem Name: Decode String

Approach:
Used the Stack approach.

Used two stacks to decode the string:
1. One stack stores the repetition numbers.
2. Another stack stores the previous strings.

When '[' is encountered, push the current number and string into their respective stacks.

When ']' is encountered, pop the repetition number and previous string, repeat the current string the required number of times, and append it to the previous string.

Continue until the entire encoded string is decoded.

Data Structures Used:
1. Stack<Integer> – Stores repetition counts.
2. Stack<StringBuilder> – Stores previous strings.
3. StringBuilder – Builds the decoded string.

Time Complexity: O(n + k)
where n = length of the encoded string
k = length of the decoded output.

Space Complexity: O(n + k)
For storing the stacks and the decoded output.

*/


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