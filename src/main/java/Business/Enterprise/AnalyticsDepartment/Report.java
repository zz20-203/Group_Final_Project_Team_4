/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.AnalyticsDepartment;

import java.util.Date;

/**
 *
 * @author Luciela us Biktria
 */
public class Report {
    private String content;
    private Date timestamp;
    
    public Report(String content) {
        this.content = content;
        this.timestamp = new Date();
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return timestamp.toString();
    }
}