--------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Project Detail entity for storing basic information about this web project.
--------------------------------------------------------------------------------------------
DO $_$
BEGIN
    BEGIN
       IF NOT EXISTS (SELECT ic.column_name FROM information_schema.columns ic
            WHERE ic.table_name = 'projectdetail' AND ic.table_schema = 'schema_one') THEN

                CREATE TABLE schema_one.projectdetail (
                    id  SERIAL NOT NULL PRIMARY KEY,
                    name VARCHAR(75) NOT NULL
                );

        END IF;
    END;
END $_$;