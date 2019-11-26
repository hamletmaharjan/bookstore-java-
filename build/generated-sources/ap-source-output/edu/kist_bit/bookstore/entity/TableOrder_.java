package edu.kist_bit.bookstore.entity;

import edu.kist_bit.bookstore.entity.TableBook;
import edu.kist_bit.bookstore.entity.TableCustomer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T17:01:48")
@StaticMetamodel(TableOrder.class)
public class TableOrder_ { 

    public static volatile SingularAttribute<TableOrder, Integer> zipCode;
    public static volatile SingularAttribute<TableOrder, String> city;
    public static volatile SingularAttribute<TableOrder, TableCustomer> customerId;
    public static volatile SingularAttribute<TableOrder, String> addressLine1;
    public static volatile SingularAttribute<TableOrder, String> addressLine2;
    public static volatile SingularAttribute<TableOrder, Long> oId;
    public static volatile SingularAttribute<TableOrder, String> state;
    public static volatile SingularAttribute<TableOrder, TableBook> bookId;

}