package G1;

import garpageCollectors.GarpageCollector;
import java.util.ArrayList;
import garpageCollectors.INode;
import G1.G1FileManager;

public class G1GC implements GarpageCollector{
	private ArrayList<INode> heap;
    private ArrayList<INode> newHeap=new ArrayList<>();
    private ArrayList<INode> roots;
    private ArrayList<INode> grayNodes=new ArrayList<>();
    private ArrayList<INode> newGrayNodes=new ArrayList<>();
    
	public G1GC(ArrayList<INode> heap, ArrayList<INode> roots)
    {
      this.heap=heap;
      this.roots=roots;
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
	
	public ArrayList<INode> getGrayNodes() {
		for(INode node : heap) {
			if(!node.isMarked()) {
				grayNodes.add(node);
			}
		}
		return grayNodes;
	}
	
	public void sweep() {
		int temp = G1FileManager.getNodeSize();
        for (INode node : grayNodes) {
        if (node.getSize()<temp-1)
             newGrayNodes.add(node);
        }
    }
}
