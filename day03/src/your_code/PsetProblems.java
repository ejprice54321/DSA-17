package your_code;

import ADTs.StackADT;

import java.util.*;

public class PsetProblems {

    public static int longestValidSubstring(String s) {
        int max = 0;
        int runningCount = 0;
        Stack stringStack = new Stack();
        for (int i=0; i<s.length(); i++){
            System.out.println(s.charAt(i));
            if (s.charAt(i) == '('){
                stringStack.push('(');
                System.out.println("peek " + stringStack.peek());
            } else if (stringStack.isEmpty()){
                if (runningCount > max){
                    max = runningCount;
                }
                runningCount = 0;
            } else if(s.charAt(i)==')'){
                stringStack.pop();
                runningCount += 2;
                System.out.println("realLength " + runningCount);
            }
        }
        if (runningCount > max){
            max = runningCount;
        }
        return max;
    }

    public static StackADT<Integer> sortStackLimitedMemory(StackADT<Integer> s) {
        StackADT<Integer> newStack = new MyStack();
        int holdVal = 0;
        while (!s.isEmpty()){
            if (newStack.isEmpty()){
                newStack.push(s.pop());
//                System.out.println("new" + newStack.peek());
//                System.out.println("s" + s.peek());
            } else if (s.peek() <= newStack.peek()){
                newStack.push(s.pop());
//                System.out.println("new" + newStack.peek());
//                System.out.println("s" + s.peek());
            } else if(s.peek() > newStack.peek()){
                holdVal = s.pop();
                while ((!newStack.isEmpty()) && (holdVal >= newStack.peek())) {
//                    ***** for some reason, this does not work when the while
//                    conditionals are in the other order. no clue why.
//                    System.out.println("Holding Value!" + holdVal);
                    s.push(newStack.pop());
//                    System.out.println("new" + newStack.peek());
//                    System.out.println("s" + s.peek());
                }
                newStack.push(holdVal);
                holdVal = 0;
            }
        }
        return newStack;
    }

}
