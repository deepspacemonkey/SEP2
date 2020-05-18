import dk.grouptwo.model.ModelManager;
import dk.grouptwo.model.objects.Address;
import dk.grouptwo.model.objects.Employer;
import dk.grouptwo.model.objects.Job;
import dk.grouptwo.model.objects.Worker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ModelManagerTest {

    private ModelManager model;
    Employer dummyEmployer = new Employer("employer@gmail.com", "11111111", new Address("Denmark", "Horsens", "Sundvej", "8700"), "111111", "Employer Company");
    Worker dummyWorker = new Worker("worker@gmail.com", "11223344", new Address("Denmark", "Horsens", "Sundvej", "8700"), "220220-2222", "John", "Doe", "A", "Danish, English", "I like to be a human-being", LocalDate.of(2020, 02, 22), "Other");


    @BeforeEach
    void setUp() {
        model = new ModelManager();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerAccountWorker() throws Exception {
        model.registerAccountWorker(dummyWorker, "12345678", "12345678");
        model.logInWorker(dummyWorker.getCPR(), "12345678");
        assertEquals(dummyWorker, model.getWorker());
    }

    @Test
    void registerAccountWorkerExistingAccount() throws Exception {
        String errorMessage = "";
        model.registerAccountWorker(dummyWorker, "12345678", "12345678");
        Worker anotherDummyWorker = dummyWorker;
        try {
            model.registerAccountWorker(anotherDummyWorker, "12345678", "12345678");
        }
        catch (Exception e)
        {
            errorMessage = e.getMessage();
        }
        assertEquals("Account could not be created!", errorMessage);
    }

    @Test
    void registerAccountWorkerNotMatchingPasswords() throws Exception {
        String errorMessage = "";

        try {
            model.registerAccountWorker(dummyWorker, "12345678", "123456789");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("The passwords do not match.", errorMessage);
    }

    @Test
    void registerAccountWorkerPasswordLength() throws Exception {
        String errorMessage = "";
        try {
            model.registerAccountWorker(dummyWorker, "1234567", "1234567");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("The password should contain at least 8 characters.", errorMessage);
    }

    @Test
    void registerAccountWorkerEmailFormat() throws Exception {
        String errorMessage = "";
        dummyWorker.setEmail("worker@@gmail.com");
        try {
            model.registerAccountEmployer(dummyEmployer, "12345678", "12345678");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("Wrong email format.", errorMessage);
    }

    @Test
    void logInWorkerNotExisting() throws Exception {
        String errorMessage = "";
        try {
            model.logInWorker("000000-0000", "12345678");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("Account does not exist!", errorMessage);
    }

    @Test
    void registerAccountEmployer() throws Exception {

        model.registerAccountEmployer(dummyEmployer, "12345678", "12345678");
        model.logInEmployer(dummyEmployer.getCVR(), "12345678");
        assertEquals(dummyEmployer, model.getEmployer());
    }

    @Test
    void registerAccountEmployerExistingAccount() throws Exception {
        String errorMessage = "";
        model.registerAccountEmployer(dummyEmployer, "12345678", "12345678");
        Employer anotherDummyEmployer = dummyEmployer;
        try {
            model.registerAccountEmployer(anotherDummyEmployer, "12345678", "12345678");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("Account could not be created!", errorMessage);
    }

    @Test
    void registerAccountEmployerNotMatchingPasswords() throws Exception {
        String errorMessage = "";

        try {
            model.registerAccountEmployer(dummyEmployer, "12345678", "123456789");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("The passwords do not match.", errorMessage);
    }


    @Test
    void registerAccountEmployerPasswordLength() throws Exception {
        String errorMessage = "";

        try {
            model.registerAccountEmployer(dummyEmployer, "1234567", "1234567");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("The password should contain at least 8 characters.", errorMessage);
    }

    @Test
    void registerAccountEmployerEmailFormat() throws Exception {
        String errorMessage = "";
        dummyEmployer.setEmail("employer@@gmail.com");
        try {
            model.registerAccountEmployer(dummyEmployer, "12345678", "12345678");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("Wrong email format.", errorMessage);
    }


    @Test
    void logInEmployer() throws Exception {

    }


    @Test
    void editEmployer() throws Exception {
        Employer dummyEmployerEdited = dummyEmployer;
        model.registerAccountEmployer(dummyEmployerEdited, "12345678", "12345678");
        model.logInEmployer(dummyEmployerEdited.getCVR(), "12345678");
        dummyEmployerEdited.setCompanyName("Another Employer Company");
        model.editEmployer(dummyEmployerEdited, "12345678");
        assertEquals(dummyEmployerEdited, model.getEmployer());
    }

    @Test
    void editEmployerPassword() throws Exception {
        Employer dummyEmployerEdited = dummyEmployer;
        model.registerAccountEmployer(dummyEmployerEdited, "12345678", "12345678");
        model.logInEmployer(dummyEmployerEdited.getCVR(), "12345678");
        model.editEmployer(dummyEmployerEdited, "12345678", "87654321", "87654321");
        assertEquals(dummyEmployerEdited, model.getEmployer());
    }


    @Test
    void editEmployerWrongCurrentPassword() throws Exception {
        String errorMessage = "";
        Employer dummyEmployerEdited = dummyEmployer;
        model.registerAccountEmployer(dummyEmployerEdited, "12345678", "12345678");
        model.logInEmployer(dummyEmployerEdited.getCVR(), "12345678");
        try {
            model.editEmployer(dummyEmployerEdited, "123456789", "87654321", "87654321");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("Password does not match the current one.", errorMessage);
    }

    @Test
    void editEmployerWrongPasswordConfirmation() throws Exception {
        String errorMessage = "";
        Employer dummyEmployerEdited = dummyEmployer;
        model.registerAccountEmployer(dummyEmployerEdited, "12345678", "12345678");
        model.logInEmployer(dummyEmployerEdited.getCVR(), "12345678");
        try {
            model.editEmployer(dummyEmployerEdited, "12345678", "87654321", "876543210");
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        assertEquals("Passwords do not match", errorMessage);
    }


    @Test
    void editWorker() throws Exception {
        Worker dummyWorkerEdited = dummyWorker;
        model.registerAccountWorker(dummyWorkerEdited, "12345678", "12345678");
        model.logInWorker(dummyWorkerEdited.getCPR(), "12345678");
        dummyWorkerEdited.setFirstName("Kyle");
        model.editWorker(dummyWorkerEdited, "12345678");
        assertEquals(dummyWorkerEdited, model.getWorker());
    }

    @Test
    void editWorkerPassword() throws Exception {
        Worker dummyWorkerEdited = dummyWorker;
        model.registerAccountWorker(dummyWorkerEdited, "12345678", "12345678");
        model.logInWorker(dummyWorkerEdited.getCPR(), "12345678");
        model.editWorker(dummyWorkerEdited, "12345678", "87654321", "87654321");
        assertEquals(dummyWorkerEdited, model.getWorker());
    }

    @Test
    void editWorkerWrongCurrentPassword() throws Exception {
        Worker dummyWorkerEdited = dummyWorker;
        model.registerAccountWorker(dummyWorkerEdited, "12345678", "12345678");
        model.logInWorker(dummyWorkerEdited.getCPR(), "12345678");
        model.editWorker(dummyWorkerEdited, "123456789", "87654321", "87654321");
        assertEquals(dummyWorkerEdited, model.getWorker());
    }

    @Test
    void editWorkerWrongPasswordConfirmation() throws Exception {
        Worker dummyWorkerEdited = dummyWorker;
        model.registerAccountWorker(dummyWorkerEdited, "12345678", "12345678");
        model.logInWorker(dummyWorkerEdited.getCPR(), "12345678");
        model.editWorker(dummyWorkerEdited, "12345678", "87654321", "876543210");
        assertEquals(dummyWorkerEdited, model.getWorker());
    }


    @Test
    void getEmployer() {
    }

    @Test
    void getWorker() {
    }

    @Test
    void getJobById() {
    }

    @Test
    void getLicenseByNumber() {
    }

    @Test
    void getHoursWorkedThisMonth() {
    }

    @Test
    void logOutWorker() {
    }

    @Test
    void logOutEmployer() {
    }

    @Test
    void getWorkHistory() {
    }

    @Test
    void createWorkOffer() throws Exception {
        Job job = new Job("Work", "Work needed", 100, 1,
                LocalDateTime.of(2020, 05, 19, 6, 0, 0),
                LocalDateTime.of(2020, 05, 19, 14, 15, 0),
                new Address("Denmark", "Horsens", "Sundvej", "8700"), "pending",
                dummyEmployer);
        model.registerAccountEmployer(dummyEmployer, "12345678", "12345678");
        model.logInEmployer(dummyEmployer.getCVR(), "12345678");
        model.createWorkOffer(job);
    }

    @Test
    void createWorkOfferInvalidData() throws Exception {
        String errorMessage = "";
        Job job = new Job("Work", "Work needed", 100, 1,
                LocalDateTime.of(2020, 05, 19, 6, 0, 0),
                LocalDateTime.of(2020, 05, 19, 14, 15, 0),
                new Address("Denmark", "Horsens", "Sundvej", "8700"), "pending",
                dummyEmployer);
        model.registerAccountEmployer(dummyEmployer, "12345678", "12345678");
        model.logInEmployer(dummyEmployer.getCVR(), "12345678");
        try {
            model.createWorkOffer(job);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        assertEquals("All the fields must be filled", errorMessage);
    }

    @Test
    void cancelWorkerFromJob() {
    }

    @Test
    void cancelWorkOffer() {
    }

    @Test
    void updateWorkOffer() {
    }

    @Test
    void applyForJob() {
    }

    @Test
    void addLicense() {
    }

    @Test
    void deleteLicense() {
    }

    @Test
    void getLicenses() {
    }

    @Test
    void getEmployerJobs() {
    }

    @Test
    void getWorkerByJob() {
    }

    @Test
    void getJobs() {
    }

    @Test
    void getUpcomingJobs() {
    }
}