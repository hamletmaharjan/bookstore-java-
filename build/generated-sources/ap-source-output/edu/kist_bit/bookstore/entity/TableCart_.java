package edu.kist_bit.bookstore.entity;

import edu.kist_bit.bookstore.entity.TableBook;
import edu.kist_bit.bookstore.entity.TableCustomer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-26T21:25:57")
@StaticMetamodel(TableCart.class)
public class TableCart_ { 

    public static volatile SingularAttribute<TableCart, Long> caId;
    public static volatile SingularAttribute<TableCart, TableCustomer> customerId;
    public static volatile SingularAttribute<TableCart, TableBook> bookId;

}