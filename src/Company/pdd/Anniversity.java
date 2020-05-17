package Company.pdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author wylu
 */
public class Anniversity {
    static int m;
    static ArrayList<Integer> parents = new ArrayList<>();
    static ArrayList<HashSet<Integer>> children = new ArrayList<>();
    static ArrayList<Integer> dists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            dists.add(0);
            parents.add(-1);
            children.add(new HashSet<>());
        }
        //建图
        for (int i = 0; i < n - 1; i++) {
            String[] strs = br.readLine().split(" ");
            int u = Integer.parseInt(strs[0]), v = Integer.parseInt(strs[1]);
            int d = Integer.parseInt(strs[2]);
            if (d > m) continue;
            children.get(u).add(v);
            parents.set(v, u);
            dists.set(v, d);
        }

        //寻找树根
        int root = 0;
        while (parents.get(root) != -1) root = parents.get(root);
        System.out.println(dfs(root).last());
    }

    private static TreeSet<Integer> dfs(int root) {
        TreeSet<Integer> res = new TreeSet<>();
        int d = dists.get(root);
        //如果该结点的父结点选中该元素表示不选取该结点所在分支
        res.add(0);
        if (children.get(root).size() == 0) {
            res.add(d);
            return res;
        }

        //每一个集合代表每个孩子结点的可选路径
        ArrayList<TreeSet<Integer>> sets = new ArrayList<>();
        for (int child : children.get(root)) sets.add(dfs(child));

        for (int i = 0; i < sets.size(); i++) {
            //选中一个孩子分支的情况
            for (int path : sets.get(i)) {
                if (d + path <= m) {
                    res.add(d + path);
                }
            }
            //选中两个孩子分支的情况
            for (int j = i + 1; j < sets.size(); j++) {
                for (int path1 : sets.get(i)) {
                    for (int path2 : sets.get(j)) {
                        if (path1 + path2 + d <= m) {
                            res.add(path1 + path2 + d);
                        }
                    }
                }
            }
        }
        return res;
    }
}


/*
*
import java.util.*;
public class Main {
    public static class TreeNode{
        int seq;
        int parent = -1;
        List<TreeNode> child = new ArrayList<>();
        List<Integer> edge = new ArrayList<>();;
        public TreeNode(int seq) {
            this.seq = seq;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        TreeNode[] t = new TreeNode[n];
        for(int i = 0; i < t.length; i++) {
            t[i] = new TreeNode(i);
        }
        for(int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int d = scanner.nextInt();
            t[u].child.add(t[v]);
            t[v].parent = u;
            t[u].edge.add(d);
        }
        int root = -1;
        for(int i = 0; i < t.length; i++) {
            if(t[i].parent == -1) {
                root = i;
            }
        }
        System.out.println(getLongestPath(t[root], m).last());
    }
    private static TreeSet<Integer> getLongestPath(TreeNode root, int m) {
        TreeSet<Integer> res = new TreeSet<Integer>();
        res.add(0);
        if(root == null) {
            return res;
        }
        ArrayList<Set<Integer>> arr = new ArrayList<>();
        for(TreeNode child : root.child) {
            arr.add(getLongestPath(child, m));
        }
        for(int i = 0; i < root.child.size(); i++) {
            int d = root.edge.get(i);
            for(Integer path : arr.get(i)) {
                if(d + path <= m) {
                    res.add(d + path);
                }
            }
        }
        for(int i = 0; i < root.child.size(); i++) {
            for(int j = i + 1; j < root.child.size(); j++) {
                int d = root.edge.get(i) + root.edge.get(j);
                for(Integer path1 : arr.get(i)) {
                    for(Integer path2 : arr.get(j)) {
                        if(d + path1 + path2 <= m) {
                            res.add(d + path1 + path2);
                        }
                    }
                }
            }
        }
        return res;
    }
}*/