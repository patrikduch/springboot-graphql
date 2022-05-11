--------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Creation of Post entity.
--------------------------------------------------------------------------------------------
DO $_$
BEGIN
    BEGIN
       IF NOT EXISTS (SELECT ic.column_name FROM information_schema.columns ic
            WHERE ic.table_name = 'post') THEN

                CREATE TABLE post (
                      id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                      title VARCHAR(40),
                      description TEXT
                );

        END IF;
    END;
END $_$;