class Program {
    // T: O(d); where d is the depth of the lowest descendant | S: O(1)
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
            AncestralTree descendantTwo) {

        int depthOne = depthFinder(topAncestor, descendantOne);
        int depthTwo = depthFinder(topAncestor, descendantTwo);

        if (depthOne > depthTwo) {
            // lowerNode, higherNode, diff
            return backTrackForYCA(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return backTrackForYCA(descendantTwo, descendantOne, depthTwo - depthOne);
        }

    }

    public static int depthFinder(AncestralTree root, AncestralTree descendant) {
        int depth = 0;

        while (descendant != root) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }

    public static AncestralTree backTrackForYCA(AncestralTree lowerNode, AncestralTree higherNode, int diff) {
        while (diff > 0) {
            diff--;
            lowerNode = lowerNode.ancestor;
        }
        while (lowerNode != higherNode) {
            lowerNode = lowerNode.ancestor;
            higherNode = higherNode.ancestor;
        }
        return lowerNode;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
