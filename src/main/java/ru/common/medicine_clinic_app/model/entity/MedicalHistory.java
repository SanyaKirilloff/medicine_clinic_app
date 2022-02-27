package ru.common.medicine_clinic_app.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "medical_history")
public class MedicalHistory extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @Column(name = "doc_number", nullable = false, unique = true)
    private String docNumber;

    @CreationTimestamp
    @Column(name = "create_dttm", nullable = false)
    private LocalDateTime createDttm;

    @UpdateTimestamp
    @Column(name = "modify_dttm", nullable = false)
    private LocalDateTime modifyDttm;

    @Column(name = "doctor", nullable = false)
    private String doctor;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private MedicalHistory medicalHistory;

    public static MedicalHistory of(MedicalHistoryDto dto, PatientEntity patientEntity, MedicalHistory medicalHistoryParent) {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.patient = patientEntity;
        medicalHistory.docNumber = dto.getDocNumber();
        medicalHistory.doctor = dto.getDoctor();
        medicalHistory.diagnosis = dto.getDiagnosis();
        medicalHistory.medicalHistory = medicalHistoryParent;
        return medicalHistory;
    }

    public void update(MedicalHistoryDto dto, PatientEntity patientEntity, MedicalHistory medicalHistoryParent) {
        this.patient = patientEntity;
        this.docNumber = dto.getDocNumber();
        this.doctor = dto.getDoctor();
        this.diagnosis = dto.getDiagnosis();
        this.medicalHistory = medicalHistoryParent;
    }
}
