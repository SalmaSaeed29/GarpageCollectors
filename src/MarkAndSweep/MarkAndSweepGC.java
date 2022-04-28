package MarkAndSweep;

import java.util.ArrayList;

import garpageCollectors.GarpageCollector;
import garpageCollectors.INode;


public class MarkAndSweepGC implements GarpageCollector {
	private ArrayList<INode> heap;
    private ArrayList<INode> newHeap=new ArrayList<>();
    private ArrayList<INode> roots;

    public MarkAndSweepGC(ArrayList<INode> heap, ArrayList<INode> roots)
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
    	mark(root);
    }
    	sweep();
    return newHeap;

    }

    public void mark(INode current) {
        current.setMarked();
        if (current.getChildren().size() == 0) return;
        for (INode node : current.getChildren()) {
        	mark(node);
        }
    }

    public void sweep() {
        int startIndex=0;
        for (INode node : heap) {
        if (node.isMarked())
            {
                newHeap.add(node);
            }
        }
    }
}
