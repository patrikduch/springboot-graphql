---------------------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Fetch Author entity to the particular Post.
---------------------------------------------------------------------------------------------------------
DO $$ -- IF function already exists we must drop it
BEGIN

	IF EXISTS (
		SELECT format('%I.%I(%s)', ns.nspname, p.proname, oidvectortypes(p.proargtypes)), P.proname
		FROM pg_proc p INNER JOIN pg_namespace ns ON (p.pronamespace = ns.oid)
		WHERE P.proname = 'get_post_author_fn') THEN

            DROP FUNCTION springboot_graphql.get_post_author_fn;
    END IF;
END;
$$;

DO $_$ -- Function creation
BEGIN
    BEGIN

        CREATE FUNCTION springboot_graphql.get_post_author_fn(p_post_id UUID) RETURNS TABLE(
            id UUID,
            "name" VARCHAR,
            email TEXT
            )  AS $$

        BEGIN
            RETURN QUERY
                SELECT a.id, a."name", a.email FROM springboot_graphql.author a
                JOIN springboot_graphql.post p ON p.author_id  = a.id AND p.id = p_post_id;
        END
        $$ LANGUAGE plpgsql;
    END;
END $_$;