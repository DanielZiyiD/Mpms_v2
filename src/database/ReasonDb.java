package database;

import connector.DbConnector;
import model.Reason;

import java.util.ArrayList;

public class ReasonDb {
    private ArrayList<Reason> reasons;
    private DbConnector dbConnector;

    public ReasonDb() {
        reasons = new ArrayList<>();
        dbConnector = new DbConnector();
    }

    public ReasonDb(ArrayList<Reason> reasons, DbConnector dbConnector) {
        this.reasons = reasons;
        this.dbConnector = dbConnector;
    }

    public void fetch() {
        dbConnector.setFileName("Reason.txt");
        dbConnector.setHasHeader(false);
        ArrayList<String> lines = dbConnector.readDataFromFile();
        for (String line : lines) {
            String[] lineArray = line.split(",");
            Reason reason = new Reason(Integer.parseInt(lineArray[0]), lineArray[1]);
            reasons.add(reason);
        }
    }

    public ArrayList<Reason> getReasons() {
        return reasons;
    }

    public void setReasons(ArrayList<Reason> reasons) {
        this.reasons = reasons;
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }
}
