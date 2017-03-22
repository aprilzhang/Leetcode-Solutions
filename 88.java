/**
88. Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        while(index1>=0&&index2>=0)
        {
            nums1[index1+index2+1] = nums1[index1]>nums2[index2]
            ?nums1[index1--]
            :nums2[index2--];
        }
        if(index2>=0)
        {
            for(int i =0;i<=index2;i++)
            {
                nums1[i] = nums2[i];
            }
        }
    }
}

//slightly faster
class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        int i=m-1;
		int j=n-1;
		int k = m+n-1;
		while(i >=0 && j>=0)
		{
			if(A[i] > B[j])
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
		while(j>=0)
			A[k--] = B[j--];
    }
};