package com.epam.ta.framework.ui.business_objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemBO {
    protected String summary;
    protected String id;
    protected User creator;
    protected User actionPerfomer;
    protected String currency;
    protected String projectName;
    //todo У тебя здесь начинается солянка. Классу должны принадлежать только к нему относящиеся поля и методы. Это ведь и есть принцип ООП абстракция
    private Date currentDate = new Date();//todo Это поле - не лучшая идея. Понимаешь почему?
    private DateFormat inputFormat = new SimpleDateFormat("MM/dd/yy");//todo Для хранения форматов даты нужно использовать отдельный утильный класс
    private DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private long msDay = 7 * 24 * 60 * 60 * 1000;//todo Аналогично. Используй отдельный класс

    //todo Замечание аналогично BusinessTripBO - убирай хардкод из конструктора.
    //todo Вот как раз отличный шанс использовать один из порождающих шаблонов проектирования (не скажу какой, подумай сам)
    public ItemBO() {
        this.summary = "Item is created by Selenium " + sdf.format(currentDate);
        this.actionPerfomer = new User();
        this.currency = "KZT";
        this.projectName = "ENRC-TRD";
    }

    public User getActionPerfomer() {
        return actionPerfomer;
    }

    public void setActionPerfomer(User actionPerfomer) {
        this.actionPerfomer = actionPerfomer;
    }

    public String getSummary() {
        return summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    //todo Все методы ниже - утильные и общие. Им не место здесь
    public Date getCurrentDate() {
        return currentDate;
    }

    public DateFormat getInputFormat() {
        return inputFormat;
    }

    public DateFormat getSdf() {
        return sdf;
    }

    public long getMsDay() {
        return msDay;
    }
}
