/*
		 
		Problem :
		A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
		
		Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
		
		You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
		
		BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
		BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
		Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
		
		For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
		
		Example 1:
		Input: mat = [[0,0],[1,1]]
		Output: 0
		
		Example 2:
		Input: mat = [[0,0],[0,1]]
		Output: 1
		
		Example 3:
		Input: mat = [[0,0],[0,0]]
		Output: -1
		
		Example 4:
		Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
		Output: 1
		 
		
		Constraints:
		
		1 <= mat.length, mat[i].length <= 100
		mat[i][j] is either 0 or 1.
		mat[i] is sorted in a non-decreasing way.
 */

package array.matrix;

import java.util.List;

interface BinaryMatrix {
	public List<Integer> dimensions();
	public int get(int x, int y);
}

public class LeftmostColumnwithatLeastaOne {

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		int m = binaryMatrix.dimensions().get(0);
		int n = binaryMatrix.dimensions().get(1);
		int smallest = n + 1;
		for (int i = 0; i < m; i++) {
			smallest = Math.min(smallest, binarySearch(binaryMatrix, i));
		}
		return smallest > n ? -1 : smallest;
	}

	int binarySearch(BinaryMatrix binaryMatrix, int i) {
		int start = 0;
		int end = binaryMatrix.dimensions().get(1) - 1;
		int mid, midnum;
		while (start <= end) {
			mid = (start + end) / 2;
			midnum = binaryMatrix.get(i, mid);
			if (midnum == 1) {
				if (mid == 0 || binaryMatrix.get(i, mid - 1) == 0)
					return mid;
				// move left
				end = mid - 1;
				continue;
			}
			// move right
			start = mid + 1;
		}
		return binaryMatrix.dimensions().get(1) + 1;
	}
}
