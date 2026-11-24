
import java.util.ArrayList;

public class CompanyDAO {

    private ArrayList<Company> companies;

    
    public CompanyDAO() {
        companies = new ArrayList<>();
    }

    // Add a company
    public void addCompany(Company company) {
        companies.add(company);
        System.out.println("Company added successfully!");
    }

    
    public void displayCompanies() {

        if (companies.isEmpty()) {
            System.out.println("No companies found.");
            return;
        }

        for (Company company : companies) {

            System.out.println("Company ID: " + company.getCompanyId());
            System.out.println("Company Name: " + company.getCompanyName());
            System.out.println("Location: " + company.getLocation());
            System.out.println("Industry: " + company.getIndustry());
            System.out.println("Email: " + company.getEmail());

            System.out.println("-------------------------");
        }
    }

    
    public Company getCompanyById(int companyId) {

        for (Company company : companies) {

            if (company.getCompanyId() == companyId) {
                return company;
            }
        }

        return null;
    }
}

