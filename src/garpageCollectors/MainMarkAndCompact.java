package garpageCollectors;

import garpageCollectors.GarpageCollector;
import garpageCollectors.INode;
import garpageCollectors.MarkAndCompactGC;
import garpageCollectors.FileManager;

import java.io.IOException;
import java.util.ArrayList;

public class MainMarkAndCompact {
    public static void main(String[] Args) throws IOException {
        FileManager fileManager = FileManager.getInstance();
        fileManager.getHeapObjects("C:\\Users\\NEXT STORE\\eclipse-workspace\\garpageCollectors\\src\\garpageCollectors\\heap.csv");
        fileManager.readPointers("C:\\Users\\NEXT STORE\\eclipse-workspace\\garpageCollectors\\src\\garpageCollectors\\pointers.csv");
        ArrayList<INode> roots = fileManager.readRoots("C:\\Users\\NEXT STORE\\eclipse-workspace\\garpageCollectors\\src\\garpageCollectors\\roots.txt");
        GarpageCollector garbageCollector = new MarkAndCompactGC(fileManager.getHeap(), roots);
        ArrayList<INode> newHeap = garbageCollector.garbageCollect();
        FileManager.writeToCsv("C:\\Users\\NEXT STORE\\eclipse-workspace\\garpageCollectors\\src\\garpageCollectors\\Mark&Compact_new-heap.csv"
                , newHeap);

    }
}
