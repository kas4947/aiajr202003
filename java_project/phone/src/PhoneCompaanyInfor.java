public class PhoneCompaanyInfor extends PhoneInfor {

    String name;
    String phoneNumber;
    String address;
    String email;

    String company;


    public PhoneCompaanyInfor(String name, String phoneNumber, String birthday, String address, String email, String company) {
        super(name, phoneNumber, birthday);
        this.address = address;
        this.email = email;
        this.company = company;
    }

    public PhoneCompaanyInfor(String name, String phoneNumber, String address, String email, String company) {
        super(name, phoneNumber);
        this.address = address;
        this.email = email;
        this.company = company;
    }
}
