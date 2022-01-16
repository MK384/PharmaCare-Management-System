package records.area.handelers;

import records.area.head.FilesManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FilesManagerImp implements FilesManager {

    protected File mainDirectory;

    public FilesManagerImp(String mainDirectory) {
        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        File dir = new File(currentWorkingDir.normalize().toString(),mainDirectory);
        if (!dir.isDirectory())
            dir.mkdir();
        this.mainDirectory = dir;
    }

    @Override
    public boolean isExist(String fileName) {

        try {
            for (String s: Objects.requireNonNull(mainDirectory.list()))
                if (s.contains(fileName))
                    return true;
        } catch (Exception e) {
          //  e.printStackTrace();
        }
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
        ArrayList<File> files;
        try {
          files = new ArrayList<>(List.of(Objects.requireNonNull(mainDirectory.listFiles())));
        }
        catch (Exception e){
            files = new ArrayList<>();
        }
        return  files;
    }

    @Override
    public File search(String fileName) {
        if (isExist(fileName))
            for (File f: Objects.requireNonNull(mainDirectory.listFiles()))
                if (f.getName().contains(fileName))
                    return f;

        return null;
    }

//    public static void main(String[] args)
//    {
//        Path currentWorkingDir = Paths.get("").toAbsolutePath();
//        System.out.println(currentWorkingDir.normalize().toString());
//    }
}
