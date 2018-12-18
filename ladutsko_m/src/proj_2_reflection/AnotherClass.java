package proj_2_reflection;

final class AnotherClass {

    @Inj("some value")
    private SomeClass someClass;
    private AnotherClass(){}
    public SomeClass getSomeClass(){
        return someClass;
    }
}
