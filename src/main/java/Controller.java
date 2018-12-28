import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    private Connectable connector;

    @FXML
    private TextField describe, money;
    @FXML private Button addButton, totalButton, swButton;
    @FXML private ChoiceBox<String> type;
    @FXML private TableView<Data> tableView;
    @FXML private TableColumn detail, amount;
    @FXML private Label label;


    public void initialize() {
        connector = DBConnector.getInstance();
        detail.setCellValueFactory(new PropertyValueFactory<Data, String>("detail"));
        amount.setCellValueFactory(new PropertyValueFactory<Data, String>("amount"));
        tableView.setItems(connector.viewHistory());
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Data>() {
            @Override
            public void changed(ObservableValue<? extends Data> observable, Data oldValue, Data newValue) {
                addButton.setDisable(false);
            }
        });
        describe.setText("");
        type.getItems().addAll("Income", "Expense");

    }

    public void addBtn(ActionEvent event) {
        String t  = type.getValue();
        String des  = describe.getText();
        String am = money.getText();
        if (t != null && des != null && am != null) {
            if (t.equals("Income"))
                connector.add(t, des, "+" + am);
            else if (t.equals("Expense"))
                connector.add(t, des, "-" + am);
            describe.clear();
            money.clear();
            tableView.setItems(connector.viewHistory());
        }
    }

    public void showTotal(ActionEvent event) {
        double total = 0;
        for (Data i : connector.viewHistory()) {
            if (i.getType().equals("Income")) {
                total += Double.valueOf(i.getAmount().substring(1).trim());
            }else if (i.getType().equals("Expense"))
                total -= Double.valueOf(i.getAmount().substring(1).trim());
        }
        System.out.println(total);
        label.setText("Total Balance : " + total);
    }

    public void switchDB() {
        if (DBConnector.class == connector.getClass()) {
            connector = FileConnector.getInstance();
        }
        else {
            connector = DBConnector.getInstance();
        }
        tableView.setItems(connector.viewHistory());
    }

}
