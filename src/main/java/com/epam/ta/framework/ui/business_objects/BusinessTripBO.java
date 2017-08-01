package com.epam.ta.framework.ui.business_objects;

//todo Чем обусловлено данное наследование? Есть еще какие-то классы, которые могли бы унаследоваться от ItemBO?
//todo Лучше наименования давать без лишнего, типа BO. А просто - Item, BusinessTrip.
public class BusinessTripBO extends ItemBO{
    private Integer estimatedBudget;
    //todo Почему формат даты выбран как стринг? Практичнее было бы хранить дату в формате даты -->
    //todo и уже по потребности переводить ее в строку. Так ей легче можно будет оперировать в случае чего
    private String plannedStartDate;
    private String plannedEndDate;
    private String locationFrom;
    private String country;
    private String destinationCity;
    private String destinationAddress;
    private String description;

    //todo Убирай весь хардкод из конструктора. Если нужно установить какие-то значения, то передавай из снаружи как параметры
    public BusinessTripBO() {
        super();
        this.estimatedBudget = 200000;
        this.plannedStartDate = getInputFormat().format(getCurrentDate());
        this.plannedEndDate = getInputFormat().format(getCurrentDate().getTime() + getMsDay());
        this.locationFrom = "Karaganda";
        this.country = "Belarus";
        this.destinationCity = "Minsk";
        this.destinationAddress = "Minsk, Lenin street";
        this.description = "Travel to " + destinationCity + " " + getSdf().format(getCurrentDate());
    }

    public Integer getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(Integer estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public String getPlannedStartDate() {
        return plannedStartDate;
    }

    public String getPlannedEndDate() {
        return plannedEndDate;
    }

    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
