package com.codewars.pramp;

/**
 * @author Sergey Golitsyn
 * created on 13.02.2023
 */
public class ValidateIPAddress {


    static int Calculate(int a){
        if (a <= 2){
            return 1;
        } else {
            return Calculate((int) Math.floor(Math.sqrt(a)))+ a;
        }
    }
    static boolean validateIP(String ip) {
        // your code goes here

        String[] addresses = ip.split("\\.");

        if(addresses.length != 4){
            System.out.println("addresses: " + addresses.length);
            return false;
        }

        for(String address : addresses){
            try{
                if(address.length() > 1 && address.charAt(0) == '0'){
                    System.out.println("address: " + address);
                    return false;
                }

                int add = Integer.parseInt(address);
                if(add < 0 || add > 255){
                    System.out.println("add: " + add);
                    return false;
                }
            } catch(Exception ex){
                System.out.println("ex");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Calculate(4));
    }
}
