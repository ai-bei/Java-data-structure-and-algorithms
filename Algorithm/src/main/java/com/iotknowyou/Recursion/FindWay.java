package com.iotknowyou.Recursion;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  使用递归回溯算法，求路线规划的问题
 * @updateRemark
 * @createDate 2020/4/20 11:54
 * @updateDate 2020/4/20 11:54
 **/
public class FindWay {

    // 地图数据
    private static  int[][] map ;
    private static  int mapRow ;
    private static  int mapColumn ;


    /**
     *  初始化地图
     * @param row
     * @param column
     * @return
     */
    public static int[][] initMap(int row , int column){
        // 先创建一个二维数组
        // 模拟地图
         map = new int[row][column];
         mapRow = row ;
         mapColumn = column ;
        // 使用1 表示墙
        // 上下全部置为1
        for (int i = 0; i < column  ; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }
        // 左右全部置为1
        for (int i = 0; i < row  ; i++) {
            map[i][0] = 1;
            map[i][column - 1] = 1;
        }
        //设置挡板, 1 表示
        setBlock(3,1,1);
        setBlock(3,2,1);
        return map;
    }

    /**
     * 打印地图
     */
    public static void printMap(){
        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < mapRow; i++) {
            for (int j = 0; j < mapColumn ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param row
     * @param column
     * @param mark     当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
     */
    public static void setBlock(int row , int column ,int mark){
        if(row > mapRow ){
            throw new RuntimeException("输入的row = "+row +", 大于最大值"+mapRow);
        }
        if(column > mapColumn){
            throw new RuntimeException("输入的column = "+ column +", 大于最大值"+mapColumn);
        }
        map[row][column] = mark;
    }


    /**
     *
     * @param startRow      起点
     * @param startColumn   起点
     * @param endRow        终点
     * @param endColumn     终点
     * @return  策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
     *                    选择的策略不同，最终的结果也会不同
     */
    public static boolean setWay( int startRow, int startColumn , int endRow, int endColumn ) {
        // TODO 对输入的参数进行校验
        if(map[endRow][endColumn] == 2) { // 通路已经找到ok
            return true;
        } else {
            if(map[startRow][startColumn] == 0) { //如果当前这个点还没有走过
                //按照策略 下->右->上->左  走
                setBlock(startRow,startColumn,2); // 假定该点是可以走通.
                if(setWay(startRow + 1, startColumn ,endRow , endColumn)) {//向下走
                    return true;
                } else if (setWay(startRow, startColumn + 1 ,endRow , endColumn)) { //向右走
                    return true;
                } else if (setWay(startRow - 1, startColumn ,endRow , endColumn)) { //向上
                    return true;
                } else if (setWay(startRow, startColumn - 1 ,endRow , endColumn)){ // 向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    setBlock(startRow,startColumn,3);
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }


    public static void main(String[] args) {
        initMap(8,7);
        printMap();
        setWay(3,5,6,5);
        printMap();

    }
}
