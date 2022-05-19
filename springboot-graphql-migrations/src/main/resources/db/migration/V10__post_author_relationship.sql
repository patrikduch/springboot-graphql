--------------------------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Association "post" entity with "author" entity.
--------------------------------------------------------------------------------------------------------------
DO $_$
BEGIN
    BEGIN
        IF NOT EXISTS (SELECT ic.column_name FROM information_schema.columns ic
            WHERE ic.table_name = 'post' AND IC.column_name = 'author_id'
                AND ic.table_schema = 'springboot_graphql') THEN

            ALTER TABLE springboot_graphql.post
                ADD author_id UUID
                    CONSTRAINT fk_author_id
                    REFERENCES springboot_graphql.author(id);

        END IF;
    END;
END $_$;