package models;

import java.sql.Date;
import java.util.Scanner;

public class Account implements IAccount{
    private String accountId;
    private String customerName;
    private Date createDate;
    private String phone;
    private String address;
    private float balance;
    private int active;

    public Account() {
        super();
    }

    public Account(String accountId, String customerName, Date createDate, String phone, String address, float balance, int active) {
        super();
        this.accountId = accountId;
        this.customerName = customerName;
        this.createDate = createDate;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.active = active;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap accountId: ");
        this.accountId = sc.nextLine();
        System.out.print("Nhap customerName: ");
        this.customerName = sc.nextLine();
        System.out.print("Nhap createDate(yyyy-MM-dd): ");
        this.createDate = java.sql.Date.valueOf(sc.nextLine());
        System.out.print("Nhap phone: ");
        this.phone = sc.nextLine();
        System.out.print("Nhap address: ");
        this.address = sc.nextLine();
        System.out.print("Nhap balance: ");
        this.balance = sc.nextFloat();
        System.out.print("Nhap active: ");
        this.active = sc.nextInt();
    }

    @Override
    public void display() {
        System.out.println("accountId: "+accountId);
        System.out.println("customerName: "+customerName);
        System.out.println("createDate: "+createDate);
        System.out.println("phone: "+phone);
        System.out.println("address: "+address);
        System.out.println("balance: "+balance);
        System.out.println("active: "+active);
    }
}
