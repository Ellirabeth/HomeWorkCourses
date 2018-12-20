package proj_2_reflection;

final class Main {
    public static void main(String[] args){

        try {
            AnotherClass anotherClass = InjectingClass.init();
            System.out.printf("Value: " + anotherClass.getSomeClass().getValue());
        }
        catch (Exception ex){
            System.out.printf(ex.getMessage() + "\n");
        }
    }
}
