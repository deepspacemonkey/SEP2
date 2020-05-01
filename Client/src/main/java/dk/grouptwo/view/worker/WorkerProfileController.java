package dk.grouptwo.view.worker;

import dk.grouptwo.view.ViewHandler;
import dk.grouptwo.viewmodel.worker.WorkerProfileViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

public class WorkerProfileController extends WorkerViewTabController {
    private WorkerProfileViewModel viewModel;

    @FXML
    private TableView<?> workerProfileLicenseTable;

    @FXML
    private TableColumn<?, ?> workerProfileLicenseColumn;

    @FXML
    private TableColumn<?, ?> workerProfileCategoryColumn;

    @FXML
    private TextField workerProfileCPR;

    @FXML
    private TextField workerProfileFirstName;

    @FXML
    private TextField workerProfileLastName;

    @FXML
    private DatePicker workerProfileDatePicker;

    @FXML
    private ComboBox<?> workerProfileGender;

    @FXML
    private TextField workerProfileCity;

    @FXML
    private TextField workerProfilePostCode;

    @FXML
    private TextField workerProfileMobilePhone;

    @FXML
    private ComboBox<?> workerProfileTaxCard;

    @FXML
    private TextField workerProfileLanguages;

    @FXML
    private TextArea workerProfileDescription;

    @FXML
    private TextField workerProfileEmail;

    @FXML
    private TextField workerProfileCurrentPassword;

    @FXML
    private TextField workerProfileNewPassword;

    @FXML
    private TextField workerProfileConfirmPassword;

    @FXML
    private TextField workerProfileLicense;

    @FXML
    private TextField workerProfileCategory;

    @FXML
    private Label workerProfileNameLabel;

    public void init(ViewHandler viewHandler, WorkerProfileViewModel viewModel, Region root) {
        super.init(viewHandler, root);
        this.viewModel = viewModel;
    }

    @FXML
    void workerProfileAddButtonPressed() {

    }

    @FXML
    void workerProfileRemoveButtonPressed() {

    }

    @FXML
    void workerProfileSaveButtonPressed() {

    }

    public void reset() {

    }
}
