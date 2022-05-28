package fexp.classes;

import java.util.Scanner;
import java.io.File;
import java.nio.file.InvalidPathException;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// FileExplorer class - main program
public class FileExplorer {
    static private String currentPath = "C:/"; // Our path to current folder
    static private boolean isUpdated = false; // are filesList and foldersList updated
    static private final List<String> filesList = new ArrayList<>(); // list of files' names
    static private final List<String> foldersList = new ArrayList<>(); // list of folders' names
    static private final String cdPathRegex =
            "^cd\\s+[\\\\\\/]?(?<path>([\\\\\\/]?\\w+(.\\w+)*)+)[\\\\\\/]?$";
    static private final Pattern cdPathPattern = Pattern.compile(cdPathRegex);

    static private final String startingMsg = "FileExplorer";
    static private String getStartingMsg() {return startingMsg;}

    static public void run() { // Public method of fileExplorer
        System.out.println(getStartingMsg());
        showPath();
        _run();
        System.out.println("Bye!");
    }


    static private void getDirectoryFiles() {
        currentPath = currentPath.replaceAll("\\\\","/");
        filesList.clear();
        foldersList.clear();

        File currentFolder = new File(currentPath);
        File[] listOfFiles = currentFolder.listFiles();
        if( listOfFiles == null) { // If path is wrong
            throw new InvalidPathException(currentPath, "Path doesn't exist");
        }

        for( File f : listOfFiles) {
            if( f.isFile()) {
                filesList.add(f.getName());
            }
            if( f.isDirectory()) {
                foldersList.add(f.getName());
            }
        }
        isUpdated = true;
    }

    static private void showPath() {
        System.out.println(currentPath);
    }

    static private void showDirectory() {
        if( !isUpdated) getDirectoryFiles();
        showPath();
        for( String folder : foldersList) System.out.println(folder + "/");
        for( String file : filesList) System.out.println(file);
    }

    static private boolean goToPath(String newPath) { // False if it is not a folder, true if it is
        newPath = currentPath + newPath + "/";
        File f = new File(newPath);
        if(!f.isDirectory()) { // if it is not a directory
            if(f.exists()){
                // Open file
                return false;
            }
            System.out.println("No such path: " + newPath);
            return false;
        }

        currentPath = newPath;
        isUpdated = false;
        getDirectoryFiles();
        return true;
    }

    static private void goToParentFolder() {
        File f = new File(currentPath);
        if(f.getParent() == null) return; // f.getParent == null for "C:/" or "D:/" directories
        currentPath = f.getParent();
        isUpdated = false;
        getDirectoryFiles();
    }


    // Get a String from console
    static private String getInput() {
        System.out.print("$");
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        return inp;
    }

    // Processing of any console input
    static private boolean inputProcessing(String inp) {
        switch(inp) {
            case "-q": return true;
            case "dir": showDirectory(); break;
            case "cd": showPath(); break;
            case "cd ..": goToParentFolder(); showPath(); break;
            default:
                Matcher matcher = cdPathPattern.matcher(inp);
                if(matcher.matches()){
                    if(goToPath(matcher.group("path"))) showPath();
                    break;
                }
                System.out.println("Unknown command: \"" + inp + "\"");
                break;
        }
        return false;
    }

    static private void _run() { // Main cycle of FileExplorer
        if(inputProcessing(getInput())) return;
        _run();
    }


}
