package org.java17recipes.chapter08.recipe08_09;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
 
public class Ch_8_09_MetadataInfo {

    private void start() {
        Path path = FileSystems.getDefault().getPath("./file2.log");
        try {
            // General file attributes, supported by all Java systems
            System.out.println("File Size:"+Files.size(path));
            System.out.println("Is Directory:"+Files.isDirectory(path));
            System.out.println("Is Regular File:"+Files.isRegularFile(path));
            System.out.println("Is Symbolic Link:"+Files.isSymbolicLink(path));
            System.out.println("Is Hidden:"+Files.isHidden(path));
            System.out.println("Last Modified Time:"+Files.getLastModifiedTime(path));
            System.out.println("Owner:"+Files.getOwner(path));

            // Specific attribute views.
            //PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);
            DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
            System.out.println("\nDOS File Attributes\n------------------------------------\n");
            System.out.println("Archive  :"+view.readAttributes().isArchive());
            System.out.println("Hidden   :"+view.readAttributes().isHidden());
            System.out.println("Read-only:"+view.readAttributes().isReadOnly());
            System.out.println("System   :"+view.readAttributes().isSystem());

            view.setHidden(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Ch_8_09_MetadataInfo info = new Ch_8_09_MetadataInfo();
        info.start();
    }

}
