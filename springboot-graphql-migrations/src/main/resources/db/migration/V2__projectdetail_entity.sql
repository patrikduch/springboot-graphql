--------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Project Detail entity for storing basic information about this web project.
--------------------------------------------------------------------------------------------
DO $_$
BEGIN
    BEGIN
       IF NOT EXISTS (SELECT ic.column_name FROM information_schema.columns ic
            WHERE ic.table_name = 'projectdetail') THEN

                CREATE TABLE projectdetail (
                    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                    name VARCHAR(75) NOT NULL
                );

        END IF;
    END;
END $_$;