package com.example.springjpahello.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Types;

@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedStoredProcedureQuery(name = "Item.findItemById", procedureName = "findItemById", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "name", type = String.class) })
@NamedStoredProcedureQuery(name = "Item.ITEMNAME", procedureName = "ITEMNAME",resultClasses = {String.class}, parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name_in", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "name_out", type = String.class) })
@NamedStoredProcedureQuery(name = "Item.TESTIN", procedureName = "TESTIN", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name_in", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "name_out", type = String.class) })
@NamedStoredProcedureQuery(name = "Item.TESTIN1", procedureName = "TESTIN1", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name_in", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "price_out", type = Integer.class) })
@NamedStoredProcedureQuery(name = "Item.TESTIN2", procedureName = "TESTIN2", resultClasses = Item.class, parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name_in", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "item_out", type = void.class) })
@Entity
public class Item {
    @Id
    //@GeneratedValue
    private Integer id;
    private String name;
    private int price;
    private String name_out;
}
