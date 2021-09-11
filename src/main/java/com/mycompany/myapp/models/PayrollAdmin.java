package com.mycompany.myapp.models;

import java.util.List;

/*
 * {
    "id": 7757869450533269,
    "uuid": "1f3689bf-2208-4435-b3ce-3ac84e7feca1",
    "email": "nolanward@turtlefuse.com",
    "roles": {
        "payroll_admin": {
            "companies": [
                {
                    "id": 7756341741017369,
                    "uuid": "dbc28a7e-d1c7-4822-9997-5a65ddd371ea",
                    "name": "turtlefuse",
                    "trade_name": "",
                    "tier": "concierge",
                    "locations": [
                        {
                            "id": 7757727717124916,
                            "street_1": "912 Silver St.",
                            "street_2": "Suite 1966",
                            "city": "San Francisco",
                            "state": "CA",
                            "zip": "94107",
                            "country": "USA",
                            "active": true
                        }
                    ]
                }
            ]
        }
    }
}
 */
public class PayrollAdmin {

    private List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "PayrollAdmin [companies=" + companies + "]";
    }
}
