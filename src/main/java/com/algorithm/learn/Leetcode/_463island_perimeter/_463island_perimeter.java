package com.algorithm.learn.Leetcode._463island_perimeter;

/**
 * Created by Administrator on 2020/1/12.
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

 示例 :

 输入:
 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
 输出: 16

 解释: 它的周长是下面图片中的 16 个黄色的边：

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/island-perimeter
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _463island_perimeter {
    /**
     * 思路：只要求出来上面和左侧的，然后乘以2即可
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int sum=0;
        int top=0,left=0;//top：上面；left左侧
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    //左侧
                    //如果grid[i][j]==1在最左面，当然有一个左边
                    //如果grid[i][j-1]==0，则左侧是水，当然有一个边
                    if(j==0 || grid[i][j-1]==0 ){
                        left++;
                    }
                    //顶侧
                    //如果grid[i][j]==1在最顶面，当然有一个左边
                    //如果grid[i-1][j]==0，则顶侧是水，当然有一个边
                    if(i==0 || grid[i-1][j]==0 ){
                        top++;
                    }
                    /**
                     * 注意：i==0 || grid[i-1][j]==0 两个判断顺序不能错，否则会报错；
                     * i=0时，i-1=-1，是超出数组范围的，而当i==0如果成立，则||是不执行右侧代码的
                     */
                }

            }
        }
        sum=left+top;
        return sum*2;
    }
}
