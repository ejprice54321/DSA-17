import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values){
        Collections.sort(values);
        return mhBinaryTree(new BinarySearchTree<>(), values, 0, values.size());
    }

    public static BinarySearchTree<Integer> mhBinaryTree(BinarySearchTree<Integer> bst, List<Integer> values, int lo, int high){
        int mid = (high+lo)/2;
        if (high <= lo){
            return bst;
        } else{
            bst.add(values.get(mid));
            mhBinaryTree(bst,values,lo,mid);
            mhBinaryTree(bst,values,mid+1,high);
        }
        return bst;
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null){
            return true;
        }else if (n1 == null || n2 == null){
            return false;
        }else if(n1.key != n2.key){
            return false;
        }else{
            return isIsomorphic(n1.leftChild, n2.leftChild) && isIsomorphic(n1.rightChild, n2.rightChild)
                    || isIsomorphic(n1.leftChild, n2.rightChild) && isIsomorphic(n1.rightChild, n2.leftChild);
        }
    }
}
