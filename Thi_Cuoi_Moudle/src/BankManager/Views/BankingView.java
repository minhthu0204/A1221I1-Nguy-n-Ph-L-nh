package BankManager.Views;

import BankManager.Exception.NotFoundBankAccountException;
import BankManager.Models.Account;
import BankManager.Models.PaymentAccount;
import BankManager.Models.SavingAccount;
import BankManager.Service.BankService;
import BankManager.Utils.Validate;

import java.util.List;
import java.util.Scanner;

public class BankingView {

    static Scanner scanner = new Scanner(System.in);

    static BankService bankService = new BankService();

    public static void displayMenu() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG--");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách các tài khoản ngân hàng");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");

            System.out.println("Chọn chức năng theo số để tiếp tục.");
            int choice = Validate.getIntFive();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    System.exit(1);
                    break;

            }
        }
    }

    private static void add() {
        System.out.println("1. Tài khoản tiết kiệm");
        System.out.println("2. Tài khoản thanh toán");
        System.out.println("Chọn chức năng theo số để tiếp tục:");
        int choice = Validate.getIntTwo();
        System.out.println("Mã tài khoản: ");
        String code = Validate.getString();
        System.out.println("Tên chủ tài khoản: ");
        String name = Validate.getString();
        System.out.println("Ngày tạo tài khoản: ");
        String openDate = Validate.getString();
        while (!Validate.isDate(openDate)) {
            System.err.println("Định dạng phải theo kiểu DD/MM/YYYY ");
            openDate = Validate.getString();
        }
        Account account;
        if (choice == 1) {
            System.out.println("Số tiền gửi tiết kiệm: ");
            double amount = Validate.getDouble();
            System.out.println("Ngày gửi tiết kiệm: ");
            String dateSaving = Validate.getString();
            while (!Validate.isDate(dateSaving)) {
                System.err.println("Định dạng phải theo kiểu DD/MM/YYYY ");
                dateSaving = Validate.getString();
            }
            System.out.println("Lãi suất: ");
            double rate = Validate.getDouble();
            System.out.println("Kỳ hạn (số tháng): ");
            int term = Validate.getInt();
            account = new SavingAccount(0, code, name, openDate, amount, dateSaving, rate, term);
        } else {
            System.out.println("Số thẻ: ");
            int cardNumber = Validate.getInt();
            System.out.println("Số tiền trong tài khoản: ");
            double cash = Validate.getDouble();

            account = new PaymentAccount(0, code, name, openDate, cardNumber, cash);
        }
        bankService.create(account);
        System.out.println("Tạo tài khoản thành công");
    }

    private static void delete() {
        display();
        boolean isExists;
        System.out.println("Nhập ID của tài khoản muốn xóa:");
        do {
            try {
                int id = Validate.getInt();
                bankService.delete(id);
                System.out.println("Xóa tài khoản thanh công ");
                isExists = false;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại:");
                isExists = true;
            }
        } while (isExists);
    }

    private static void display() {
        List<Account> accounts = bankService.findAll();
        if (accounts.size() > 0) {
            for (Account a : accounts) {
                if (a instanceof SavingAccount) {
                    System.out.printf("Tài khoản tiết kiệm: id: %s, Mã tài khoản: %s, Tên chủ tài khoản: %s, " +
                                    "Ngày tạo tài khoản: %s, Số tiền gửi tiết kiệm: %s, Ngày gửi tiết kiệm: %s," +
                                    " Lãi suất: %s, Kì hạn (Số tháng): %s \n"
                            , a.getId(), a.getCode(), a.getName(), a.getDateOpen(), ((SavingAccount) a).getAmount(),
                            ((SavingAccount) a).getDateSaving(), ((SavingAccount) a).getRate(), ((SavingAccount) a).getTerm());
                } else {
                    System.out.printf("Tài khoản thanh toán:  id: %s, Mã tài khoản: %s, Tên chủ tài khoản: %s,  " +
                                    "Ngày tạo tài khoản: %s, Số thẻ: %s, Số tiền trong ngân hàng: %s\n"
                            , a.getId(), a.getCode(), a.getName(), a.getDateOpen(), ((PaymentAccount) a).getCardNumber()
                            , ((PaymentAccount) a).getCash());
                }
            }
        } else {
            System.out.println("Product List is empty");
        }
    }

    private static void searchByName() {
        System.out.println("Enter name to search:");
        String name = scanner.nextLine();
        List<Account> accounts = bankService.searchByName(name);

        for (Account a : accounts) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        displayMenu();
    }


}
