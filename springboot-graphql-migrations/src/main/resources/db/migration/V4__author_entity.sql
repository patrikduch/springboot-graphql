--------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Creation of Author entity.
--------------------------------------------------------------------------------------------
DO $_$
BEGIN
    BEGIN
       IF NOT EXISTS (SELECT ic.column_name FROM information_schema.columns ic
            WHERE ic.table_name = 'author') THEN

                CREATE TABLE author (
                    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                    name VARCHAR(40),
                    email TEXT
                );

        END IF;
    END;
END $_$;