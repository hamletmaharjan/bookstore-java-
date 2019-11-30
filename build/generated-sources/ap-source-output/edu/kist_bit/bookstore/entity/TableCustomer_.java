package edu.kist_bit.bookstore.entity;

import edu.kist_bit.bookstore.entity.TableCart;
import edu.kist_bit.bookstore.entity.TableOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-30T16:32:13")
@StaticMetamodel(TableCustomer.class)
public class TableCustomer_ { 

    public static volatile SingularAttribute<TableCustomer, String> cUsername;
    public static volatile SingularAttribute<TableCustomer, String> cPhone;
    public static volatile SingularAttribute<TableCustomer, String> cPassword;
    public static volatile SingularAttribute<TableCustomer, String> cName;
    public static volatile SingularAttribute<TableCustomer, String> cEmail;
    public static volatile ListAttribute<TableCustomer, TableOrder> tableOrderList;
    public static volatile ListAttribute<TableCustomer, TableCart> tableCartList;
    public static volatile SingularAttribute<TableCustomer, Long> cId;

}