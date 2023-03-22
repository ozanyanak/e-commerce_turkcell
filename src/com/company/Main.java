package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int islem;
        int para;

        Scanner scanner= new Scanner(System.in);
        Account account1= new Account(1, "ozan yanak");
        System.out.println("yapmak istediğiniz işlemi seçiniz");
        System.out.println("1: para yatırmak");
        System.out.println("2: para çekmek");
        islem=scanner.nextInt();
        if (islem==1){
            System.out.println("para miktarı giriniz");
            para=scanner.nextInt();
            account1.plus(para);
        }
        else {
            System.out.println("para miktarı giriniz");
            para=scanner.nextInt();
            account1.down(para);

        }

        account1.plus(5000);
        System.out.println(account1.getBakiye());

        System.out.println(account1.toString());
    }


}
