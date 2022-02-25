package org.java17recipes.chapter03.recipe03_14;
public class FindFileType {
    
    private static String fileName = "RegExExamples.java";
    
    public static void main(String[] args) {
        findFileType(fileName);
    }
    
    
    public static void findFileType(String filename){
        System.out.println("Finding file type of: " + filename);
        if(filename.endsWith(".txt")){
            System.out.println("Text file");
        } else if (filename.endsWith(".doc")){
            System.out.println("Document file");
        } else if (filename.endsWith(".xls")){
            System.out.println("Excel file");
        } else if (filename.endsWith(".java")){
            System.out.println("Java source file");
        } else {
            System.out.println("Other type of file");
        }
    }
}
