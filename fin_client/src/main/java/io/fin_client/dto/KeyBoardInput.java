package io.fin_client.dto;

import java.math.BigDecimal;
import java.util.Scanner;

public class KeyBoardInput {

    private Long categoryId;
    private BigDecimal amount;
    private Long userId;


    public KeyBoardInput() {
    }

    public Long enterCategoryIdFromKeyBoard(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter some number CategoryId: ");
        Long input = in.nextLong();
      //  System.out.println("Your input is: " + input);
        return input;
    }

    public BigDecimal enterAmountFromKeyBoard(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter some number Amount: ");
        BigDecimal amount = in.nextBigDecimal();
        return amount;
    }

    public Long enterUserIdFromKeyBoard(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter some number UserId: ");
        Long userId = in.nextLong();
        return userId;
    }




}
