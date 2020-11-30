import java.util.*;

class Program {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST currentNode = this;
            while (true) {
                if (currentNode.value <= value) {

                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                } else {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            BST tree = this;
            while (tree != null) {
                if (tree.value == value) {
                    return true;
                } else if (tree.value < value) {
                    tree = tree.right;
                } else {
                    tree = tree.left;
                }
            }

            return false;
        }

        // IMORTANT: Many edge cases + difficult to implement. 
        // HACK: https://www.techiedelight.com/deletion-from-bst/
        public BST remove(int value) {
            removeHelper(value, null);
            return this;
        }

        public void removeHelper(int value, BST parentNode) {
            BST currentNode = this;
            while (currentNode != null) {
                if (currentNode.value > value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (currentNode.value < value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    // Found the number.

                    // CASE 1: Deleting a node with two childrens (left & right)
                    if (currentNode.left != null && currentNode.right != null) {
                        // Find minimum value in the right side of the currentNode
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.removeHelper(currentNode.value, currentNode);
                    } 
                    // CASE 2: Value to remove is root node and tree doesn't have both left and right children nodes.
                    else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            // This is a single-node tree; do nothing as asked by the question description.
                            // We can also delete the WHOLE tree if nothing is mentioned by:
                            // currentNode = null
                        }
                    }

                    // CASE 3: Deleting a Node with one child or a leaf node. 
                    else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    }

                    // CASE 3: Deleting a Node with one child or a leaf node. 
                    else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }

                    break;
                }
            }
        }

        public int getMinValue() {
            if (left == null)
                return value;
            else
                return left.getMinValue();
        }

    }
}
