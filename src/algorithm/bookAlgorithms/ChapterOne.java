package algorithm.bookAlgorithms;
/*
算法第四版练习，作者Robert Sedgewick、Kevi Wayne
 */
public class ChapterOne {
    public static void main(String[] args) {
        System.out.println(mystery(2,25));
        System.out.println(mystery(3,11));
        System.out.println("最大公约数"+gcd(24,105));
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                System.out.println(i+" "+j+":"+binomial(i,j,0.25)+" "+betterBinomial(i,j,0.25));
            }
        }
//        System.out.println("binomial:"+binomial(3,1,0.25)+"\nbinomialCallNumber:"+binomialCallNumber);
//        System.out.println("binomial:"+binomial(1,1,0.25));
//        System.out.println("binomial:"+binomial(2,1,0.25));
//        System.out.println("binomial:"+binomial(3,1,0.25));
//        System.out.println("binomial:"+binomial(3,2,0.25));
//        System.out.println("betterBinomial:"+betterBinomial(3,1,0.25));
    }


    //习题1.1.18
    public static int mystery(int a, int b){
        if(b==0) return 0;
        if(b%2==0){
            return mystery(a+a,b/2);}
        return mystery(a+a,b/2)+a;
    }
    //习题1.1.24 欧几里得公约数算法
    //归纳法证明任意数都能取得公约数，即始终会达到b==0的状态。
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    //习题1.1.27
    static int binomialCallNumber=0;
    public static double binomial(int N,int K,double P){
        binomialCallNumber=binomialCallNumber+1;
        if(N==0 && K==0) return 1.0;
        if(N<0 || K<0) return 0.0;
        return (1.0-P)*binomial(N-1,K,P)+P*binomial(N-1,K-1,P);
    }
    /*
    没有做出来更好的
     */
    public static double betterBinomial(int N,int K,double P){
        double[][] tmp=new double[N+1][K+1];
        tmp[0][0]=1.0;
        tmp[0][1]=0.0;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                tmp[i][j]=(1-P)*tmp[i-1][j]+P*tmp[i-1][j-1];
                //System.out.println(i+" "+j+": "+tmp[i][j]);
            }
        }
        return tmp[N][K];
    }
}
