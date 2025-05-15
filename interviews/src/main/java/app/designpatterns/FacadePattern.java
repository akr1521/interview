package app.designpatterns;

class AuthService {
    public boolean authenticate(String userId, String password) {
        System.out.println("Authenticating user...");
        return true;
    }
}

class AccountService {
    public boolean checkBalance(String accountNumber, double amount) {
        System.out.println("Checking account balance...");
        return true;
    }

    public void debit(String accountNumber, double amount) {
        System.out.println("Debiting amount: $" + amount);
    }

    public void credit(String accountNumber, double amount) {
        System.out.println("Crediting amount: $" + amount);
    }
}

class NotificationService {
    public void notifyUser(String message) {
        System.out.println("Notification: " + message);
    }
}

class EmailService{

    public void  emailUser(String message){
        System.out.println( "Email sent at" +  System.currentTimeMillis());
    }
}

class TransactionLogger {
    public void log(String message) {
        System.out.println("Logging: " + message);
    }
}


class Facade{
     private AuthService authService ;



}

public class FacadePattern {
}
