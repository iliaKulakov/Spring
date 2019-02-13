package io.fin_client.dto;

import java.util.Scanner;

public class KeyBoardInput {
    public KeyBoardInput() {
    }

    public Long enterFromKeyBoard(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter some number: ");
        Long input = in.nextLong();


      //  System.out.println("Your input is: " + input);
        return input;
    }



}
