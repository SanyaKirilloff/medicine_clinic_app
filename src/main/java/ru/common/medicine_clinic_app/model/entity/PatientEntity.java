package ru.common.medicine_clinic_app.model;

import lombok.Data;
import ru.common.medicine_clinic_app.model.enumeration.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name ="patient")

public class PatientEntity extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "birthday_dt", nullable = false)
    private LocalDate birthdayDt;

    @Column(name = "birth_place", nullable = false)
    private String birthPlace;

    @Column(name = "registration", nullable = false)
    private String registration;

    @Column(name = "passport_series", nullable = false)
    private Integer passportSeries;

    @Column(name = "passport_number", nullable = false)
    private Integer passportNumber;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT", name = "another_document")
    private String anotherDocument;

    public static PatientEntity of(PatientDto dto) {
        PatientEntity patient = new PatientEntity();
        patient.name = dto.getName();
        patient.gender = dto.getGender();
        patient.age = dto.getAge();
        patient.city = dto.getCity();
        patient.address = dto.getAddress();
        patient.birthdayDt = dto.getBirthdayDt();
        patient.birthPlace = dto.getBirthPlace();
        patient.registration = dto.getRegistration();
        patient.passportSeries = dto.getPassportSeries();
        patient.passportNumber = dto.getPassportNumber();
        patient.phoneNumber = dto.getPhoneNumber();
        patient.anotherDocument = dto.getAnotherDocument();
        return patient;
    }

    public void update(PatientDto dto) {
        this.name = dto.getName();
        this.gender = dto.getGender();
        this.age = dto.getAge();
        this.city = dto.getCity();
        this.address = dto.getAddress();
        this.birthdayDt = dto.getBirthdayDt();
        this.birthPlace = dto.getBirthPlace();
        this.registration = dto.getRegistration();
        this.passportSeries = dto.getPassportSeries();
        this.passportNumber = dto.getPassportNumber();
        this.phoneNumber = dto.getPhoneNumber();
        this.anotherDocument = dto.getAnotherDocument();
    }
}

}
