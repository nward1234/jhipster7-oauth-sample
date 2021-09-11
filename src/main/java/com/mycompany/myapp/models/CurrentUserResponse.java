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
public class CurrentUserResponse {

    private Long id;

    private String uuid;

    private String email;

    private Roles roles;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "CurrentUserResponse [id=" + id + ", uuid=" + uuid + ", email=" + email + ", roles=" + roles + "]";
    }
}
