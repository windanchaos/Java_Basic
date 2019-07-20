package thead;
/*
多个用户同时操作一个银行账户。每次取款100元，取款前先检查余额是否足够。如果不够，放弃取款
银行账户
 */
public class BankAccount {
    Integer allMoney;
    BankAccount(Integer allMoney){
        this.allMoney=allMoney;
    }
    public Integer getAllMoney(){
        return this.allMoney;
    }
    public synchronized boolean withdrawal(Integer money){
        this.allMoney=this.allMoney-money;
        return this.allMoney>0?true:false;
    }
}
