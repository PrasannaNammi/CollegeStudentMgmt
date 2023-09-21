package collegemanagement.customexceptions;

public class IdNotFoundException extends  RuntimeException{

    private String message;
//    private String code;

    public IdNotFoundException(String message ) {
        this.message = message;
//        this.code = code;
    }

    public IdNotFoundException() {
    }
}
