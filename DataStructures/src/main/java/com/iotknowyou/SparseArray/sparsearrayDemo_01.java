package com.iotknowyou.SparseArray;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *  稀疏数组的使用案例，Demo
 */
public class sparsearrayDemo_01 {

    // 原始数组的 行、列、值个数
    public static Integer ROW = 11;
    public static Integer COLUMN = 11;
    public static Integer SUM = 0 ;



    /*  通过字符流的形式，将数据存储到文件中*/
    /**
     * 将稀疏数组存入磁盘（文件）
     *
     */
    public static void sparseArrayToIo(int[][] sparseArray) throws Exception {
        File file = new File("sparseArray.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        for(int i =0; i < sparseArray.length; i++) {
            for(int j = 0; j < 3; j++) {
                writer.write(sparseArray[i][j]);
            }
        }
        writer.flush();
        writer.close();
    }

    /**
     * 读文件获取稀疏数组(获取指定行数的稀疏数组)
     * @return
     */
    public static int[][] sparseArrayFromIo(int lineNums) throws Exception {

        FileReader reader = new FileReader("sparseArray.txt");
        int getNum = 0;
        int[][] sparseArray = new int[lineNums][3];
        for(int i = 0;i < lineNums;i++) {
            for (int j = 0; j < 3; j++) {
                getNum = reader.read();
                sparseArray[i][j] = getNum;
            }
        }
        return sparseArray;
    }




    public static void main(String[] args) throws Exception {
        //创建棋盘数组
        // 0 : 没有棋子  1：黑子  2：白子
        int chessArr_01[][] = new int[ROW][COLUMN];
        // Integer[][] 数组默认值为 null
        chessArr_01[1][2] = 1;
        chessArr_01[2][3] = 2;
        chessArr_01[2][4] = 1;
        chessArr_01[4][3] = 2;
        chessArr_01[6][3] = 2;
        chessArr_01[7][6] = 2;
        chessArr_01[8][7] = 2;
        chessArr_01[9][9] = 2;
        // 输出原始的棋盘数组
        System.out.println("原始的棋盘数组：");
        for (int[] ints : chessArr_01) {
            for (int data : ints) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        // 将二维数组  转变成 稀疏数组

        // 1、遍历二维数组，获取非零的数据个数
        int sum = 0;
        for (int i = 0; i < chessArr_01.length; i++) {
            for (int j = 0; j < chessArr_01[i].length; j++) {
                if(chessArr_01[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("遍历的结果："+sum);

        // 将不同值的个数赋值给SUM，方便后期存储到数据库中
        SUM = sum ;

        // 2、 创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //2、遍历原始的二维数组，将非零数存储在 稀疏数组中
        int count = 0; // 定义一个计数器
        for (int i = 0; i < chessArr_01.length; i++) {
            for (int j = 0; j < chessArr_01[i].length; j++) {
                if(chessArr_01[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr_01[i][j];
                }
            }
        }


        // 输出稀疏数组
        System.out.println("稀疏数组：");
        for (int[] ints : sparseArr) {
            for (int data : ints) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 将稀疏数组存入文件中
        sparseArrayToIo(sparseArr);



        // 从磁盘中读取稀疏数组，并且还原
        int[][] sparseArrFromIo = sparseArrayFromIo(SUM + 1);

        // 将稀疏数组还原成 原始的二维数组

        // 1、读取稀疏数组中的第一行，根据第一行的数据还原二维数组
        int chessArr_02[][] = new int[sparseArrFromIo[0][0]][sparseArrFromIo[0][1]];
        // 2、遍历稀疏数组，将稀疏数组中的数据赋值给二维数组
        for (int i = 1; i < sparseArrFromIo.length; i++) {
            chessArr_02[sparseArrFromIo[i][0]][sparseArrFromIo[i][1]] = sparseArrFromIo[i][2];
        }


        // 输出还原的二维数组
        System.out.println("还原的二维数组：");
        for (int[] ints : chessArr_02) {
            for (int data : ints) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
