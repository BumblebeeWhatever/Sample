package com.android.sample.module.java.Algorithm;

/**
 * Created by hexiaolei on 2017/7/20.
 * 输出nXn的矩阵，如
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */

public class GenerateMatrix {

    public static void main(String[] args) {
        int n = 7;
        int[][] array = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                System.out.println(array[i][j]);
            }
        }
    }

    /**
     * 弱爆了，要总结规律呀
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        if (n == 0) {
            return array;
        } else if (n == 1) {
            array[0][0] = 1;
            return array;
        }
        int direction = 0;//指向,0为横向右，1为纵向下，2为横向左，3为纵向上
        int startX = -1;//每一次转向的起点X
        int startY = 0;//每一次转向的起点Y
        int layer = -1;//从外数第几层
        for (int i = 0; i < n * n; ) {
            switch (direction) {
                case 0:
                    ++startX;
                    ++layer;
                    for (; startX < n - layer; ) {
                        System.out.println("0,x:" + startX + ",y:" + startY + ",layer:" + layer + ",i" + i);
                        if (array[startX][startY] == 0) {
                            array[startX][startY] = ++i;
                            if (startX == n - layer - 1) {
                                break;
                            }
                            ++startX;
                        } else {
                            ++i;
                            break;
                        }
                    }

                    if (array[startX][startY + 1] != 0) {
                        return reverse(array);
                    }
                    direction = 1;
                    break;
                case 1:
                    ++startY;
                    for (; startY < n - layer; ) {
                        System.out.println("1,x:" + startX + ",y:" + startY + ",layer:" + layer + ",i" + i);
                        if (array[startX][startY] == 0) {
                            array[startX][startY] = ++i;
                            if (startY == n - layer - 1) {
                                break;
                            }
                            startY++;
                        } else {
                            ++i;
                            break;
                        }
                    }
                    direction = 2;
                    break;
                case 2:
                    --startX;
                    for (; startX >= layer; ) {
                        System.out.println("2,x:" + startX + ",y:" + startY + ",layer:" + layer + ",i" + i);
                        if (array[startX][startY] == 0) {
                            array[startX][startY] = ++i;
                            if (startX == layer) {
                                break;
                            }
                            startX--;
                        } else {
                            ++i;
                            break;
                        }
                    }
                    direction = 3;
                    break;
                case 3:
                    --startY;
                    for (; startY > layer; ) {
                        System.out.println("3,x:" + startX + ",y:" + startY + ",layer:" + layer + ",i" + i);
                        if (array[startX][startY] == 0) {
                            array[startX][startY] = ++i;
                            if (startY == layer) {
                                break;
                            }
                            if (startY == layer + 1) {
                                break;
                            } else {
                                --startY;
                            }
                        } else {
                            ++i;
                            break;
                        }
                    }

                    if (array[startX + 1][startY] != 0) {
                        return reverse(array);
                    }

                    direction = 0;
                    break;
            }
        }
        return reverse(array);
    }

    private static int[][] reverse(int[][] origin) {
        int length = origin[0].length;
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                array[i][j] = origin[j][i];
            }
        }
        return array;
    }

}
