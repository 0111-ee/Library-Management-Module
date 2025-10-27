package Alpha;

public class Member {

    private int memberID;
    private String memberName;
    private char gender;
    private String contactNumber;

    public Member(int memberID, String memberName, char gender, String contactNumber) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    // Getters
    public int getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public char getGender() {
        return gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    // Setters
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
