import java.util.*;

class lab4{

    static Scanner s = new Scanner(System.in);
    static int accno;
    static String Name;
    static int balance;

    static void customer() {
        System.out.println("Enter Name: ");
        Name = s.nextLine();
        System.out.println("Enter Account Number: ");
        accno = s.nextInt();
        System.out.println("Enter Exesting balance: ");
        balance = s.nextInt();

    }

    static int deposit(int amount) {
        int new_balance;

        if (amount > 0) {
            new_balance = balance + amount;
            return new_balance;
        } else {
            return balance;
        }
    }

    static int withdraw(int amount) {
        int new_balance;
        if (balance < amount) {
            return 0;
        } else {
            new_balance = balance - amount;
            return new_balance;
        }
    }

    static void transactions(int save[]) {

        for (int i = 0; i < save.length-1; i++) {
            if (save[i] > save[i + 1]) {
                System.out.println("Money Withdrawn -" + (save[i] - save[i + 1])+"\t balance: "+save[i+1]);
            } else if (save[i] < save[i + 1]) {
                System.out.println("Money Deposited +" + (save[i + 1] - save[i])+"\t balance: "+save[i+1]);
            } else {
                System.out.println("\n");
            }
        }

    }

    static void summary() {
        System.out.print("\n Name:\t" + Name);
        System.out.print("\n Account Number:\t" + accno);
        System.out.print("\n Balnce:\t" + balance);

    }

    public static void main(String[] args){
        int[] save = new int[1];
        int[] newArr = new int[save.length + 1];
        int ch=1;

        System.out.println("Enter Customer Details");
        customer();
        save[0]=balance;



        do{
            System.out.println("Choose: \n0.Exit \n1. Deposit Money \n2. Withdraw Money \n3. Print Transactions \n4. Print Customer Details");
            ch= s.nextInt();
        switch(ch){
            case 0:
            System.out.println("Exiting....");
            case 1:
            System.out.println("Enter the amount to deposit \t");
            newArr = new int[save.length + 1];
            System.arraycopy(save, 0, newArr, 0, save.length);
            newArr[newArr.length - 1] = deposit(s.nextInt());
            save = newArr;
            break;

            case 2:
            System.out.println("Enter the amount to withdraw \t");
            newArr = new int[save.length + 1];
            System.arraycopy(save, 0, newArr, 0, save.length);
            newArr[newArr.length - 1] = deposit(s.nextInt());
            save = newArr;
            break;


            case 3:
            System.out.println("Transactions for Account:\t"+accno);
            transactions(save);
            break;

            case 4:
            System.out.println("Details of Customer:\t");
            summary();
            break;

            default:
            System.out.println("Wrong Details");
            break;

        }
    }while(ch!=0);

    
    }
}