package main;

import java.io.*;

public class FileMerger {

    public static void main(String[] args) {
        String inputDirPath = "src/main/java/components/";
        String outputFile = "src/main/allCode.txt";
        File inputDir = new File(inputDirPath);
        try {
            FileWriter writer = new FileWriter(outputFile);
            processDirectory(inputDir, writer);
            writer.close();
            System.out.println("All files merged successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while merging files: " + e.getMessage());
        }
    }

    private static void processDirectory(File dir, FileWriter writer) throws IOException {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                processDirectory(file, writer);
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    writer.write(line);
                    writer.write(System.lineSeparator());
                    line = reader.readLine();
                }
                reader.close();
            }
        }
    }
}

