class Human implements java.io.Serializable {
    private String name;
    public Human(){
    }
    public Human(String name){
        this.name = name;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
}

