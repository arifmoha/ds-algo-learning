package ds.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(Integer data){
        this.data = data;
    }

    public static BinaryTree sortedArrayToBT(int[] array){
        int size = array.length;
        return sortedArrayToBT(array, 0, size-1);
    }

    static BinaryTree sortedArrayToBT(int[] array, int start, int end){
        if (start == end){
            return new BinaryTree(array[start]);
        }

        else if(start < end){

            int mid = start + (end-start)/2;
            BinaryTree midNode = new BinaryTree(array[mid]);
            midNode.left= sortedArrayToBT(array, start, mid-1);
            midNode.right = sortedArrayToBT(array, mid+1, end);

            return midNode;
        }

        return null;
    }

    public static boolean isBinarySearchTree(BinaryTree tree){
        if(tree == null) return true;
        return checkBST(tree, Integer.MIN_VALUE);
    }

    static boolean checkBST(BinaryTree tree, int min){
        if(tree == null) return true;

        if(!checkBST(tree.left, min)) return false;

        if(tree.data < min){
            return false;
        }

        min = tree.data;

        return checkBST(tree.right, min);
    }

    public static boolean isBinarySearchTree2(BinaryTree tree){
        if(tree == null) return true;
        return checkBST2(tree, null, null);
    }

    static boolean checkBST2(BinaryTree tree, Integer min, Integer max){
        if(tree == null) return true;

        if(min != null && min > tree.data) return false;
        if(max != null && max < tree.data) return false;

        if(!checkBST2(tree.left, min, tree.data)) return false;
        if(!checkBST2(tree.right, tree.data, max)) return false;

        return true;
    }

    public static boolean isBalanced(BinaryTree tree){
        return checkHeight(tree) != Integer.MIN_VALUE;
    }

    static int checkHeight(BinaryTree tree){
        if(tree == null) return 0;
        int left_height = checkHeight(tree.left);
        int right_height = checkHeight(tree.right);

        if(Math.abs(left_height - right_height) > 1){
            return Integer.MIN_VALUE;
        }

        return 1+Math.max(left_height, right_height);
    }

    public static ArrayList<LinkedList<BinaryTree>> listOfDepths(BinaryTree tree){
        ArrayList<LinkedList<BinaryTree>> result = new ArrayList<>();
        if(tree == null){
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<BinaryTree> current = new LinkedList<>();
        current.add(tree);

        while(!current.isEmpty()){
            result.add(current);

            LinkedList<BinaryTree> prev = current;
            current = new LinkedList<>();

            for (BinaryTree node: prev){
                if(node.left!=null){
                    current.add(node.left);
                }
                if(node.right!=null){
                    current.add(node.right);
                }
            }
        }

        return result;
    }

    public static ArrayList<LinkedList<BinaryTree>> listOfDepths2(BinaryTree tree){
       ArrayList<LinkedList<BinaryTree>> result = new ArrayList<>();
       return listOfDepths(tree, result, 0);
    }

    static ArrayList<LinkedList<BinaryTree>> listOfDepths(BinaryTree tree,
                                                          ArrayList<LinkedList<BinaryTree>> result,
                                                          int level){
        if(result.get(level)!=null){
            LinkedList<BinaryTree> listAtDepth = result.get(level);
        }

        listOfDepths(tree.left, result, level+1);
        listOfDepths(tree.right, result, level+1);

        return result;
    }
}
