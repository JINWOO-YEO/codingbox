import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] list = new int[n];
        int [] dp = new int[10001];
        Arrays.fill(dp,10000);
        for(int i=0;i<n;i++) {
            list[i] = sc.nextInt();
            if(list[i]<=10000)dp[list[i]]=1;
        }
        Arrays.sort(list);
        for(int i=1;i<=k;i++){
            if(dp[i]==1)continue;
            else{
                for(int j=0;j<n;j++){
                    if(i-list[j]<0)break;
                    else{
                        if(dp[i-list[j]]!=10000){
                            dp[i]=Math.min(dp[i-list[j]]+1,dp[i]);
                        }
                    }
                }
            }
        }
        if(dp[k]==10000)System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
