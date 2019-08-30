package org.tanaguru.config.test;

import java.sql.Types;

import org.hibernate.dialect.HSQLDialect;

public class CustomHSQLDialect extends HSQLDialect{
	
	public CustomHSQLDialect() {
        super();
        registerColumnType(Types.BLOB, 16777215L, "longvarbinary");
 }

}
