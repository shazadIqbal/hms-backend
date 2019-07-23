package com.example.test.DTO;

import java.util.List;

public class DashboardReportDTO {

    List<DashboardResponseDTO> receivedAmount;

    List<DashboardResponseDTO> dues;

    List<DashboardResponseDTO> totalAmount;

    public DashboardReportDTO() {
    }

    public DashboardReportDTO(List<DashboardResponseDTO> receivedAmount, List<DashboardResponseDTO> dues, List<DashboardResponseDTO> totalAmount) {
        this.receivedAmount = receivedAmount;
        this.dues = dues;
        this.totalAmount = totalAmount;
    }

    public List<DashboardResponseDTO> getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(List<DashboardResponseDTO> receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public List<DashboardResponseDTO> getDues() {
        return dues;
    }

    public void setDues(List<DashboardResponseDTO> dues) {
        this.dues = dues;
    }

    public List<DashboardResponseDTO> getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(List<DashboardResponseDTO> totalAmount) {
        this.totalAmount = totalAmount;
    }

}
