import dao.AccountImpl;
import models.Account;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        AccountImpl acimpl = new AccountImpl();
        int choose;
        do {
            System.out.println("---------MENU--------");
            System.out.println("1. Hiển thị toàn bộ tài khoản sắp xếp tăng theo balance.");
            System.out.println("2. Hiển thị tài khoản theo id.");
            System.out.println("3. Thêm mới tài khoản.");
            System.out.println("4. Cập nhật tài khoản.");
            System.out.println("5. Tìm kiếm tài khoản theo số dư.");
            System.out.println("6. Thoát.");
            System.out.print("Chọn: ");
            choose = sc.nextInt();
            switch (choose) {
                // Sắp xếp danh sách accountList theo ID giảm dần
                // Collections.sort(accountList, Comparator.comparing(Account::getAccountId).reversed());
                case 1:
                    List<Account> accountList = new ArrayList<>();
                    break;
            }
        } while (choose != 6);
    }

    public static void main(String[] args) throws ParseException {

    }
}
