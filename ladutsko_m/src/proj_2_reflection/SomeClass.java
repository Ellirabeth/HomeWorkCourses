package proj_2_reflection;

final class SomeClass {

    private String value;
    private SomeClass(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
