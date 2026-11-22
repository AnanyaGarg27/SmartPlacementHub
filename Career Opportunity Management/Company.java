
public class Company {
    private int companyId;
    private String companyName;
    private String location;
    private String industry;
    private String email;

    public Company(int companyId, String companyName,
            String location, String industry, String email) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.location = location;
        this.industry = industry;
        this.email = email;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public String getIndustry() {
        return industry;
    }

    public String getEmail() {
        return email;
    }
}
