package Evalution_6;

import java.util.Scanner;

public class Mainfile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student AND Teacher Database");
        boolean flag = true;
        while(flag){
            MenuFuntionality menuFuntionality = new MenuFuntionality();
            System.out.println("0 for exit\n1 for retrive data\n2 for update\n3 for delete\n4 for insert\n5 for find all the student whoes names start with z\n6 for find all teacher whose exp>=5 and salary>=50000\n7 for find all student whose teacher are from pune,mumbai and teacher name end with a");
            int ch = sc.nextInt();
            switch (ch){
                case 0:
                    flag=false;
                    break;
                case 1:
                    menuFuntionality.retrive();
                    break;
                case 2:
                    menuFuntionality.update();
                    break;
                case 3:
                    menuFuntionality.delete();
                    break;
                case 4:

                    break;
                case 5:
                    menuFuntionality.studentQ();
                    break;
                case 6:
                    menuFuntionality.teachQ();
                    break;
                case 7:
                    menuFuntionality.Quer();
                    break;
                default:
                    System.out.println("PLEASE SELECT FROM ABOVE OPTIONS");
                    break;
            }
        }
    }
}
