package simplycodinghub.learnandroidapp.RecyclerViewTutorial;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetListResponse {
    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("job_img")
    @Expose
    private String jobImg;
    @SerializedName("job_title")
    @Expose
    private String jobTitle;
    @SerializedName("job_desc")
    @Expose
    private String jobDesc;
    @SerializedName("job_pay")
    @Expose
    private String jobPay;
    @SerializedName("job_payment_date")
    @Expose
    private String jobPaymentDate;
    @SerializedName("job_posted_on")
    @Expose
    private String jobPostedOn;
    @SerializedName("job_status")
    @Expose
    private String jobStatus;
    @SerializedName("job_city")
    @Expose
    private String jobCity;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobImg() {
        return jobImg;
    }

    public void setJobImg(String jobImg) {
        this.jobImg = jobImg;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobPay() {
        return jobPay;
    }

    public void setJobPay(String jobPay) {
        this.jobPay = jobPay;
    }

    public String getJobPaymentDate() {
        return jobPaymentDate;
    }

    public void setJobPaymentDate(String jobPaymentDate) {
        this.jobPaymentDate = jobPaymentDate;
    }

    public String getJobPostedOn() {
        return jobPostedOn;
    }

    public void setJobPostedOn(String jobPostedOn) {
        this.jobPostedOn = jobPostedOn;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobCity() {
        return jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }

}
