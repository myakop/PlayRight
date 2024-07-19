package application;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CustomerNameListCellFactory2 implements Callback<ListView<Customer>, ListCell<Customer>> {

    @Override
    public ListCell<Customer> call(ListView<Customer> param) {
        return new ListCell<Customer>() {
            @Override
            protected void updateItem(Customer customer, boolean empty) {
                super.updateItem(customer, empty);
                if (customer == null || empty) {
                    setText(null);
                } else {
                    // Display only the name
                    setText(customer.getUserName());
                }
            }
        };
    }
}
