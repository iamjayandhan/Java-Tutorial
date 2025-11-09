public class DynamicQueue extends CustomQueue{
    public DynamicQueue(){
        super();
    }   

    public DynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item){ 
        //this takes care of it being full
        if(this.isFull()){
            //double the array size 
            int temp[] = new int[data.length * 2];

            //copy all prev items in new data
            for(int i=0;i<data.length;i++){
                temp[i] = data[i];
            }
            end = data.length-1;
            data = temp;
        }

        //at this point, we know that array is not full!
        //insert item
        return super.insert(item);
    }
}
