package project;
public class ATM {
    private double balance=0;
    String list[]=new String[5];
    int counter  = 0;
    int iter = 0;

    public double inquireBalance(){
      
        if(counter > 4){
            addAction("Get Current Balance");
            iter = 4;
        }
        else{
            list[counter]="Get Current Balance";
            iter = counter;
            System.out.println(list[counter] + counter);
            counter++;
           
        }
         
        return balance;
    }
    public double getBalance() {
       
        return balance;
    }
    
    public void withDraw(double amount){
            balance = balance - amount;
            
            if(counter > 4 ){
               addAction("Withdraw");
               iter =4;
               
            }
            else{
                list[counter]="Withdraw";
                iter = counter;
                System.out.println(list[counter] + counter);
                counter++;
                
            }
    }
    public void deposit(double amount){
         balance = balance + amount;
        
        if(counter >4){
           addAction("deposit");
           iter =4;
           
        }
        else{
            list[counter]="deposit";
            iter = counter;
            System.out.println(list[counter] +counter);
            counter++;
        }
       
    }
    public void addAction(String x){
        int i = 0;
        while(i < (list.length - 1)) {                
            list[i] = list[++i];
         }
        list[4] = x;
    }
    public String next(){
       if(iter == 4){
           return "no next";
       }
       return( list[++iter]);
    }
    public String prev(){
       if(iter == 0){
           return "no prev";
       }
       return( list[--iter]);
    }

    
    
}
