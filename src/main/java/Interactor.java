import boundaries.Input;
import entities.*;

import java.math.BigDecimal;
import java.util.List;

public class Interactor implements Input {

  public void welcome(Customer customer){
    System.out.println("Welcome " + customer.getName());
  }

  public void input (){
    System.out.println("");
  }

  public void toRegister(){

  }

  public void deposit (Customer customer, BigDecimal amount){
    Account account = customer.getAccount();
    account.add(amount);
  }


  public void withdraw(Customer customer, BigDecimal amount) {
    Account account = customer.getAccount();
    account.subtract(amount);
  }

  public BigDecimal showBalance (Customer customer){
    Account account = customer.getAccount();

    return account.showBalance();
  }

  @Override
  public Customer toRegister(int id, String name, String street, int houseNumber, int postalCode, String city) {
    return new Customer(id, name, new Address(street, houseNumber, postalCode, city), BigDecimal.ZERO);
  }

  @Override
  public void transaction(Customer customer, BigDecimal amount, TransactionType transactionType) {
    if(transactionType == TransactionType.DEPOSIT){
      deposit(customer, amount);
    }
    if(transactionType == TransactionType.WITHDRAWAL){
      withdraw(customer, amount);
    }
  }

  @Override
  public List<Transaction> showTransactions(Customer customer) {
    return customer.getAccount().getTransactions().getTransactionList();
  }
}
