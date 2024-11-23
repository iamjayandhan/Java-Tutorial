class GenericData<T>{
    private T data;

    public GenericData(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }
}

class GenericExample{
    public static void main(String[] args) {
        GenericData<Integer> intData = new GenericData<Integer>(10);
        System.out.println(intData.getData());

        GenericData<String> stringData = new GenericData<String>("Hello");
        System.out.println(stringData.getData());
    }
}