package Payment.components.test.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "BusinessContact")
public class BusinessContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "first_name")
    @NotBlank(message = "First name should not be blank")
    //@Size
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name should not be blank")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "company")
    private String company;

    @Column(name = "business_title")
    private String businessTitle;

    @Column(name = "website_url")
    private String websiteUrl;

    public void setCompany(String company) {
        this.company = company;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCompany() {
        return company;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String mobilePhone) {
        this.phone = mobilePhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
