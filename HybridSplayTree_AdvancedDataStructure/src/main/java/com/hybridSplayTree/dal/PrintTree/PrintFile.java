package com.hybridSplayTree.dal.PrintTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrintFile {

    private static PrintFile instance = null;
    private String treeType = "";
    private String path = "./Trees/";
    private BufferedWriter bufferedWriter = null;
    private FileWriter fileWriter = null;


    private PrintFile(String treeType) throws IOException {
        File file = new File(path+treeType);
        deleteDir(file);
        Files.createDirectories(Paths.get(path+treeType));
        fileWriter = new FileWriter(new File(path+treeType+"/"+treeType+".txt"));
        bufferedWriter= new BufferedWriter(fileWriter);
    }

    private void deleteDir(File dir) {
        File[] files = dir.listFiles();
        if(files != null) {
            for (final File file : files) {
                deleteDir(file);
            }
        }
        dir.delete();
    }

    public static PrintFile getInstance(String treeType) throws IOException {
        if (instance == null) {
            instance = new PrintFile(treeType);
        }
        return instance;
    }

    public void print(boolean consolePrint, int partition, String data) throws IOException {

        this.treeType = treeType;
        StringBuilder printing = new StringBuilder();

        for (int t = 0; t < partition - data.length(); t++) {
            printing.append(" ");
        }

        printing.append(data);

        if (consolePrint) {
            System.out.print(printing.toString());
        }
        writeToFile(printing.toString());
    }

    public void printNext(boolean consolePrint) throws IOException {
        writeToFile("\n\n");
        if(consolePrint){
            System.out.println("\n");
        }
    }

    private void writeToFile(String data) throws IOException {
        bufferedWriter.write(data);
    }

    public void close() throws IOException {
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
        instance = null;
    }


}
