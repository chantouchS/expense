import javafx.collections.ObservableList;

public interface Connectable {
    ObservableList<Data> viewHistory();
    void add(String type, String detail, String amount);
}
