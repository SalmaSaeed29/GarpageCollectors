package garpageCollectors;

import java.util.ArrayList;

public interface INode {
    void addChild(INode node);
    ArrayList<INode> getChildren();
    String getID();
    boolean isMarked();
    int getHeapStartIndex();
    int getHeapEndIndex();
    void setHeapStartIndex(int heapStartIndex);
    void setHeapEndIndex(int heapEndIndex);
    int getSize();
    void setMarked();
}
