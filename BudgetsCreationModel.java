package creation;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BudgetsCreationModel {
    private static final String FILE_REPOSITORY = "sysfiles/filerepository.dat";

    public static boolean checkFileNameExists(String filenameToCheck) {
        try (BufferedReader reader = new BufferedReader(new FileReader("budgetrepository.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(filenameToCheck)) {
                    return true; // File name found in the repository
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
        return false; // File name not found in the repository
    }
	
	public static boolean createFile(String filename) {
        String directoryPath = "budgetfiles/";
        String filePath = directoryPath + filename + ".dat";

        File file = new File(filePath);

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs(); // Create directory if it doesn't exist
                if (file.createNewFile()) {
                    System.out.println("File created successfully: " + filePath);
                    return true;
                } else {
                    System.out.println("Failed to create the file: " + filePath);
                    return false;
                }
            } else {
                System.out.println("File already exists: " + filePath);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
            return false;
        }
    }

    public void budgetTags(String tag, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename + "-tags.dat", true))) {
            writer.write(tag);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error: Failed to write the tag to the file.");
        }
    }

    public void budgetAllocation(String tags, double budget, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename + "-alloc.dat", true))) {
            writer.write(tags + "," + budget);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error: Failed to write the allocation to the file.");
        }
    }
	
	public void cancelCreation(String filename){
		 
        String directoryPath = "budgetfiles/";
        String[] extensions = { ".dat", "-tags.dat", "-alloc.dat" };

        for (String ext : extensions) {
            String filePath = directoryPath + filename + ext;
            File file = new File(filePath);

            try {
                if (!file.exists()) {
                    file.getParentFile().mkdirs(); // Create directory if it doesn't exist
                    if (file.createNewFile()) {
                        System.out.println("File created successfully: " + filePath);
                    } else {
                        System.out.println("Failed to create the file: " + filePath);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log the exception appropriately
            }
        }

        // Delete the created files
        for (String ext : extensions) {
            String filePath = directoryPath + filename + ext;
            File file = new File(filePath);

            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("File deleted successfully: " + filePath);
                } else {
                    System.out.println("Failed to delete the file: " + filePath);
                }
            } else {
                System.out.println("File does not exist: " + filePath);
            }
        }
    }

 
}


