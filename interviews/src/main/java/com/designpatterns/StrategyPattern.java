package com.designpatterns;

import javax.naming.OperationNotSupportedException;

interface PaymentStrategy {
    void processPayment(double amount);
}


class PaymentContext{
     private  PaymentStrategy paymentStrategy;
     public PaymentContext (PaymentStrategy paymentStrategy){
             this.paymentStrategy = paymentStrategy;

     }
     public void executePayment( double amount){
            this.paymentStrategy.processPayment(amount);
     }
}

class CreditCardPayment  implements PaymentStrategy{
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount +
                " using card number: " + cardNumber +
                ", expiry: " + expiryDate + ", cvv: " + cvv);

    }
}


class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount +
                " using email: " + email);
        // Logic to interact with PayPal API
    }
}

class GooglePayPayment implements PaymentStrategy {
    private String googlePayToken;

    public GooglePayPayment(String token) {
        this.googlePayToken = token;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Google Pay payment of $" + amount + " using token: " + this.googlePayToken);

    }
}

public class StrategyPattern {


    public static void main(String args[]){
        PaymentGateway paymentGateway = new PaymentGateway();
        try {
            paymentGateway.processPayment( "credit_card", new String[]{
                    "1234-5678-9012-3456", "12/24", "123"
            }, 100);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}


class PaymentGateway{
    PaymentStrategy paymentStrategy;
    PaymentContext paymentContext;
    public void  processPayment(String paymentMethod ,String[] paymentdetails ,double amount) throws OperationNotSupportedException {
        if (paymentMethod.equalsIgnoreCase("credit_card")){
                    if  ( paymentdetails.length != 3){
                            throw new OperationNotSupportedException("Provide all the required card details");
                    }
            paymentStrategy = new CreditCardPayment( paymentdetails[0], paymentdetails[1], paymentdetails[2]);
        }else if ( paymentMethod.equalsIgnoreCase( "paypal")){
                    if( paymentMethod.length() == 1){
                        paymentStrategy = new PayPalPayment( paymentdetails[0]);
                    }
        }
        else if (paymentMethod.equalsIgnoreCase( "googlePay")){
            if( paymentMethod.length() == 1){
                paymentStrategy = new GooglePayPayment( paymentdetails[0]);
            }
        }else {
            throw new RuntimeException( "Invalid Payment method: ");
        }
        paymentContext =  new PaymentContext( paymentStrategy);
        paymentContext.executePayment( amount);
    }
}

class BankTransferPayment implements PaymentStrategy {
    private String accountNumber;
    private String bankCode;

    public BankTransferPayment (String accountNumber, String bankCode) {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
    }

    @Override
    public void processPayment (double amount) {
        System.out.println("Processing bank transfer payment of $" + amount + " from account: " + accountNumber + ", bank code: " + bankCode);
        // Logic for bank transfer

    }
}