package records.area.handelers;

import records.area.head.FilesManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StockFilesManager implements FilesManager {

    protected File mainDirectory;

    public StockFilesManager(String mainDirectory) {
        File dir = new File(mainDirectory);
        if (dir.isDirectory())
            this.mainDirectory = dir;
        else{
            dir.mkdir();
            this.mainDirectory = dir;}
    }



    @Override
    public boolean isExist(String fileName) {


        for (String s: Objects.requireNonNull(mainDirectory.list()))
            if (s.contains(fileName))
                return true;
        return false;
    }

    @Override
    public boolean isExist(File file) {

        for (File f: Objects.requireNonNull(mainDirectory.listFiles()))
            if (f.equals(file))
                return true;
        return false;
    }

    @Override
    public File createFile(String fileName) throws IOException {

        File newFile = new File(mainDirectory, fileName+".ser");
        if (newFile.createNewFile())
            return newFile;

        return search(fileName);
    }

    @Override
    public List<File> getAllFiles() {
        return Arrays.asList(Objects.requireNonNull(mainDirectory.listFiles()));
    }

    @Override
    public File search(String fileName) {
        if (isExist(fileName))
            for (File f: Objects.requireNonNull(mainDirectory.listFiles()))
                if (f.getName().contains(fileName))
                    return f;

        return null;
    }
}
