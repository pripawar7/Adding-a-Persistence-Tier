# Adding-a-Persistence-Tier

For this lab, you will add a Mocked DAO to simulate the database tier, add some tests and a JUnit dd an
Aspect class to get practice with AOP.
1. Use STS for this lab. Do not import your Eclipse project into STS.
2. Create a new Spring Utility Project (as demo’d in class). Copy over the pom.xml file from the
Week5 sample project. Create the necessary packages you will need in the project.

Add an Account class
The Account class will hold data about how much a customer owes. An account has properties for
a) Account id (for our purposes, we will use the student id as the account id)
b) Balance due
c) Date due (use the Date class)

Write a DAO Class for Account.
It should have the following functionality:
1. A method to create a new Account for a student (the student id should be a parameter). The
initial balance should be set to $0.00. In a real database implementation, this method would
insert a new row in the Account table and return an Account object representing what is stored
in the table. For the Mocked DAO, create a new Account object in your data structure and
return the Account object that you have created.
2. A method that given an account id, retrieves the balance
3. A method that adds an amount to the current balance -- Given an account id and an amount to
add
4. A method that retrieves a list of account ids that have overdue balances (an overdue balance is
one where the balance is greater than 0.00 and the current date is after the due date
Use a mocked implementation for this lab. You will later add a JDBC implementation (not part of this
lab). 

Modifications to the Payment Service.
Modify one of your PaymentService implementations (makePayment() method ):
1. Add the as a parameter to the makePayment() method amount being paid – you will also need
to change the interface to reflect this change.
2. Make changes so that the payment will fail in some cases (to simulate real-world situations).
a) Invalid credit card number. If the credit card number is not 15 digits or contains something
other than a digit then throw an Exception
b) Payment authorization failed. To simulate this you could simply have all credit card
numbers that start with 5 fail (rejected by the credit card company). Throw an exception
(different than the one in item a) for payment authorization failures.
If payment is successful, update the student’s account balance (use the AccountDao to do this). The
AccountDao can be injected into the PaymentService.

Add JUnit tests
Add tests for your PaymentService and AccountDao classes. Specifically, have:
a) Tests for the methods in AccountDao
b) Tests that failures in the PaymentService are properly handled (exceptions thrown)
c) Tests for a successful payment in the PaymentService properly updates the student’s account.

Write a small application
This can be reused from the previous lab. Create a client application with a main() method to test your
StudentCheckoutService:
1. Lookup a StudentCheckoutService bean from the Spring container.
2. Write a method (different from main()) that will create a Student object
3. Write a method (different from main()) that will create a list of Course objects
4. Call the checkout() method of the student checkout service by providing the student object, a
list of courses and a credit card number.
5. Lookup the new student balance after doing the checkout (you can use an AccountDao object to
do this). 

Add an Aspect class (AOP)
Add an Aspect class that should include Before advice, After Throwing advice, and Around advice. It
doesn’t really matter what the advice does, but use a Logger so you can tell when the advice is called.
You can test that your advice is getting called when running the application in the step above. 
