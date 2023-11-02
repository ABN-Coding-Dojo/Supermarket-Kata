package org.suupaamaaketto.stack;

public class Stack {

    private int numItems = 0;

    public Boolean isEmpty() {
        return numItems == 0;
    }
    
    public void push(String input){
        numItems += 1;
    }

    public String pop()throws UnderFlowException
    {
        if(isEmpty()){
            throw new UnderFlowException();
        }

        numItems -= 1;
        return "1";
    }
}
