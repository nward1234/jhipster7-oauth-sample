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
public class Company {

    private Long id;

    private String uuid;

    private String name;

    private String trade_name;

    private String tier;

    private List<Location> locations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return (
            "Company [id=" +
            id +
            ", uuid=" +
            uuid +
            ", name=" +
            name +
            ", trade_name=" +
            trade_name +
            ", tier=" +
            tier +
            ", locations=" +
            locations +
            "]"
        );
    }
}
