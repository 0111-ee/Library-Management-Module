package Alpha;

class DiscussionRoom extends FacilitiesManagement {
    public DiscussionRoom(int facilityID, String facilityName, String facilityPlaces, String facilityAvailability) {
        super(facilityID, facilityName, "Discussion Room", facilityPlaces, facilityAvailability);
    }

    @Override
    public String getFacilityType() {
        return "Discussion Room";
    }

}

class PresentationRoom extends FacilitiesManagement {
    public PresentationRoom(int facilityID, String facilityName, String facilityPlaces, String facilityAvailability) {
        super(facilityID, facilityName, "Presentation Room", facilityPlaces, facilityAvailability);
    }

    @Override
    public String getFacilityType() {
        return "Presentation Room";
    }
}
                
class IndividualStudyRoom extends FacilitiesManagement {
    public IndividualStudyRoom(int facilityID, String facilityName, String facilityPlaces, String facilityAvailability) {
        super(facilityID, facilityName, "Individual Study Room", facilityPlaces, facilityAvailability);
    }

    @Override
    public String getFacilityType() {
        return "Individual Study Room";
    }
}

class PublicStudyRoom extends FacilitiesManagement {
    public PublicStudyRoom(int facilityID, String facilityName, String facilityPlaces, String facilityAvailability) {
        super(facilityID, facilityName, "Public Study Room", facilityPlaces, facilityAvailability);
    }

    @Override
    public String getFacilityType() {
        return "Public Study Room";
    }
}