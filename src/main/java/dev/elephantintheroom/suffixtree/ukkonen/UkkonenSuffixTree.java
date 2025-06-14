package dev.elephantintheroom.suffixtree.ukkonen;

import dev.elephantintheroom.suffixtree.SuffixTree;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class UkkonenSuffixTree implements SuffixTree {
    private record Edge(int start, OptionalInt end) {}
    private record Node(Map<Character, Edge> edges, Map<Edge, Node> nodes) {}

    private final String s;
    private final Node root;

    UkkonenSuffixTree(String s) {
        this.s = s;
        root = new Node(new HashMap<>(), new HashMap<>());
        int position = 0;
        for (char c : s.toCharArray()) {
            var edge = new Edge(position, OptionalInt.empty());
            root.edges.put(c, edge);
            var node = new Node(new HashMap<>(), new HashMap<>());
            root.nodes.put(edge, node);
            position++;
        }
    }

    public boolean contains(String subString) {
        return contains(subString, root);
    }

    private boolean contains(String subString, Node node) {
        if (subString.isEmpty()) return true;

        var c = subString.charAt(0);
        if (!node.edges.containsKey(c)) return false;
        var edge = node.edges.get(c);

        String prefix = switch(edge) {
            case Edge(var start, var end) when end.isEmpty() -> s.substring(start);
            case Edge(var start, var end) -> s.substring(start, end.getAsInt());
        };
        if (subString.length() < prefix.length()) return prefix.startsWith(subString);
        if (!subString.startsWith(prefix)) return false;

        var remaining = subString.substring(prefix.length());

        var nextNode = node.nodes.get(edge);
        return contains(remaining, nextNode);
    }
}
