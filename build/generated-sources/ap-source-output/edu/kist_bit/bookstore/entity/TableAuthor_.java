package edu.kist_bit.bookstore.entity;

import edu.kist_bit.bookstore.entity.TableBook;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T17:01:48")
@StaticMetamodel(TableAuthor.class)
public class TableAuthor_ { 

    public static volatile SingularAttribute<TableAuthor, String> aFirstname;
    public static volatile SingularAttribute<TableAuthor, String> aLastname;
    public static volatile SingularAttribute<TableAuthor, String> contact;
    public static volatile ListAttribute<TableAuthor, TableBook> tableBookList;
    public static volatile SingularAttribute<TableAuthor, Long> aId;
    public static volatile SingularAttribute<TableAuthor, BigInteger> age;
    public static volatile SingularAttribute<TableAuthor, String> email;

}