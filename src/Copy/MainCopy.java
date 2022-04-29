package Copy;

import java.io.IOException;
import java.util.ArrayList;

import garpageCollectors.FileManager;
import garpageCollectors.GarpageCollector;
import garpageCollectors.INode;

public class MainCopy {
    public static void main(String Args[]) throws IOException {
        FileManager fileManager = FileManager.getInstance();
        fileManager.getHeapObjects("C:\\Users\\NEXT STORE\\eclipse-workspace\\garpageCollectors\\src\\Copy\\heap.csv");
        fileManager.readPointers("C:\\Users\\NEXT STORE\\eclipse-workspace\\garpageCollectors\\src\\Copy\\pointers.csv");
        ArrayList<INode> roots = fileManager.readRoots("C:\\Users\\NEXT STORE\\eclipse-workspace\\garpageCollectors\\src\\Copy\\roots.txt");
        GarpageCollector garbageCollector = new CopyGC(roots);
        ArrayList<INode> newHeap = garbageCollector.garbageCollect();
        FileManager.writeToCsv("C:\\Users\\NEXT STORE\\eclipse-workspace\\garpageCollectors\\src\\Copy\\new-heap.csv", 
        		newHeap);
    }
}
