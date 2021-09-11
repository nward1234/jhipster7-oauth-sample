package com.mycompany.myapp.models;

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
public class Roles {

    private PayrollAdmin payroll_admin;

    public PayrollAdmin getPayroll_admin() {
        return payroll_admin;
    }

    public void setPayroll_admin(PayrollAdmin payroll_admin) {
        this.payroll_admin = payroll_admin;
    }

    @Override
    public String toString() {
        return "Roles [payroll_admin=" + payroll_admin + "]";
    }
}
