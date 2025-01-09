package exercise.Module2;

import java.util.*;
import java.util.stream.Collectors;

public class AccountManager {
    private List<Account> accounts;
    private List<Employee> employees;
    private List<Transaction> transactions;
    private Scanner sc = new Scanner(System.in);

    public AccountManager() {
        accounts = new ArrayList<>();
        employees = new ArrayList<>();
        transactions = new ArrayList<>();
    }


    //    Hiển thị lịch sử giao dịch của một tài khoản
    public void showTransactionHistory() {
        System.out.print("Nhập số tài khoản cần xem lịch sử giao dịch: ");
        String accountNumber = sc.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account != null) {
            System.out.println("Lịch sử giao dịch của tài khoản " + accountNumber + ":");
            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        }
        System.out.println("Tài khoản không tồn tại.");

    }

    //    Hiển thị toàn bộ giao dịch trong hệ thống
    public void showAllTransactions() {
        if (transactions != null) {
            this.transactions.forEach(Transaction::showInfo);
        }
        System.out.println("Không có giao dịch nào");
    }

    //    Nạp tiền vào tài khoản
    public void deposit() {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = sc.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account != null) {
            System.out.print("Nhập số tiền nạp: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            account.deposit(amount);
            System.out.println("Nạp tiền thành công.");
        }
        System.out.println("Tài khoản không tồn tại.");

    }

    //    Rút tiền từ tài khoản
    public void withdraw() {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = sc.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account != null) {
            System.out.print("Nhập số tiền rút: ");
            double amount = sc.nextDouble();
            sc.nextLine(); // consume newline
            try {
                account.withdraw(amount);
                System.out.println("Rút tiền thành công.");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        System.out.println("Tài khoản không tồn tại.");

    }

    //    Chuyển khoản giữa hai tài khoản
    public void transfer() {
        System.out.print("Nhập số tài khoản nguồn: ");
        String sourceAccountNumber = sc.nextLine();
        Account sourceAccount = findAccountByNumber(sourceAccountNumber);

        System.out.print("Nhập số tài khoản đích: ");
        String destinationAccountNumber = sc.nextLine();
        Account destinationAccount = findAccountByNumber(destinationAccountNumber);

        if (sourceAccount != null && destinationAccount != null) {
            System.out.print("Nhập số tiền chuyển: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            try {
                sourceAccount.withdraw(amount);
                destinationAccount.deposit(amount);
                System.out.println("Chuyển khoản thành công.");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        System.out.println("Một trong các tài khoản không tồn tại.");
    }

    // Thêm nhân viên vào hệ thống
    public void addEmployee() {
        System.out.println("Nhập thông tin nhân viên mới: ");
        System.out.println("Nhập mã nhân viên: ");
        String id = sc.nextLine();
        Set<String> setId = this.employees.stream().map(Employee::getId).collect(Collectors.toSet());
        if (setId.contains(id)) {
            throw new CustomException("Mã nhân viên đã tồn tại");
        }
        Employee employee = new Employee();
        employee.setId(id);
        employee.enterInfo();
        this.employees.add(employee);
        System.out.println("Thêm nhân viên vào hệ thống thành công!");

    }

    public void showEmployee() {
        if (employees != null) {
            this.employees.forEach(Employee::showInfo);
        }
        System.out.println("Không có nhân viên nào");
    }

    //    Gán tài khoản cho nhân viên
    public void assignAccount() {
        System.out.println("Nhập ID nhân viên: ");
        String id = sc.nextLine();
        Employee employee = findEmployeeById(id);

        if (employee == null) {
            System.out.println("Nhân viên không tồn tại.");
            return;
        }

        System.out.println("Nhập số tài khoản: ");
        String accountNumber = sc.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("Tài khoản không tồn tại.");
            return;
        }

        if (account.getEmployeeInCharge() != null) {
            System.out.println("Tài khoản đã được gán cho nhân viên khác.");
            return;
        }

        employee.addAccount(account);
        account.setEmployeeInCharge(employee);

        System.out.println("Tài khoản " + accountNumber + " đã được gán cho nhân viên " + id);
    }

    // Thêm tài khoản mới vào hệ thống
    public void addAccount() {
        System.out.println("Nhập thông tin tài khoản mới: ");
        System.out.println("Nhập vào số tài khoản: ");
        String accountNumber = sc.nextLine();
        // kiem tra su ton tai
        Set<String> setAccountNumber = this.accounts.stream().map(Account::getAccountNumber).collect(Collectors.toSet());
        if (setAccountNumber.contains(accountNumber)) {
            throw new CustomException("Số tài khoản đã tồn tại");
        }
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.enterInfo();
        System.out.print("Nhập ID nhân viên phụ trách: ");
        String employeeId = sc.nextLine();
        Employee employee = findEmployeeById(employeeId);
        this.accounts.add(account);
        if (employee != null) {
            this.accounts.add(account);
            employee.addAccount(account);
            account.setEmployeeInCharge(employee);
            System.out.println("Tài khoản đã được thêm thành công.");
            System.out.println("----------------------------------");
            System.out.println("Số tài khoản: " + account.getAccountNumber());
            System.out.println("Tên chủ tài khoản: " + account.getAccountHolder());
            System.out.println("Số dư ban đầu: " + account.getBalance());
            System.out.println("Nhân viên phụ trách: " + employee.getName());
        }
        System.out.println("Nhân viên không tồn tại.");

    }

    // Sửa thông tin tài khoản
    public void updateAccount() {
        System.out.println("Nhập số tài khoản cần cập nhật: ");
        String accountNumber = sc.nextLine();

        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Lỗi: Tài khoản không tồn tại!");
        }

        System.out.println("Nhập tên chủ tài khoản mới: ");
        String newAccountHolder = sc.nextLine();
        account.setAccountHolder(newAccountHolder);
        System.out.println("Cập nhật tài khoản thành công!");
    }

    // Kiểm tra tài khoản có tồn tại không
    private Account findAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public Employee findEmployeeById(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    // Xóa tài khoản
    public void deleteAccount() {
        System.out.println("Nhap vao số tài khoản cần xoa");
        String accountNumber = sc.nextLine();

        Account accountRemove = this.accounts.stream()
                .filter(account -> account != null && accountNumber.equalsIgnoreCase(account.getAccountNumber()))
                .findFirst()
                .orElseThrow(() -> new CustomException("Số tài khoản không tồn tại"));
        if (accountRemove.getBalance() < 0) {
            accounts.remove(accountRemove);
            System.out.println("Xoa số tài khoản thanh cong");
        }
        System.out.println("Lỗi: Không thể xóa tài khoản" + accountNumber + " vì tài khoản còn số dư " + accountRemove.getBalance());
    }

    // Tìm kiếm tài khoản
    public void searchAccount() {
        System.out.print("Nhập số tài khoản hoặc tên chủ tài khoản để tìm: ");
        String searchTerm = sc.nextLine().trim();

        Account accountByNumber = findAccountByNumber(searchTerm);
        if (accountByNumber != null) {
            System.out.println("Tìm thấy tài khoản: " + accountByNumber.getAccountNumber() + ", Chủ tài khoản: " + accountByNumber.getAccountHolder());
        }

        for (Account account : accounts) {
            if (account.getAccountHolder().equalsIgnoreCase(searchTerm)) {
                System.out.println("Tìm thấy tài khoản: " + account.getAccountNumber() + ", Chủ tài khoản: " + account.getAccountHolder());
            }
        }

        System.out.println("Lỗi: Không tìm thấy tài khoản nào!");
    }

}
