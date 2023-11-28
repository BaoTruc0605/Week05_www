package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models;
import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor

@NoArgsConstructor
@Entity

@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(nullable = false,columnDefinition = "smallint(6)")
    private CountryCode country;
    @Column(nullable = false,columnDefinition = "varchar(7)")
    private String zipcode;
    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String number;
    @Column(nullable = false,columnDefinition = "varchar(50)")
    private String city;
    @Column(name = "street",nullable = false,columnDefinition = "varchar(150)")
    private String Street;
    @OneToOne(mappedBy = "address")
    private Candidate candidate;
    @OneToOne(mappedBy = "address")
    private Company company;

    public Address(CountryCode country, String zipcode, String number, String city, String street) {
        this.country = country;
        this.zipcode = zipcode;
        this.number = number;
        this.city = city;
        Street = street;
    }

    public Address(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country=" + country +
                ", zipcode='" + zipcode + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", Street='" + Street + '\'' +
                '}';
    }
}
