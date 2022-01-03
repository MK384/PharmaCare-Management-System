package records.area.head;

import java.io.File;
import java.io.IOException;
import java.util.List;

import records.area.stockroom.StockFile;

public interface FilesManager {

     boolean isExist(String filename);

     boolean isExist(File file);

     File createFile(String fileName) throws IOException;

     List<File> getAllFiles ();

     File search (String fileName);

}
