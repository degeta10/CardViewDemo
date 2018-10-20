package in.brainwired.www.formtest;

public class Form {
    public String product_name;
    public Integer company_id;

    public Form(String product_name, Integer company_id) {
        this.product_name = product_name;
        this.company_id = company_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public Integer getCompany_id() {
        return company_id;
    }


}
