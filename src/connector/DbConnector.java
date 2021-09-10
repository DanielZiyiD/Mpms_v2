package connector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DbConnector
{
    private String fileName;
    private boolean hasHeader;

    public DbConnector()
    {
        fileName = "";
        hasHeader = false;
    }

    // alt+insert
    public DbConnector(String fileName, boolean hasHeader) {
        this.fileName = fileName;
        this.hasHeader = hasHeader;
    }

    public ArrayList<String> readDataFromFile() {
        FileReader fileReader = null;
        ArrayList<String> data = new ArrayList<>();
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                data.add(line);
            }
            bufferedReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        if (hasHeader && data.size() > 0)
            data.remove(0);

        return data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isHasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }
}
