public class BinarySearchTree<E extends Comparable<E>> {
    //不包含重复元素的二分搜索树

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树添加新的元素
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    //查询二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }
    //查询以node为根节点的二分搜索树中是否包含元素e
    private boolean contains(Node node, E e){
        if (node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node == null){
            return;
        }

        //遍历操作
        System.out.print(node.e + " ");

        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历,遍历后的结果有序的
    public void inOrder(){
        inOrder(root);
    }
    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);

        //遍历操作
        System.out.print(node.e + " ");

        inOrder(node.right);
    }

    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);

        //遍历操作
        System.out.print(node.e + " ");
    }
}
