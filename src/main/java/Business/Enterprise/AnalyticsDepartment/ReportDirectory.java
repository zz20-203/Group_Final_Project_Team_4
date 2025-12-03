/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.AnalyticsDepartment;

import java.util.ArrayList;

/**
 *
 * @author Luciela us Biktria
 */
public class ReportDirectory {
    private ArrayList<Report> reports;
    
    public ReportDirectory() {
        reports = new ArrayList<>();
    }

    public ArrayList<Report> getReports() {
        return reports;
    }
    
    public void addReport(Report r) {
        reports.add(r);
    }
}