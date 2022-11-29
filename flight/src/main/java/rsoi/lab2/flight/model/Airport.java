package rsoi.lab2.flight.model;

import javax.persistence.*;

@Entity
@Table(name = "AIRPORT")
public class Airport {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "CITY", nullable = false)
    private String city;

    public Airport() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
