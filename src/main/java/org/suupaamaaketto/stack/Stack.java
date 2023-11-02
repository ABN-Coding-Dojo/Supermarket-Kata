package org.suupaamaaketto.stack;

public class Stack {

    Boolean isEmpty=true;
    public Boolean isEmpty() {
        return isEmpty;
    }
    
    public void push(String input){
        isEmpty=false;
    }

    public int pop()throws UnderFlowException
    {
        throw new UnderFlowException();       
    }
}
