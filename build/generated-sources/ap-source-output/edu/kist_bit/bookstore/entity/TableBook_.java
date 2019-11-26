package edu.kist_bit.bookstore.entity;

import edu.kist_bit.bookstore.entity.TableAuthor;
import edu.kist_bit.bookstore.entity.TableCart;
import edu.kist_bit.bookstore.entity.TableOrder;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T17:01:48")
@StaticMetamodel(TableBook.class)
public class TableBook_ { 

    public static volatile SingularAttribute<TableBook, String> cover;
    public static volatile SingularAttribute<TableBook, Integer> pages;
    public static volatile SingularAttribute<TableBook, Double> price;
    public static volatile SingularAttribute<TableBook, String> publisher;
    public static volatile SingularAttribute<TableBook, String> categories;
    public static volatile SingularAttribute<TableBook, Date> publishedDate;
    public static volatile SingularAttribute<TableBook, Integer> bId;
    public static volatile SingularAttribute<TableBook, String> title;
    public static volatile SingularAttribute<TableBook, TableAuthor> authorId;
    public static volatile ListAttribute<TableBook, TableOrder> tableOrderList;
    public static volatile ListAttribute<TableBook, TableCart> tableCartList;

}