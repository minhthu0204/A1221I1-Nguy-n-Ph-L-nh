package com.codegym;

import java.util.Scanner;

public class baiTap2_UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số cần đọc: ");
        int number = scanner.nextInt();
        String characters="";
        if(0<=number&&number<10){
            switch (number){
                case 0 :
                    characters += "zero";
                    break;
                case  1:
                    characters += "one";
                    break;
                case  2:
                    characters += "two";
                    break;
                case  3:
                    characters += "three";
                    break;
                case  4:
                    characters += "four";
                    break;
                case  5:
                    characters += "five";
                    break;
                case  6:
                    characters += "six";
                    break;
                case  7:
                    characters += "seven";
                    break;
                case  8:
                    characters += "eight";
                    break;
                case  9:
                    characters += "nine";
                    break;

            }

        }
        else if (10<=number&&number<20){
            switch (number%10){
                case 0 :
                    characters += "ten";
                    break;
                case 1:
                    characters += "eleven";
                    break;
                case  2:
                    characters += "twelve";
                    break;
                case  3:
                    characters += "thirteen";
                    break;
                case  4:
                    characters += "fourteen";
                    break;
                case  5:
                    characters += "fifteen";
                    break;
                case  6:
                    characters += "sixteen";
                    break;
                case  7:
                    characters += "seventeen";
                    break;
                case  8:
                    characters += "eighteen";
                    break;
                case  9:
                    characters += "nineteen";
                    break;

            }
        }
        else if (20<=number&&number<100){
            int tens = number/10  ;
            int ones = number%10;
            switch (tens){
                case  2:
                    characters += "twenty";
                    break;
                case  3:
                    characters += "thirteen";
                    break;
                case  4:
                    characters += "fourteen";
                    break;
                case  5:
                    characters += "fifteen";
                    break;
                case  6:
                    characters += "sixteen";
                    break;
                case  7:
                    characters += "seventeen";
                    break;
                case  8:
                    characters += "eighteen";
                    break;
                case  9:
                    characters += "nineteen";
                    break;
            }
            switch (ones){
                case  1:
                    characters += " one";
                    break;
                case  2:
                    characters += " two";
                    break;
                case  3:
                    characters += " three";
                    break;
                case  4:
                    characters += " four";
                    break;
                case  5:
                    characters += " five";
                    break;
                case  6:
                    characters += " six";
                    break;
                case  7:
                    characters += " seven";
                    break;
                case  8:
                    characters += " eight";
                    break;
                case  9:
                    characters += " nine";
                    break;
            }

        }
        else if (101<=number&&number<1000){
            int hundreds = number/100;
            int balance = number%100;
            switch (hundreds){
                case  1:
                    characters += " one hundred and ";
                    break;
                case  2:
                    characters += " two hundred and ";
                    break;
                case  3:
                    characters += " three hundred and ";
                    break;
                case  4:
                    characters += " four hundred and ";
                    break;
                case  5:
                    characters += " five hundred and ";
                    break;
                case  6:
                    characters += " six hundred and ";
                    break;
                case  7:
                    characters += " seven hundred and ";
                    break;
                case  8:
                    characters += " eight hundred and ";
                    break;
                case  9:
                    characters += " nine hundred and ";
                    break;
            }
            if(0<=balance&&balance<10){
                switch (balance){
                    case 0 :
                        characters += "zero";
                        break;
                    case  1:
                        characters += "one";
                        break;
                    case  2:
                        characters += "two";
                        break;
                    case  3:
                        characters += "three";
                        break;
                    case  4:
                        characters += "four";
                        break;
                    case  5:
                        characters += "five";
                        break;
                    case  6:
                        characters += "six";
                        break;
                    case  7:
                        characters += "seven";
                        break;
                    case  8:
                        characters += "eight";
                        break;
                    case  9:
                        characters += "nine";
                        break;

                }

            }
            else if (10<=balance&&balance<20){
                switch (balance%10){
                    case 0 :
                        characters += "ten";
                        break;
                    case 1:
                        characters += "eleven";
                        break;
                    case  2:
                        characters += "twelve";
                        break;
                    case  3:
                        characters += "thirteen";
                        break;
                    case  4:
                        characters += "fourteen";
                        break;
                    case  5:
                        characters += "fifteen";
                        break;
                    case  6:
                        characters += "sixteen";
                        break;
                    case  7:
                        characters += "seventeen";
                        break;
                    case  8:
                        characters += "eighteen";
                        break;
                    case  9:
                        characters += "nineteen";
                        break;

                }
            }
            else if (20<=balance&&balance<100){
                int tens = balance/10;
                int ones = balance%10;
                switch (tens){
                    case  2:
                        characters += "twenty";
                        break;
                    case  3:
                        characters += "thirteen";
                        break;
                    case  4:
                        characters += "fourteen";
                        break;
                    case  5:
                        characters += "fifteen";
                        break;
                    case  6:
                        characters += "sixteen";
                        break;
                    case  7:
                        characters += "seventeen";
                        break;
                    case  8:
                        characters += "eighteen";
                        break;
                    case  9:
                        characters += "nineteen";
                        break;
                }
                switch (ones){
                    case  1:
                        characters += " one";
                        break;
                    case  2:
                        characters += " two";
                        break;
                    case  3:
                        characters += " three";
                        break;
                    case  4:
                        characters += " four";
                        break;
                    case  5:
                        characters += " five";
                        break;
                    case  6:
                        characters += " six";
                        break;
                    case  7:
                        characters += " seven";
                        break;
                    case  8:
                        characters += " eight";
                        break;
                    case  9:
                        characters += " nine";
                        break;
                }

            }


        }
        else {
            System.out.println(" out of ability");
        }
        System.out.println(characters);
    }
}
