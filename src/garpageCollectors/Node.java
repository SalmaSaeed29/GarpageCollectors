package garpageCollectors;

import garpageCollectors.INode;
import java.util.ArrayList;

public class Node implements INode {
    private String id;
    private int heapStartIndex;
    private int heapEndIndex;
    private final int size;
    private boolean isMarked=false;
    private ArrayList<INode> children=new ArrayList<>();

    public Node(String id, int heapStartIndex, int heapEndIndex) {
        this.id = id;
        this.heapEndIndex = heapEndIndex;
        this.heapStartIndex = heapStartIndex;
        this.size = heapEndIndex - heapStartIndex ;
    }

    @Override
    public void addChild(INode node) {
        children.add(node);

    }

    @Override
    public ArrayList<INode> getChildren() {
        return children;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public boolean isMarked() {
        return isMarked;
    }

    @Override
    public int getHeapStartIndex() {
        return heapStartIndex;
    }

    @Override
    public int getHeapEndIndex() {
        return heapEndIndex;
    }

    @Override
    public void setHeapStartIndex(int heapStartIndex) {

        this.heapStartIndex=heapStartIndex;

    }

    @Override
    public void setHeapEndIndex(int heapEndIndex) {
        this.heapEndIndex=heapEndIndex;
    }

    @Override
    public int getSize() {
        return size;

    }

    @Override
    public void setMarked() {
        this.isMarked=true;
    }
}
