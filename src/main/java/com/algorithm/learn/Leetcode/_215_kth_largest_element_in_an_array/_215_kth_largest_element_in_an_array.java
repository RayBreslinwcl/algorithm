package com.algorithm.learn.Leetcode._215_kth_largest_element_in_an_array;

/**
 * Created by Administrator on 2020/3/7.
 * 题目：
 * 215. 数组中的第K个最大元素
 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:
 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5

 示例 2:
 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 说明:

 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 【面试亲历20200307：解题方法参考快排】

 */
public class _215_kth_largest_element_in_an_array {
    /**
     *  【解决参考：】
     https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/java-jie-zhu-partitionfen-qu-jian-zhi-on-by-yankua/
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        int targetIndex=len-k;//可以依据包含3个元素的数组去理解
        int low=0,high=len-1;
        while(true){
            int i=partition(nums,low,high);
            if(i==targetIndex){
                return nums[i];
            }else if(i<targetIndex){
                low=i+1;
            }else{
                high=i-1;
            }
        }


    }

    /**
     * 分区函数，将 arr[high] 作为 pivot 分区点
     * i、j 两个指针，i 作为标记“已处理区间”和“未处理区间”的分界点，也即 i 左边的（low~i-1）都是“已处理区”。
     * j 指针遍历数组，当 arr[j] 小于 pivot 时，就把 arr[j] 放到“已处理区间”的尾部，也即是 arr[i] 所在位置
     * 因此 swap(arr, i, j) 然后 i 指针后移，i++
     * 直到 j 遍历到数组末尾 arr[high]，将 arr[i] 和 arr[high]（pivot点） 进行交换，返回下标 i，就是分区点的下标。
     *
     *
     作者：yankuangshigo
     链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/java-jie-zhu-partitionfen-qu-jian-zhi-on-by-yankua/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */
    private int partition(int[] array,int low,int high){
        int i=low;
        int pivot=array[high];

        for(int j=low;j<high;j++){
            if(array[j]<pivot){
                swap(array,i,j);
                i++;
            }
        }
        swap(array,i,high);
        return i;
    }

    private void swap(int[] array,int i ,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }


    public static void main(String[] args) {

        int[] arrays=new int[]{4,234,32,423,5234,43};
        int result= new _215_kth_largest_element_in_an_array().findKthLargest(arrays,3);
        System.out.println(result);

    }
}
