package com.esri.spark.dbf;

import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.DataFrame;
/**
 * A collection of static functions for working with dbf in Spark SQL
 */
public class DBFUtils
{
    /**
     * Returns a Schema RDD for the given dbf path.
     */
    public static DataFrame dbfFile(final SQLContext sqlContext, final String path)
    {
        final DBFRelation relation = new DBFRelation(path, sqlContext);
        return sqlContext.baseRelationToDataFrame(relation);
    }

}
