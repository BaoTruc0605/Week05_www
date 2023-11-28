package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.enums;

import lombok.Getter;

@Getter
public enum AccountType {
    CANDIDATE(0), COMPANY(1);
    private int value;
    AccountType(int value){

    }
}
