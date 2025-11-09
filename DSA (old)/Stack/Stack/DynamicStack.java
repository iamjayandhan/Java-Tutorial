public class DynamicStack extends CustomStack{
    public DynamicStack(){  
        super(); //it will call CustomStack();
    }

    public DynamicStack(int size){  
        super(size); //it will call CustomStack(int size);
    }

    @Override
    public boolean push(int item){ 
        //this takes care of it being full
        if(this.isFull()){
            //double the array size 
            int temp[] = new int[data.length * 2];

            //copy all prev items in new data
            for(int i=0;i<data.length;i++){
                temp[i] = data[i];
            }
            data = temp;
        }

        //at this point, we know that array is not full!
        //insert item

        // data[++ptr] = item;
        // return true;

        //or

        // return super.push(item);

        //return this.push(item) //infinite loop! YOU KNOW WHY!
        //Using this.push(item) inside DynamicStack.push() creates a recursive call to the same method (DynamicStack.push()), leading to infinite recursion until a StackOverflowError occurs.
        //Essentially, this.push(item) means "call the current class's push method," which is the method you're already inside.


        // This explicitly calls the push method of the parent class CustomStack.
        // Since CustomStack.push() is not overridden in DynamicStack's push, it works as expected.
        return super.push(item);
    }
}
