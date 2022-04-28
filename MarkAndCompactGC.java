package garpageCollectors;

import garpageCollectors.GarpageCollector;
import garpageCollectors.INode;

import java.util.ArrayList;

public class MarkAndCompactGC implements GarpageCollector {
    private ArrayList<INode> heap;



    private ArrayList<INode> newHeap=new ArrayList<>();
    private ArrayList<INode> roots;

    public MarkAndCompactGC(ArrayList<INode> heap, ArrayList<INode> roots)
    {
      this.heap=heap;
      this.roots=roots;
    }
    public ArrayList<INode> getHeap() {
        return newHeap;
    }

    public void setHeap(ArrayList<INode> heap) {
        this.heap = heap;
    }



    @Override
    public ArrayList<INode> garbageCollect() {
    for(INode root: roots)
    {
        dfs(root);
    }
        compact();
    return newHeap;

    }

    public void dfs(INode current) {
        current.setMarked();
        if (current.getChildren().size() == 0) return;
        for (INode node : current.getChildren()) {
            dfs(node);
        }
    }

    public void compact() {
        int startIndex=0;
        for (INode node : heap) {
        if (node.isMarked())
            {
                node.setHeapStartIndex(startIndex);
                int endIndex=startIndex+node.getSize();
                node.setHeapEndIndex(endIndex);
                newHeap.add(node);
                startIndex=endIndex+1;

            }
        }

    }
}
