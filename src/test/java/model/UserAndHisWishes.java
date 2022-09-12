package model;

public class UserAndHisWishes {
    private RentInformation rentInformation;
    private UserPersonalData userPersonalData;

    public UserAndHisWishes(UserPersonalData userPersonalData, RentInformation rentInformation) {
        this.rentInformation = rentInformation;
        this.userPersonalData = userPersonalData;
    }

    public RentInformation getRentInformation() {
        return rentInformation;
    }

    public UserPersonalData getUserPersonalData() {
        return userPersonalData;
    }
}