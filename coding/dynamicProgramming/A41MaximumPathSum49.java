package coding.dynamicProgramming;

public class A41MaximumPathSum49 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }
    
    public int solve(TreeNode root){
        if(root == null) return 0;
        int l = Math.max(0, solve(root.left));
        int r = Math.max(0, solve(root.right));
        max = Math.max(max, l+r+root.val);
        return Math.max(l,r)+root.val;
    }
}
