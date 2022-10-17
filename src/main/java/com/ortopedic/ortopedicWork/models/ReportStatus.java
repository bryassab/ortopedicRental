package com.ortopedic.ortopedicWork.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportStatus {

    private Integer Complete;
    private Integer Cancelled;
}
