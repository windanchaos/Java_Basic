package thead;

/*
多个用户同时操作一个银行账户。每次取款100元，取款前先检查余额是否足够。如果不够，放弃取款
取款账户
 */
public class MoneyAccout implements Runnable {
    BankAccount bankAccount;
    Integer havingMoney = 0;
    int withdrawn;

    MoneyAccout(BankAccount bankAccount,int withdrawn) {
        this.bankAccount = bankAccount;
        this.withdrawn=withdrawn;
    }

    @Override
    public void run() {
        while (bankAccount.getAllMoney() > withdrawn) {
            bankAccount.withdrawal(withdrawn);
            this.havingMoney = this.havingMoney + withdrawn;
            System.out.println(Thread.currentThread().getName() + "取走:"+withdrawn);
        }
        System.out.println("余额不足:" + bankAccount.getAllMoney());
    }

    protected Integer getHavingMoney() {
        return this.havingMoney;
    }
}
