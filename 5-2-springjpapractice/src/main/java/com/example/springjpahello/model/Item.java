package com.example.springjpahello.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedStoredProcedureQuery(name = "Item.findItemById", procedureName = "findItemById", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "name", type = String.class) })
@Entity
public class Item {
    @Id
    //@GeneratedValue
    private Integer id;
    @Column
    private String name;
    private int price;

}
