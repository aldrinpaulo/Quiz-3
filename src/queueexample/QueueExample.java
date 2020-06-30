
package queueexample;

import java.util.logging.Level;
import java.util.logging.Logger;
import singlylinkedlist.SNode;


public class QueueExample {

    
    public static void main(String[] args) {

        // TODO code application logic here
        Customer c1 = new Customer(11, "John");
        Customer c2 = new Customer(22, "Dominique");
        Customer c3 = new Customer(33, "Kyle");
        Customer c4 = new Customer(44, "Shaun");
        Customer c5 = new Customer(55, "Jerson");

        SNode<Customer> customer1 = new SNode<>(c1, null);
        SNode<Customer> customer2 = new SNode<>(c2, null);
        SNode<Customer> customer3 = new SNode<>(c3, null);
        SNode<Customer> customer4 = new SNode<>(c4, null);
        SNode<Customer> customer5 = new SNode<>(c5, null);
               
       QueueList<SNode> transaction = new QueueList<>();
        transaction.enqueue(customer1);
        transaction.enqueue(customer2);
        transaction.enqueue(customer3);
        transaction.enqueue(customer4);
        transaction.enqueue(customer5);
      
        
        try {
            displayTransactions(transaction);
            transaction.dequeue();
            System.out.println("\nAfter Dequeue");
            
            displayTransactions(transaction);
            
            transaction.dequeue();
            System.out.println("\nAfter Dequeue");
            displayTransactions(transaction);
          
            
            
        } catch (EmptyQueueException ex) {
            Logger.getLogger(QueueExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void displayTransactions(QueueList<SNode> queueList ) throws EmptyQueueException{
        SNode<Customer> temp = queueList.first();
        for(int i = 0; i < queueList.size(); i++) {
            System.out.println("Transaction No." + (i + 1) + ": " + temp.getElement().getName() +
                   ",Customer ID: " + temp.getElement().getCustomerID());
        temp = temp.getNext();
    }
    }
}


 
