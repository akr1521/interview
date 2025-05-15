package app.designpatterns;


enum LogLevels{
        WARN (1),
    DEBUG(2),
    ERROR(3),
    INFO(4);
        private final int  value;

        LogLevels( int value){
            this.value =  value;
        }
    public int getValue() {
        return value;
    }

    //compare log levels
}

abstract class Logger{
    protected  Logger nextLogger;
    protected LogLevels  logLevels;

    public Logger( LogLevels logLevels){
             this.logLevels = logLevels ;
    }

    public void setNextLogger (Logger logger){
             this.nextLogger = logger;
    }

    public void logMessage(  Logger logger ,String message){
              if ( this.nextLogger !=  null) {
                  this.nextLogger = logger;
                    return;
              }

                  writeMessage(   message);
    }

    abstract  void writeMessage ( String message);

}


// Concrete Handlers
class DebugLogger extends Logger {

    public DebugLogger(LogLevels level) {
        super(level);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("Debug: " + message);
    }
}


class  WarnLogger extends Logger {

    public WarnLogger (LogLevels logLevels) {
        super(logLevels);
    }

    @Override
    void writeMessage (String message) {
              if  ( nextLogger == null ){
                      System.out.println( " Message :A "  + message);
              }
    }
}

class InfoLogger extends Logger {

    public InfoLogger(LogLevels level) {
        super(level);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("Info: " + message);
    }
}

class ErrorLogger extends Logger {

    public ErrorLogger(LogLevels level) {
        super(level);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("Error: " + message);
    }
}

public class ChainOR {

    public static void main (String args[]){
         initLogger();
         
    }

    private static void initLogger () {
        Logger debugLogger = new DebugLogger(LogLevels.DEBUG);
        Logger infoLogger = new InfoLogger(LogLevels.INFO);
        Logger errorLogger = new ErrorLogger(LogLevels.ERROR);
        debugLogger.setNextLogger( infoLogger);
        infoLogger.setNextLogger(errorLogger);
        Logger logger  = debugLogger ;
        logger.logMessage(logger, "This is a debug message.");

    }
}


