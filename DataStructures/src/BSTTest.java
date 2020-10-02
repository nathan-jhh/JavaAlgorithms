public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        System.out.println("getSize(): " + bst.getSize());
        System.out.println("isEmpty(): " + bst.isEmpty());

        System.out.print("preOrder: ");
        bst.preOrder();

        System.out.print("\ninOrder: ");
        bst.inOrder();

        System.out.print("\npostOrder: ");
        bst.postOrder();

        System.out.print("\npreOrderNR: ");
        bst.preOrderNR();

        System.out.print("\nlevelOrder: ");
        bst.levelOrder();
    }
}
