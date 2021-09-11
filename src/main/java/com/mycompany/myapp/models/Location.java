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
public class Location {

    private Long id;

    private String street_1;

    private String street_2;

    private String city;

    private String state;

    private String zip;

    private String country;

    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet_1() {
        return street_1;
    }

    public void setStreet_1(String street_1) {
        this.street_1 = street_1;
    }

    public String getStreet_2() {
        return street_2;
    }

    public void setStreet_2(String street_2) {
        this.street_2 = street_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return (
            "Location [id=" +
            id +
            ", street_1=" +
            street_1 +
            ", street_2=" +
            street_2 +
            ", city=" +
            city +
            ", state=" +
            state +
            ", zip=" +
            zip +
            ", country=" +
            country +
            ", active=" +
            active +
            "]"
        );
    }
}
