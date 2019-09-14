import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Stores the list of tasks in a .txt file and retrieves the stored list
 * whenever Duke starts up.
 */
public class Storage {

    private static String filePath;

    public Storage(String filePath) {
        Storage.filePath = filePath;
    }

    /**
     * Stores the TaskList tasks into a file.
     * @param ui
     * @param tasks
     */
    public void save(Ui ui, TaskList tasks) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(tasks.taskList);
            objOut.close();
            fileOut.close();
            ui.printFileSaved();
        } catch (IOException e) {
            ui.printIOException(e);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the TaskList tasks from the file and load them onto the loadedArrayList.
     * If no file is found or there is an error loading the file, a new empty ArrayList
     * will be returned.
     * @param ui
     * @return ArrayList<Task> which is the TaskList tasks which is stored in the file.
     */
    public ArrayList<Task> load(Ui ui) {
        ArrayList<Task> loadedArrayList;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            // loadedArrayList = (ArrayList<Task>) Arrays.asList((Task[]) objIn.readObject());
            // loadedArrayList = (ArrayList) objIn.readObject();
            loadedArrayList = (ArrayList<Task>) objIn.readObject();
            objIn.close();
            fileIn.close();
            ui.printFileLoaded();
            return loadedArrayList;
        } catch (IOException e) {
            ui.printIOException(e);
            ui.printLoadingError();
            loadedArrayList = new ArrayList<Task>();
            return loadedArrayList;
        } catch (ClassNotFoundException e) {
            ui.printClassNotFoundException(e);
            ui.printLoadingError();
            loadedArrayList = new ArrayList<Task>();
            return loadedArrayList;
        }
    }
}