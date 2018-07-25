public class ComputeLCAWithParent {

    /*
    10.4
    */

    public static BinaryTreeParent<Integer> LCA(BinaryTreeParent<Integer> node0, BinaryTreeParent<Integer> node1) {
        int depth0 = getDepth(node0), depth1 = getDepth(node1);
        if (depth1 > depth0) {
            BinaryTreeParent<Integer> temp = node0;
            node0 = node1;
            node1 = temp;
        }
        int depthDiff = Math.abs(depth0 - depth1);
        while (depthDiff-- > 0) {
            node0 = node0.parent;
        }
        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }
        return node0;
    }

    private static int getDepth(BinaryTreeParent<Integer> node) {
        int depth = 0;
        while (node.parent != null) {
            ++depth;
            node = node.parent;
        }
        return depth;
    }
        // Post-optimization
//        int node0depth = 0;
//        int node1depth = 0;
//        BinaryTreeParent<Integer> node0copy = node0;
//        BinaryTreeParent<Integer> node1copy = node1;
//
//        while (node0copy.parent != null) {
//            node0copy = node0copy.parent;
//            node0depth++;
//        }
//        while (node1copy.parent != null) {
//            node1copy = node1copy.parent;
//            node1depth++;
//        }
//        if (node1depth > node0depth) {
//            for (int i = 0; i < node1depth - node0depth; i++) {
//                node1 = node1.parent;
//            }
//        } else if (node1depth < node0depth) {
//            for (int i = 0; i < node0depth - node1depth; i++) {
//                node0 = node0.parent;
//            }
//        }
//        while (node0 != node1) {
//            node1 = node1.parent;
//            node0 = node0.parent;
//        }
//        return node0;

        // Pre-optimization
//        List<BinaryTreeParent<Integer>> pathToRoot = new ArrayList<>();
//        while (node0.parent != null) {
//            pathToRoot.add(node0);
//            node0 = node0.parent;
//        }
//        while (node1.parent != null) {
//            if (pathToRoot.contains(node1)) {
//                return node1;
//            }
//            node1 = node1.parent;
//        }
//        if (node0 == node1) {
//            return node0;
//        }
//        return null;

}
