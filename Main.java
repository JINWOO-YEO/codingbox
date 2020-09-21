package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        if (N == 1) System.out.println(1);
        else {
            int[][] rate = new int[(int)N-1][4];
            for (int i = 0; i < N - 1; i++) {
                String[] a = sc.nextLine().split(" ");
                for (int j = 0; j < 4; j++)
                    rate[i][j] = Integer.parseInt(a[j]);
                if (gcd(rate[i][2], rate[i][3]) != 1) {
                    long t = gcd(rate[i][2], rate[i][3]);
                    rate[i][2] /= t;
                    rate[i][3] /= t;
                }
            }
            long[] head = new long[N];
            for (int i = 0; i < N; i++) {
                head[i] = i;
            }
            long[] m = new long[N];
            for (int i = 0; i < N - 1; i++) {
                if (m[rate[i][0]] == 0 && m[rate[i][1]] == 0) {
                    m[rate[i][0]] = rate[i][2];
                    m[rate[i][1]] = rate[i][3];
                    long mi = Math.min(rate[i][0], rate[i][1]);
                    head[rate[i][0]] = mi;
                    head[rate[i][1]] = mi;
                } else if (m[rate[i][0]] == 0) {
                    long lcm = m[rate[i][1]] * rate[i][3] / gcd(m[rate[i][1]], rate[i][3]) / m[rate[i][1]];
                    long mi = Math.min(head[rate[i][1]], head[rate[i][0]]);
                    long t = head[rate[i][1]];
                    for (int j = 0; j < N; j++) {
                        if (head[j] == t) {
                            m[j] *= lcm;
                            head[j] = mi;
                        }
                    }
                    head[rate[i][0]] = mi;
                    m[rate[i][0]] = m[rate[i][1]] * rate[i][2] / rate[i][3];
                } else if (m[rate[i][1]] == 0) {
                    long lcm = m[rate[i][0]] * rate[i][2] / gcd(m[rate[i][0]], rate[i][2]) / m[rate[i][0]];
                    long mi = Math.min(head[rate[i][1]], head[rate[i][0]]);
                    long t = head[rate[i][0]];
                    for (int j = 0; j < N; j++) {
                        if (head[j] == t) {
                            m[j] *= lcm;
                            head[j] = mi;
                        }
                    }
                    head[rate[i][1]] = mi;
                    m[rate[i][1]] = m[rate[i][0]] * rate[i][3] / rate[i][2];
                } else {
                    long lcm = m[rate[i][0]] * m[rate[i][1]] / gcd(m[rate[i][0]], m[rate[i][1]]);
                    long a = lcm / m[rate[i][0]] * rate[i][2];
                    long b = lcm / m[rate[i][1]] * rate[i][3];
                    long mi = Math.min(head[rate[i][1]], head[rate[i][0]]);
                    long t1 = head[rate[i][0]];
                    long t2 = head[rate[i][1]];
                    for (int j = 0; j < N; j++) {
                        if (head[j] == t1) {
                            m[j] *= a;
                        }
                        if (head[j] == t2) {
                            m[j] *= b;
                            head[j] = mi;
                        }
                        if (head[j] == t1) {
                            head[j] = mi;
                        }
                    }
                }
            }
            long gcdnum = m[0];
            for (int i = 1; i < N; i++) {
                gcdnum = gcd(m[i], gcdnum);
            }
            if (gcdnum != 0) {
                for (int i = 0; i < N; i++) {
                    m[i] /= gcdnum;
                }
            }
            for (long a : m)
                System.out.print(a + " ");
        }
    }
    static long gcd(long a, long b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    static int findhead(int i, int []n){
        if(i==n[i])return i;
        else return findhead(n[i],n);
    }
}
