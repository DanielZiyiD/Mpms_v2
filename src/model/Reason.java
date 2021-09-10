package model;

public class Reason {
    private int reasonId;
    private String type;

    public Reason(int reasonId, String type) {
        this.reasonId = reasonId;
        this.type = type;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
