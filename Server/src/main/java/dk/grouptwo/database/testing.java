package dk.grouptwo.database;

import dk.grouptwo.model.objects.Address;
import dk.grouptwo.model.objects.Employer;

import java.sql.SQLException;

public class testing
{
  public static void main(String[] args) throws SQLException
  {
    /*DatabaseConnection.getInstance().connect();*/
    EvenMoreTesting testing = new EvenMoreTesting();
    Address address = new Address("mars","8700");
    Address insertAddress = new Address("denmark","Horsens","bilka 92","8700");
    Employer employer = new Employer("test@gmail.com","50505050",address,"518","blyat");
    System.out.println("Testing : ");
    /*testing.insertTest(employer,"gucci");*/
    System.out.println("tested...");

    System.out.println(Integer.parseInt(insertAddress.getZip()));
    System.out.println(String.valueOf(insertAddress.getZip()));
    System.out.println("Testing adding address:");
    testing.insertAddressTest(insertAddress);
    System.out.println("Testing done..");
  }
}