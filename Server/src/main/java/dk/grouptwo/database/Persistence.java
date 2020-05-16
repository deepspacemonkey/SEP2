package dk.grouptwo.database;

import dk.grouptwo.model.objects.*;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Persistence
{
 //Adding removing, applying for jobs*******
  void addJobToDB(Job job);
  void removeJobFromDB(Job job);

  // maybe Worker instead of void

  void  applyForJob(Job job,Worker worker);



  void updateJob(Job job);


 //Login checks
 Employer loginEmployer(String CVR,String password);
 Worker loginWorker(String CPR,String password);

 //Creating accounts**** //TODO needs testing
  void createEmployerAccount(Employer employer, String password)
      throws SQLException;
  void createWorkerAccount(Worker worker,String password);

  ArrayList<Job> getAllJobsFromDB();

  ArrayList<Job> getAllJobHistoryWorkerFromDB(Worker worker);
  ArrayList<Job> getAllJobHistoryEmployerFromDB(Employer employer);
  ArrayList<Job> getUpcomingJobsWorkerFromDB(Worker worker);
  ArrayList<Job> getCurrentEmployerJobs(Employer employer);

  ArrayList<Worker> getAllAppliedWorkers(Job job);
  ArrayList<Worker> getAllAcceptedWorkers(Job job);

 void addLicense(License license, Worker worker) ;

 void removeLicense(License license) ;

  int insertAddress(Address address);

  //TODO THIS IS FOR TESTING PURPOSES:

 ArrayList<Address> getAllAddress();

 void cancelWorkerFromJob(Job job, Worker worker);

 void editEmployer(Employer employer, String password);




  void editEmployer(Employer employer, String password, String newPassword);


  void editWorker(Worker worker, String password) ;


  void editWorker(Worker worker, String password, String newPassword) ;

 void addSelectedWorker(Job job, Worker worker);

 void removeSelectedWorker(Job job, Worker worker);
}
