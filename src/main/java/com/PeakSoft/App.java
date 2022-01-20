package com.PeakSoft;

import com.PeakSoft.jdbc.Tapshyrmajdbc6;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (true) {
        System.out.println("~~Бир санды танданыз танданыз~~");
        int a = scanner.nextInt();
            if (a == 1) {
                System.out.println(Tapshyrmajdbc6.connection());
            } else if (a == 2) {
                System.out.println(Tapshyrmajdbc6.printUsers());
            } else if (a == 3) {
                System.out.println(Tapshyrmajdbc6.printUsers1());
            } else if (a == 4) {
                Tapshyrmajdbc6.Number(scanner.nextInt());
            } else {
                System.out.println("kechiresiz tuura emes jazdynyz");
            }
        }
    }
}

