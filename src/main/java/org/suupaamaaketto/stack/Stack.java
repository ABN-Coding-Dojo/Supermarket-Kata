package org.suupaamaaketto.stack;

public class Stack {

    Boolean isEmpty=true;
    public Boolean isEmpty() {
        return isEmpty;
    }
    
    public void push(String input){
        isEmpty=false;
    }
}
