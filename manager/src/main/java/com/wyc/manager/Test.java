package com.wyc.manager;

public class Test {

  public static void main(String[] args) {
    int[] nums1 = {3, 6};
    int[] nums2 = {1, 2, 4};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int length1 = nums1.length;
    int length2 = nums2.length;

    int totalNum = length1 + length2;
    int medileIndex = totalNum / 2;

    int i = 0, j = 0, currIndex = 0;
    boolean flag = true;
    while (true) {
      if (currIndex == medileIndex) {
        break;
      }
      if (i >= length1) {
        j++;
        flag = false;
      } else if (j >= length2) {
        i++;
        flag = true;
      } else if (nums1[i] < nums2[j]) {
        i++;
        flag = true;
      } else {
        j++;
        flag = false;
      }
      currIndex++;
    }

    if (totalNum % 2 != 0) {
      if (flag) {
        if (i > nums1.length - 1) {
          i--;
        }
        return Double.valueOf(nums1[i]);
      } else {
        if (j > nums2.length - 1) {
          j--;
        }
        return Double.valueOf(nums2[j]);
      }
    } else {
      int goal1 = 0;
      if (flag) {
        if (i >= nums1.length - 1) {
          goal1 = nums1[i - 1];
        } else {
          goal1 = nums1[i - 1];
        }
      } else {
        if (j >= nums2.length - 1) {
          goal1 = nums2[j - 1];
        } else {
          goal1 = nums2[j - 1];
        }
      }

      int goal2 = 0;
      if (i > nums1.length - 1) {
        goal2 = nums2[j];
      } else if (j > nums2.length - 1) {
        goal2 = nums1[i];
      } else {
        if (flag) {
          goal2 = nums1[i] > nums2[j] ? nums2[j] : nums1[i];
        } else {
          goal2 = nums1[i] > nums2[j] ? nums2[j] : nums1[i];
        }
      }
      return (goal1 + goal2) / 2.0D;
    }
  }
}
