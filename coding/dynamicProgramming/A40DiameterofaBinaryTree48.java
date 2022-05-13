package coding.dynamicProgramming;

public class A40DiameterofaBinaryTree48 {
	
	
    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private static int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left+right);
        return Math.max(left, right)+1;
    }
	
	public static void main(String[] args) {
		
	}

}
