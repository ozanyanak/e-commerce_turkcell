package kodllama.io.ecommerce.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private  int quantify;
    private double price;
    private boolean status;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
