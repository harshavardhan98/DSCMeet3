package in.cocomo.listview;

public class Contact {
    String name;
    String message;
    String dpUrl;
    String time;

    public Contact(String name, String message, String dpUrl, String time) {
        this.name = name;
        this.message = message;
        this.dpUrl = dpUrl;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDpUrl() {
        return dpUrl;
    }

    public void setDpUrl(String dpUrl) {
        this.dpUrl = dpUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
