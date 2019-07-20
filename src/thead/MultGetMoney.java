package thead;
/*
多个用户同时操作一个银行账户。每次取款100元，取款前先检查余额是否足够。如果不够， 放弃取款
 */
public class MultGetMoney {
    public static void main(String[] args) {
        BankAccount bankAccount=new BankAccount(2239902);
        //4个线程同时取款，会造成超取的情况
        MoneyAccout moneyAccout1=new MoneyAccout(bankAccount);
        MoneyAccout moneyAccout2=new MoneyAccout(bankAccount);
        MoneyAccout moneyAccout3=new MoneyAccout(bankAccount);
        MoneyAccout moneyAccout4=new MoneyAccout(bankAccount);
        Thread thread1=new Thread(moneyAccout1);
        Thread thread2=new Thread(moneyAccout2);
        Thread thread3=new Thread(moneyAccout3);
        Thread thread4=new Thread(moneyAccout4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("线程1取了"+moneyAccout1.getHavingMoney());
        System.out.println("线程2取了"+moneyAccout2.getHavingMoney());
        System.out.println("线程3取了"+moneyAccout3.getHavingMoney());
        System.out.println("线程4取了"+moneyAccout4.getHavingMoney());
        System.out.println("总共取了"+(moneyAccout1.getHavingMoney()+moneyAccout2.getHavingMoney()+moneyAccout3.getHavingMoney()+moneyAccout4.getHavingMoney()));
    }
}
