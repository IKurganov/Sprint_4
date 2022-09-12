package model;

public class UserAndHisWishes {
    private RentInformation rentInformation;
    private UserPersonalData userPersonalData;
    private boolean isHeWannaUseUpperButton;

    public UserAndHisWishes(UserPersonalData userPersonalData, RentInformation rentInformation, boolean isHeWannaUseUpperButton) {
        this.rentInformation = rentInformation;
        this.userPersonalData = userPersonalData;
        this.isHeWannaUseUpperButton = isHeWannaUseUpperButton;
    }

    public RentInformation getRentInformation() {
        return rentInformation;
    }

    public boolean isHeWannaUseUpperButton() {
        return isHeWannaUseUpperButton;
    }

    public UserPersonalData getUserPersonalData() {
        return userPersonalData;
    }
}