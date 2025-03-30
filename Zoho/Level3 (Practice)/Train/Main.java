public class Main {

    public static void main(String[] args) {

        BookTrain bookTrain = new BookTrain();

        bookTrain.book('A' , 'E' , 8);
        bookTrain.book('A' , 'E' , 2);
        bookTrain.cancel(1 , 5);
        
        
        bookTrain.cancel(1 , 3);
        bookTrain.cancel(2 , 2);
        bookTrain.book('A' , 'C' , 8);

        bookTrain.book('C','E',8);
        bookTrain.book('A','E',2);
        
        
        bookTrain.book('C','D',2);
        bookTrain.cancel(3 , 8);       
       
        
        bookTrain.cancel(4 , 8);
        

        bookTrain.book('C','E',3);
        bookTrain.print();


    }
}
