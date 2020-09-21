public class Main {

    public static void main(String[] args) {
        int N = (int)Math.round(Math.random()*9)+1;
        System.out.println(N);
        int [] p = new int[N];
        int [][] recipe= new int[N-1][4];
        for(int i=0;i<N;i++)
            p[i]=i;
        for(int i=0;i<N-1;i++) {
            int A, B;
            A = (int) Math.round(Math.random() * (N - 1));
            B = (int) Math.round(Math.random() * (N - 1));
            while (p[A] == p[B]) {
                A = (int) Math.round(Math.random() * (N - 1));
                B = (int) Math.round(Math.random() * (N - 1));
            }
            int min = Math.min(p[A], p[B]);
            int max = Math.max(p[A], p[B]);
            for (int j = 0; j < N; j++) {
                if (p[j] == max)
                    p[j] = min;
            }
            recipe[i][0]=A;
            recipe[i][1]=B;
            recipe[i][2]=(int)Math.round(Math.random()*8)+1;
            recipe[i][3]=(int)Math.round(Math.random()*8)+1;
        }
        for(int i=0;i<N-1;i++){
            System.out.println(recipe[i][0]+" "+recipe[i][1]+" "+recipe[i][2]+" "+recipe[i][3]);
        }
    }
}
